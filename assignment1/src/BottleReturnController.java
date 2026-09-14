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
  public Signal reset = new Signal("reset", Signal.INPUT);
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
  private int OK_thread_3;//sysj\bottleReturnController.sysj line: 53, column: 3
  private int BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 54, column: 3
  private WorkpieceTwin w_thread_3;//sysj\bottleReturnController.sysj line: 56, column: 3
  private int code_thread_3;//sysj\bottleReturnController.sysj line: 57, column: 3
  private int S25854 = 1;
  private int S4664 = 1;
  private int S25852 = 1;
  private int S8196 = 1;
  private int S4688 = 1;
  private int S4672 = 1;
  private int S4667 = 1;
  private int S4693 = 1;
  private int S6111 = 1;
  private int S6106 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread25860(int [] tdone, int [] ends){
        switch(S25852){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S8196){
          case 0 : 
            if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 60, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S8196=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S4688){
                case 0 : 
                  switch(S4672){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 61, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                        S4672=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4667){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                              enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 61, column: 5
                              S4667=1;
                              if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 61, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 62, column: 5
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 70, column: 5
                                S4688=1;
                                if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 72, column: 8
                                  System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 73, column: 6
                                  S4693=0;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                                    S4693=1;
                                    if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                      System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                      S4693=2;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                        S4693=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                          S4693=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                          S4693=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                            S4693=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                                S4693=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  S4693=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                      S4688=2;
                                                      S6111=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6106=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6106=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S8196=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                  currsigs.addElement(transferArmRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                            currsigs.addElement(transferArmExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                                      currsigs.addElement(motorOnOff);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                                      S4693=1;
                                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                        S4693=2;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                          S4693=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                            S4693=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                                S4693=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  S4693=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                      S4688=2;
                                                      S6111=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6106=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6106=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S8196=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                  currsigs.addElement(transferArmRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                            currsigs.addElement(transferArmExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                            S4693=3;
                                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                              S4693=4;
                                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                                S4693=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  S4693=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                      S4688=2;
                                                      S6111=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6106=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6106=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S8196=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                  currsigs.addElement(transferArmRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                                  S4693=5;
                                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                    S4693=6;
                                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                        S4688=2;
                                                        S6111=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S6106=0;
                                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S6106=1;
                                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                              S8196=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S4688=2;
                                                      S6111=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6106=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6106=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S8196=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                    currsigs.addElement(transferArmRetract);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                              currsigs.addElement(transferArmExtend);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
                                }
                                else {
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 61, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 62, column: 5
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 70, column: 5
                              S4688=1;
                              if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 72, column: 8
                                System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 73, column: 6
                                S4693=0;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                                  S4693=1;
                                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                    S4693=2;
                                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                      S4693=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                        S4693=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                          S4693=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                            S4693=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S4688=2;
                                              S6111=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6106=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6106=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S8196=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                        currsigs.addElement(transferArmExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                        S4693=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                          S4693=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                                    currsigs.addElement(motorOnOff);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                                    S4693=1;
                                    if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                      System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                      S4693=2;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                        S4693=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                          S4693=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                          S4693=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                            S4693=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                                S4693=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  S4693=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                      S4688=2;
                                                      S6111=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6106=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S6106=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                            S8196=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                  currsigs.addElement(transferArmRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                            currsigs.addElement(transferArmExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
                              }
                              else {
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                      S4672=1;
                      S4672=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 61, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                        S4672=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4667=0;
                        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 61, column: 5
                          S4667=1;
                          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 61, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 62, column: 5
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 70, column: 5
                            S4688=1;
                            if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 72, column: 8
                              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 73, column: 6
                              S4693=0;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                                S4693=1;
                                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                  S4693=2;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                    S4693=3;
                                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                      S4693=4;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                        S4693=5;
                                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                          S4693=6;
                                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                              S4688=2;
                                              S6111=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6106=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6106=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S8196=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S4688=2;
                                            S6111=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6106=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6106=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S8196=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                          currsigs.addElement(transferArmRetract);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                          S4693=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                            S4693=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S4688=2;
                                              S6111=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6106=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6106=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S8196=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                      currsigs.addElement(transferArmExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                      S4693=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                        S4693=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                          S4693=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                            S4693=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S4688=2;
                                              S6111=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6106=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6106=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S8196=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                        currsigs.addElement(transferArmExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                                  currsigs.addElement(motorOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                                  S4693=1;
                                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                                    S4693=2;
                                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                                      S4693=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                        S4693=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                          S4693=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                            S4693=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S4688=2;
                                              S6111=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6106=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6106=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S8196=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                        currsigs.addElement(transferArmExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                        S4693=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                          S4693=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                            S4693=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                              S4693=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S4688=2;
                                                S6111=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S6111=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6106=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6106=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S8196=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                              S4693=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                                S4693=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                                    S4688=2;
                                                    S6111=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6106=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S6106=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                          S8196=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S4688=2;
                                                  S6111=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                    S6111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6106=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                      S6106=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                        S8196=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
                            }
                            else {
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                  switch(S4693){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                        S4693=1;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                          S4693=2;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                            S4693=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                              S4693=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                S4693=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                  S4693=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                              currsigs.addElement(transferArmExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                              S4693=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                S4693=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                          S4693=1;
                          if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                            System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                            S4693=2;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                              S4693=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                S4693=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                S4693=3;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                  S4693=4;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                      S4693=5;
                                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                        S4693=6;
                                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                            S4688=2;
                                            S6111=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6106=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6106=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S8196=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                        currsigs.addElement(transferArmRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                  currsigs.addElement(transferArmExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
                      break;
                    
                    case 1 : 
                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                        S4693=2;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                          S4693=3;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                            S4693=4;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                              S4693=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                S4693=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                S4693=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                  S4693=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                            currsigs.addElement(transferArmExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                            S4693=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                              S4693=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                S4693=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                  S4693=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                              currsigs.addElement(transferArmExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                        currsigs.addElement(motorOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                        S4693=3;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                          S4693=4;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                            S4693=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                              S4693=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                              S4693=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                S4693=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                          S4693=3;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                            S4693=4;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                              S4693=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                S4693=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                S4693=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                  S4693=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                            currsigs.addElement(transferArmExtend);
                            active[3]=1;
                            ends[3]=1;
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
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                        S4693=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                          S4693=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                            S4693=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                            S4693=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                              S4693=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                        S4693=5;
                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                          S4693=6;
                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            S4688=2;
                            S6111=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                              S6111=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6106=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6106=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S8196=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                          currsigs.addElement(transferArmRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                          S4693=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                            S4693=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 5 : 
                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                        S4693=6;
                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                            S4688=2;
                            S6111=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                              S6111=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6106=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6106=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S8196=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          S4688=2;
                          S6111=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                            S6111=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S6106=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                              S6106=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                S8196=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                        currsigs.addElement(transferArmRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 6 : 
                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                        S4688=2;
                        S6111=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                          S6111=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S6106=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                            S6106=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                              S8196=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                  switch(S6111){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                        S6111=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S6106){
                          case 0 : 
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                              S6106=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                S8196=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                              S8196=1;
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
                      S6111=1;
                      S6111=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                        S6111=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S6106=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                          S6106=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                            S8196=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S8196=1;
            S8196=0;
            if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 60, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S8196=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S4688=0;
              S4672=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 61, column: 5
                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                S4672=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4667=0;
                if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                  enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 61, column: 5
                  S4667=1;
                  if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
                    enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
                    ends[3]=2;
                    ;//sysj\bottleReturnController.sysj line: 61, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 62, column: 5
                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 70, column: 5
                    S4688=1;
                    if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 72, column: 8
                      System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 73, column: 6
                      S4693=0;
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                        S4693=1;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                          S4693=2;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                            S4693=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                              S4693=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                S4693=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                  S4693=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                              currsigs.addElement(transferArmExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                              S4693=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                S4693=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                          S4693=1;
                          if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                            System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                            S4693=2;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                              S4693=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                S4693=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                  S4693=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                    S4693=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S4688=2;
                                      S6111=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6106=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6106=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S8196=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                                S4693=3;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                                  S4693=4;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                                    S4693=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                      S4693=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S4688=2;
                                        S6111=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S6111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6106=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6106=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S8196=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                                      S4693=5;
                                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                        S4693=6;
                                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                            S4688=2;
                                            S6111=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6106=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S6106=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                  S8196=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S4688=2;
                                          S6111=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                            S6111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6106=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                              S6106=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                                S8196=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                        currsigs.addElement(transferArmRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                                  currsigs.addElement(transferArmExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
                    }
                    else {
                      S4688=2;
                      S6111=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                        S6111=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S6106=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                          S6106=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 104, column: 5
                            S8196=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread25859(int [] tdone, int [] ends){
        switch(S4664){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 42, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 45, column: 8
            auto_1.setPresent();//sysj\bottleReturnController.sysj line: 45, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\bottleReturnController.sysj line: 46, column: 13
              manual_1.setPresent();//sysj\bottleReturnController.sysj line: 46, column: 35
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

  public void thread25857(int [] tdone, int [] ends){
        S25852=1;
    OK_thread_3 = 0;//sysj\bottleReturnController.sysj line: 53, column: 3
    BLOCKED_thread_3 = 2;//sysj\bottleReturnController.sysj line: 54, column: 3
    w_thread_3 = null;//sysj\bottleReturnController.sysj line: 56, column: 3
    code_thread_3 = 0;//sysj\bottleReturnController.sysj line: 57, column: 3
    S8196=0;
    if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 60, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S8196=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S4688=0;
      S4672=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 61, column: 5
        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
        S4672=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4667=0;
        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 61, column: 5
          S4667=1;
          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 61, column: 5
            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 61, column: 5
            ends[3]=2;
            ;//sysj\bottleReturnController.sysj line: 61, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 62, column: 5
            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 70, column: 5
            S4688=1;
            if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 72, column: 8
              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 73, column: 6
              S4693=0;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 22
                S4693=1;
                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                  S4693=2;
                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                    S4693=3;
                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                      S4693=4;
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                        S4693=5;
                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                          S4693=6;
                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            S4688=2;
                            S6111=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                              S6111=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6106=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6106=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S8196=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                          currsigs.addElement(transferArmRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                          S4693=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                            S4693=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                      currsigs.addElement(transferArmExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                      S4693=3;
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                        S4693=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                          S4693=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                            S4693=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                            S4693=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                              S4693=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
                  currsigs.addElement(motorOnOff);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 75, column: 45
                  S4693=1;
                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 76, column: 22
                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 79, column: 6
                    S4693=2;
                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 22
                      S4693=3;
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                        S4693=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                          S4693=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                            S4693=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S4688=2;
                              S6111=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                S6111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6106=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6106=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S8196=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                            S4693=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                              S4693=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 81, column: 45
                        S4693=3;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 82, column: 22
                          S4693=4;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 22
                            S4693=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                              S4693=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S4688=2;
                                S6111=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                  S6111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6106=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6106=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S8196=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 86, column: 45
                              S4693=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 87, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 91, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 92, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 94, column: 6
                                S4693=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 95, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 96, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 97, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 99, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 100, column: 22
                                    S4688=2;
                                    S6111=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6106=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S6106=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                          S8196=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S4688=2;
                                  S6111=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                    S6111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6106=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                                      S6106=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 104, column: 5
                                        S8196=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 88, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 83, column: 7
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
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
                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 77, column: 7
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
            }
            else {
              S4688=2;
              S6111=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 104, column: 5
                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                S6111=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S6106=0;
                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 104, column: 5
                  S6106=1;
                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 104, column: 5
                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 104, column: 5
                    ends[3]=2;
                    ;//sysj\bottleReturnController.sysj line: 104, column: 5
                    S8196=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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

  public void thread25856(int [] tdone, int [] ends){
        S4664=1;
    if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 42, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 45, column: 8
        auto_1.setPresent();//sysj\bottleReturnController.sysj line: 45, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\bottleReturnController.sysj line: 46, column: 13
          manual_1.setPresent();//sysj\bottleReturnController.sysj line: 46, column: 35
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
      switch(S25854){
        case 0 : 
          S25854=0;
          break RUN;
        
        case 1 : 
          S25854=2;
          S25854=2;
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 38, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 38, column: 2
          thread25856(tdone,ends);
          thread25857(tdone,ends);
          int biggest25858 = 0;
          if(ends[2]>=biggest25858){
            biggest25858=ends[2];
          }
          if(ends[3]>=biggest25858){
            biggest25858=ends[3];
          }
          if(biggest25858 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 38, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 38, column: 2
          thread25859(tdone,ends);
          thread25860(tdone,ends);
          int biggest25861 = 0;
          if(ends[2]>=biggest25861){
            biggest25861=ends[2];
          }
          if(ends[3]>=biggest25861){
            biggest25861=ends[3];
          }
          if(biggest25861 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest25861 == 0){
            S25854=0;
            active[1]=0;
            ends[1]=0;
            S25854=0;
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
      reset.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
        reset.gethook();
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
