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
  private Workpiece w_thread_3;//sysj\bottleReturnController.sysj line: 53, column: 3
  private int code_thread_3;//sysj\bottleReturnController.sysj line: 54, column: 3
  private int S12102 = 1;
  private int S4887 = 1;
  private int S11813 = 1;
  private int S6042 = 1;
  private int S4912 = 1;
  private int S4896 = 1;
  private int S4891 = 1;
  private int S4993 = 1;
  private int S4988 = 1;
  private int S12100 = 1;
  private int S11908 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread12110(int [] tdone, int [] ends){
        switch(S12100){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S11908){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 94, column: 20
              S11908=1;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 20
                S11908=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 97, column: 28
                  currsigs.addElement(motorOnOff);
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 20
              S11908=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 97, column: 28
                currsigs.addElement(motorOnOff);
                if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                  currsigs.addElement(transferArmExtend);
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                  currsigs.addElement(transferArmExtend);
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
            S11908=2;
            S11908=0;
            if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 94, column: 20
              S11908=1;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 20
                S11908=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 97, column: 28
                  currsigs.addElement(motorOnOff);
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                  if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
                    currsigs.addElement(transferArmExtend);
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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

  public void thread12109(int [] tdone, int [] ends){
        switch(S11813){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S6042){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
              S6042=1;
              if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S6042=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4912=0;
                S4896=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                  enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                  S4896=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S4891=0;
                  if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                    enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                    S4891=1;
                    if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                      enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                      ends[3]=2;
                      ;//sysj\bottleReturnController.sysj line: 60, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                      System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
                      S4912=1;
                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                        S4912=2;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                          S4912=3;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                              S4912=4;
                              S4993=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                S4993=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S4988=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                  S4988=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                    S6042=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              S4912=4;
                              S4993=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                S4993=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S4988=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                  S4988=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                    S6042=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                        currsigs.addElement(motorOnOff);
                        active[3]=1;
                        ends[3]=1;
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
              S6042=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S4912){
                case 0 : 
                  switch(S4896){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                        S4896=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4891){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                              enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                              S4891=1;
                              if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 60, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                                System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
                                S4912=1;
                                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                                  S4912=2;
                                  if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                                    S4912=3;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                                        S4912=4;
                                        S4993=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S4993=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S4988=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                            S4988=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                              S6042=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        S4912=4;
                                        S4993=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S4993=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S4988=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                            S4988=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                              S6042=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                                    currsigs.addElement(transferArmExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                                  currsigs.addElement(motorOnOff);
                                  active[3]=1;
                                  ends[3]=1;
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
                            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 60, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
                              S4912=1;
                              if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                                System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                                S4912=2;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                                  S4912=3;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                                      S4912=4;
                                      S4993=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                        S4993=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S4988=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S4988=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                            S6042=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      S4912=4;
                                      S4993=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                        S4993=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S4988=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S4988=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                            S6042=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                                  currsigs.addElement(transferArmExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                                currsigs.addElement(motorOnOff);
                                active[3]=1;
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
                      S4896=1;
                      S4896=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                        S4896=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4891=0;
                        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                          S4891=1;
                          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 60, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                            System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
                            S4912=1;
                            if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                              System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                              S4912=2;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                                S4912=3;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                                    S4912=4;
                                    S4993=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                      S4993=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S4988=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                        S4988=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S6042=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    S4912=4;
                                    S4993=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                      S4993=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S4988=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                        S4988=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                          S6042=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                              currsigs.addElement(motorOnOff);
                              active[3]=1;
                              ends[3]=1;
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
                
                case 1 : 
                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                    S4912=2;
                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                      S4912=3;
                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                          S4912=4;
                          S4993=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            S4993=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S4988=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                              S4988=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                S6042=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          S4912=4;
                          S4993=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            S4993=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S4988=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                              S4988=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                S6042=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                        currsigs.addElement(transferArmRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                      currsigs.addElement(transferArmExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                    currsigs.addElement(motorOnOff);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                    S4912=3;
                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                        S4912=4;
                        S4993=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4993=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S4988=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                            S4988=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 86, column: 5
                              S6042=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        S4912=4;
                        S4993=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4993=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S4988=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                            S4988=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 86, column: 5
                              S6042=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                      currsigs.addElement(transferArmRetract);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                    currsigs.addElement(transferArmExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                      S4912=4;
                      S4993=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4988=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4988=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                            S6042=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                      S4912=4;
                      S4993=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4988=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4988=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                            S6042=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                    currsigs.addElement(transferArmRetract);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  switch(S4993){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4988){
                          case 0 : 
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                              S4988=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                S6042=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 86, column: 5
                              S6042=2;
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
                      S4993=1;
                      S4993=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4988=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4988=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                            S6042=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S6042=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S6042=2;
            S6042=0;
            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
              S6042=1;
              if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S6042=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4912=0;
                S4896=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
                  enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                  S4896=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S4891=0;
                  if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                    enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
                    S4891=1;
                    if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
                      enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
                      ends[3]=2;
                      ;//sysj\bottleReturnController.sysj line: 60, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
                      System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
                      S4912=1;
                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                        S4912=2;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                          S4912=3;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                              S4912=4;
                              S4993=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                S4993=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S4988=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                  S4988=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                    S6042=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              S4912=4;
                              S4993=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                S4993=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S4988=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                                  S4988=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 86, column: 5
                                    S6042=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                        currsigs.addElement(motorOnOff);
                        active[3]=1;
                        ends[3]=1;
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

  public void thread12108(int [] tdone, int [] ends){
        switch(S4887){
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

  public void thread12106(int [] tdone, int [] ends){
        S12100=1;
    S11908=0;
    if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 94, column: 20
      S11908=1;
      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 20
        S11908=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 97, column: 28
          currsigs.addElement(motorOnOff);
          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
            currsigs.addElement(transferArmExtend);
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 98, column: 14
            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 98, column: 35
            currsigs.addElement(transferArmExtend);
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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
            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 14
              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 99, column: 36
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

  public void thread12105(int [] tdone, int [] ends){
        S11813=1;
    OK_thread_3 = 0;//sysj\bottleReturnController.sysj line: 50, column: 3
    BLOCKED_thread_3 = 2;//sysj\bottleReturnController.sysj line: 51, column: 3
    w_thread_3 = null;//sysj\bottleReturnController.sysj line: 53, column: 3
    code_thread_3 = 0;//sysj\bottleReturnController.sysj line: 54, column: 3
    S6042=0;
    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 57, column: 20
      S6042=1;
      if(manual_1.getprestatus()){//sysj\bottleReturnController.sysj line: 59, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S6042=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4912=0;
        S4896=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 60, column: 5
          enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
          S4896=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S4891=0;
          if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
            enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 60, column: 5
            S4891=1;
            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 60, column: 5
              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 60, column: 5
              ends[3]=2;
              ;//sysj\bottleReturnController.sysj line: 60, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 61, column: 5
              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 62, column: 5
              S4912=1;
              if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 64, column: 21
                System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 67, column: 5
                S4912=2;
                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 69, column: 21
                  S4912=3;
                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 73, column: 21
                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 77, column: 5
                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 78, column: 5
                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 80, column: 5
                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 13
                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 82, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 83, column: 6
                      S4912=4;
                      S4993=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4988=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4988=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                            S6042=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                      S4912=4;
                      S4993=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 86, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                        S4993=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4988=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 86, column: 5
                          S4988=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 86, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 86, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 86, column: 5
                            S6042=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 74, column: 6
                    currsigs.addElement(transferArmRetract);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 70, column: 6
                  currsigs.addElement(transferArmExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 65, column: 6
                currsigs.addElement(motorOnOff);
                active[3]=1;
                ends[3]=1;
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
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread12104(int [] tdone, int [] ends){
        S4887=1;
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
      switch(S12102){
        case 0 : 
          S12102=0;
          break RUN;
        
        case 1 : 
          S12102=2;
          S12102=2;
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          thread12104(tdone,ends);
          thread12105(tdone,ends);
          thread12106(tdone,ends);
          int biggest12107 = 0;
          if(ends[2]>=biggest12107){
            biggest12107=ends[2];
          }
          if(ends[3]>=biggest12107){
            biggest12107=ends[3];
          }
          if(ends[4]>=biggest12107){
            biggest12107=ends[4];
          }
          if(biggest12107 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 37, column: 2
          thread12108(tdone,ends);
          thread12109(tdone,ends);
          thread12110(tdone,ends);
          int biggest12111 = 0;
          if(ends[2]>=biggest12111){
            biggest12111=ends[2];
          }
          if(ends[3]>=biggest12111){
            biggest12111=ends[3];
          }
          if(ends[4]>=biggest12111){
            biggest12111=ends[4];
          }
          if(biggest12111 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest12111 == 0){
            S12102=0;
            active[1]=0;
            ends[1]=0;
            S12102=0;
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
