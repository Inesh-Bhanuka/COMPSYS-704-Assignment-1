import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BottleReturnController extends ClockDomain{
  public BottleReturnController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal bottleAtCollector = new Signal("bottleAtCollector", Signal.INPUT);
  public Signal armAtHome = new Signal("armAtHome", Signal.INPUT);
  public Signal armAtLoader = new Signal("armAtLoader", Signal.INPUT);
  public Signal collectorBinFull = new Signal("collectorBinFull", Signal.INPUT);
  public Signal motorOnOffM = new Signal("motorOnOffM", Signal.INPUT);
  public Signal transferArmExtendM = new Signal("transferArmExtendM", Signal.INPUT);
  public Signal transferArmRetractM = new Signal("transferArmRetractM", Signal.INPUT);
  public Signal motorOnOff = new Signal("motorOnOff", Signal.OUTPUT);
  public Signal transferArmExtend = new Signal("transferArmExtend", Signal.OUTPUT);
  public Signal transferArmRetract = new Signal("transferArmRetract", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\bottleReturnController.sysj line: 50, column: 3
  private int BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 51, column: 3
  private WorkpieceTwin w_thread_3;//sysj\bottleReturnController.sysj line: 53, column: 3
  private int code_thread_3;//sysj\bottleReturnController.sysj line: 54, column: 3
  private int S18786 = 1;
  private int S7143 = 1;
  private int S18497 = 1;
  private int S9036 = 1;
  private int S7168 = 1;
  private int S7152 = 1;
  private int S7147 = 1;
  private int S7177 = 1;
  private int S7407 = 1;
  private int S7402 = 1;
  private int S18784 = 1;
  private int S18592 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread18794(int [] tdone, int [] ends){
        switch(S18784){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S18592){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 108, column: 20
              S18592=1;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 109, column: 20
                S18592=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 111, column: 14
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 111, column: 28
                  currsigs.addElement(motorOnOff);
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 109, column: 20
              S18592=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 111, column: 14
                motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 111, column: 28
                currsigs.addElement(motorOnOff);
                if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                  currsigs.addElement(transferArmExtend);
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                    currsigs.addElement(transferArmRetract);
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
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                    currsigs.addElement(transferArmRetract);
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
                if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                  currsigs.addElement(transferArmExtend);
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                    currsigs.addElement(transferArmRetract);
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
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                    currsigs.addElement(transferArmRetract);
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
            S18592=2;
            S18592=0;
            if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 108, column: 20
              S18592=1;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 109, column: 20
                S18592=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 111, column: 14
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 111, column: 28
                  currsigs.addElement(motorOnOff);
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
                      currsigs.addElement(transferArmRetract);
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

  public void thread18793(int [] tdone, int [] ends){
        switch(S18497){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S9036){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
              S9036=1;
              if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S9036=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S7168=0;
                S7152=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                  enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                  S7152=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S7147=0;
                  if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                    enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                    S7147=1;
                    if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                      enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                      ends[3]=2;
                      ;//sysj\bottleReturnController.sysj line: 60, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
                      S7168=1;
                      if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                        System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                        S7177=0;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                          S7177=1;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                            S7177=2;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                              S7177=3;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                  S7168=2;
                                  S7407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S7402=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S7402=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                        S9036=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S7168=2;
                                S7407=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7407=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S7402=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7402=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S9036=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                            currsigs.addElement(transferArmExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S7168=2;
                        S7407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                          S7407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S7402=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7402=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                              S9036=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
            if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S9036=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S7168){
                case 0 : 
                  switch(S7152){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                        S7152=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S7147){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                              enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                              S7147=1;
                              if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 60, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
                                S7168=1;
                                if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                                  System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                                  S7177=0;
                                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                                    S7177=1;
                                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                                      S7177=2;
                                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                                        S7177=3;
                                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                            S7168=2;
                                            S7407=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                              S7407=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S7402=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                                S7402=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                                  S9036=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S7168=2;
                                          S7407=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                            S7407=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S7402=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                              S7402=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                                S9036=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                                        currsigs.addElement(transferArmRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                                      currsigs.addElement(transferArmExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                                    currsigs.addElement(motorOnOff);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S7168=2;
                                  S7407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S7402=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S7402=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                        S9036=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 60, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
                              S7168=1;
                              if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                                System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                                S7177=0;
                                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                                  S7177=1;
                                  if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                                    S7177=2;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                                      S7177=3;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                          S7168=2;
                                          S7407=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                            S7407=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S7402=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                              S7402=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                                S9036=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S7168=2;
                                        S7407=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                          S7407=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S7402=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                            S7402=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                              S9036=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                                    currsigs.addElement(transferArmExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                                  currsigs.addElement(motorOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S7168=2;
                                S7407=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7407=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S7402=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7402=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S9036=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                      }
                      break;
                    
                    case 1 : 
                      S7152=1;
                      S7152=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                        S7152=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S7147=0;
                        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                          S7147=1;
                          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 60, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
                            S7168=1;
                            if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                              S7177=0;
                              if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                                System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                                S7177=1;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                                  S7177=2;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                                    S7177=3;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                        S7168=2;
                                        S7407=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                          S7407=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S7402=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                            S7402=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                              S9036=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S7168=2;
                                      S7407=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                        S7407=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S7402=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                          S7402=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                            S9036=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                                  currsigs.addElement(transferArmExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                                currsigs.addElement(motorOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S7168=2;
                              S7407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                S7407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S7402=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7402=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S9036=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  switch(S7177){
                    case 0 : 
                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                        S7177=1;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                          S7177=2;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                            S7177=3;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                S7168=2;
                                S7407=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7407=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S7402=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7402=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S9036=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S7168=2;
                              S7407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                S7407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S7402=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7402=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S9036=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                        currsigs.addElement(motorOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                        S7177=2;
                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                          S7177=3;
                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                              S7168=2;
                              S7407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                S7407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S7402=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7402=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S9036=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            S7168=2;
                            S7407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              S7407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S7402=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                S7402=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S9036=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                          currsigs.addElement(transferArmRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                        S7177=3;
                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                            S7168=2;
                            S7407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              S7407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S7402=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                S7402=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S9036=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          S7168=2;
                          S7407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S7402=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                              S7402=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                S9036=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                        currsigs.addElement(transferArmRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 3 : 
                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                        S7168=2;
                        S7407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                          S7407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S7402=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7402=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                              S9036=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                
                case 2 : 
                  switch(S7407){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                        S7407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S7402){
                          case 0 : 
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                              S7402=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                S9036=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                              S9036=2;
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
                      S7407=1;
                      S7407=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                        S7407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S7402=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                          S7402=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 100, column: 5
                            S9036=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S9036=2;
            S9036=0;
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
              S9036=1;
              if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S9036=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S7168=0;
                S7152=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                  enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                  S7152=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S7147=0;
                  if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                    enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                    S7147=1;
                    if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                      enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                      ends[3]=2;
                      ;//sysj\bottleReturnController.sysj line: 60, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
                      S7168=1;
                      if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                        System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                        S7177=0;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                          S7177=1;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                            S7177=2;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                              S7177=3;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                                  S7168=2;
                                  S7407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S7402=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S7402=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                        S9036=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S7168=2;
                                S7407=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                  S7407=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S7402=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                                    S7402=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                      S9036=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                            currsigs.addElement(transferArmExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S7168=2;
                        S7407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                          S7407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S7402=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7402=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                              S9036=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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

  public void thread18792(int [] tdone, int [] ends){
        switch(S7143){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 41, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 42, column: 8
            auto_1.setPresent();//sysj\bottleReturnController.sysj line: 42, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\bottleReturnController.sysj line: 43, column: 12
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

  public void thread18790(int [] tdone, int [] ends){
        S18784=1;
    S18592=0;
    if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 108, column: 20
      S18592=1;
      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 109, column: 20
        S18592=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 111, column: 14
          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 111, column: 28
          currsigs.addElement(motorOnOff);
          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
            currsigs.addElement(transferArmExtend);
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
              currsigs.addElement(transferArmRetract);
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
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
              currsigs.addElement(transferArmRetract);
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
          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 112, column: 14
            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 112, column: 35
            currsigs.addElement(transferArmExtend);
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
              currsigs.addElement(transferArmRetract);
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
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 113, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 113, column: 36
              currsigs.addElement(transferArmRetract);
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

  public void thread18789(int [] tdone, int [] ends){
        S18497=1;
    OK_thread_3 = 0;//sysj\bottleReturnController.sysj line: 50, column: 3
    BLOCKED_thread_3 = 2;//sysj\bottleReturnController.sysj line: 51, column: 3
    w_thread_3 = null;//sysj\bottleReturnController.sysj line: 53, column: 3
    code_thread_3 = 0;//sysj\bottleReturnController.sysj line: 54, column: 3
    S9036=0;
    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
      S9036=1;
      if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S9036=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S7168=0;
        S7152=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
          enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
          S7152=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S7147=0;
          if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
            enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
            S7147=1;
            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
              ends[3]=2;
              ;//sysj\bottleReturnController.sysj line: 60, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 69, column: 5
              S7168=1;
              if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 71, column: 8
                System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 72, column: 6
                S7177=0;
                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 74, column: 22
                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 77, column: 6
                  S7177=1;
                  if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 79, column: 22
                    S7177=2;
                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 87, column: 6
                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 88, column: 6
                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 90, column: 6
                      S7177=3;
                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 91, column: 14
                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 92, column: 7
                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 93, column: 7
                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 38
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 22
                          S7168=2;
                          S7407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S7402=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                              S7402=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 100, column: 5
                                S9036=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S7168=2;
                        S7407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                          S7407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S7402=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                            S7402=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 100, column: 5
                              S9036=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 84, column: 7
                      currsigs.addElement(transferArmRetract);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 80, column: 7
                    currsigs.addElement(transferArmExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 75, column: 7
                  currsigs.addElement(motorOnOff);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S7168=2;
                S7407=0;
                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 100, column: 5
                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                  S7407=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S7402=0;
                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 100, column: 5
                    S7402=1;
                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 100, column: 5
                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 100, column: 5
                      ends[3]=2;
                      ;//sysj\bottleReturnController.sysj line: 100, column: 5
                      S9036=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
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

  public void thread18788(int [] tdone, int [] ends){
        S7143=1;
    if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 41, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 42, column: 8
        auto_1.setPresent();//sysj\bottleReturnController.sysj line: 42, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\bottleReturnController.sysj line: 43, column: 12
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
      switch(S18786){
        case 0 : 
          S18786=0;
          break RUN;
        
        case 1 : 
          S18786=2;
          S18786=2;
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          thread18788(tdone,ends);
          thread18789(tdone,ends);
          thread18790(tdone,ends);
          int biggest18791 = 0;
          if(ends[2]>=biggest18791){
            biggest18791=ends[2];
          }
          if(ends[3]>=biggest18791){
            biggest18791=ends[3];
          }
          if(ends[4]>=biggest18791){
            biggest18791=ends[4];
          }
          if(biggest18791 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          thread18792(tdone,ends);
          thread18793(tdone,ends);
          thread18794(tdone,ends);
          int biggest18795 = 0;
          if(ends[2]>=biggest18795){
            biggest18795=ends[2];
          }
          if(ends[3]>=biggest18795){
            biggest18795=ends[3];
          }
          if(ends[4]>=biggest18795){
            biggest18795=ends[4];
          }
          if(biggest18795 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest18795 == 0){
            S18786=0;
            active[1]=0;
            ends[1]=0;
            S18786=0;
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
          bottleAtCollector.gethook();
          armAtHome.gethook();
          armAtLoader.gethook();
          collectorBinFull.gethook();
          motorOnOffM.gethook();
          transferArmExtendM.gethook();
          transferArmRetractM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtCollector.setpreclear();
      armAtHome.setpreclear();
      armAtLoader.setpreclear();
      collectorBinFull.setpreclear();
      motorOnOffM.setpreclear();
      transferArmExtendM.setpreclear();
      transferArmRetractM.setpreclear();
      motorOnOff.setpreclear();
      transferArmExtend.setpreclear();
      transferArmRetract.setpreclear();
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
      dummyint = bottleAtCollector.getStatus() ? bottleAtCollector.setprepresent() : bottleAtCollector.setpreclear();
      bottleAtCollector.setpreval(bottleAtCollector.getValue());
      bottleAtCollector.setClear();
      dummyint = armAtHome.getStatus() ? armAtHome.setprepresent() : armAtHome.setpreclear();
      armAtHome.setpreval(armAtHome.getValue());
      armAtHome.setClear();
      dummyint = armAtLoader.getStatus() ? armAtLoader.setprepresent() : armAtLoader.setpreclear();
      armAtLoader.setpreval(armAtLoader.getValue());
      armAtLoader.setClear();
      dummyint = collectorBinFull.getStatus() ? collectorBinFull.setprepresent() : collectorBinFull.setpreclear();
      collectorBinFull.setpreval(collectorBinFull.getValue());
      collectorBinFull.setClear();
      dummyint = motorOnOffM.getStatus() ? motorOnOffM.setprepresent() : motorOnOffM.setpreclear();
      motorOnOffM.setpreval(motorOnOffM.getValue());
      motorOnOffM.setClear();
      dummyint = transferArmExtendM.getStatus() ? transferArmExtendM.setprepresent() : transferArmExtendM.setpreclear();
      transferArmExtendM.setpreval(transferArmExtendM.getValue());
      transferArmExtendM.setClear();
      dummyint = transferArmRetractM.getStatus() ? transferArmRetractM.setprepresent() : transferArmRetractM.setpreclear();
      transferArmRetractM.setpreval(transferArmRetractM.getValue());
      transferArmRetractM.setClear();
      motorOnOff.sethook();
      motorOnOff.setClear();
      transferArmExtend.sethook();
      transferArmExtend.setClear();
      transferArmRetract.sethook();
      transferArmRetract.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        bottleAtCollector.gethook();
        armAtHome.gethook();
        armAtLoader.gethook();
        collectorBinFull.gethook();
        motorOnOffM.gethook();
        transferArmExtendM.gethook();
        transferArmRetractM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
