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
  private int OK_thread_3;//sysj\bottleReturnController.sysj line: 55, column: 3
  private int BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 56, column: 3
  private WorkpieceTwin w_thread_3;//sysj\bottleReturnController.sysj line: 58, column: 3
  private int code_thread_3;//sysj\bottleReturnController.sysj line: 59, column: 3
  private int S25848 = 1;
  private int S4658 = 1;
  private int S25846 = 1;
  private int S8190 = 1;
  private int S4682 = 1;
  private int S4666 = 1;
  private int S4661 = 1;
  private int S4687 = 1;
  private int S6105 = 1;
  private int S6100 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread25854(int [] tdone, int [] ends){
        switch(S25846){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S8190){
          case 0 : 
            if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 62, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S8190=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S4682){
                case 0 : 
                  switch(S4666){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 63, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                        S4666=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4661){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                              enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 63, column: 5
                              S4661=1;
                              if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 63, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 64, column: 5
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 72, column: 5
                                S4682=1;
                                if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 74, column: 8
                                  System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 75, column: 6
                                  S4687=0;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                                    S4687=1;
                                    if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                      System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                      S4687=2;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                        S4687=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                          S4687=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                          S4687=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                            S4687=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                                S4687=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                  S4687=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                      S4682=2;
                                                      S6105=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6105=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6100=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6100=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S8190=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
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
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                      motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                                      currsigs.addElement(motorOnOff);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                                      S4687=1;
                                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                        S4687=2;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                          S4687=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                            S4687=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                                S4687=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                  S4687=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                      S4682=2;
                                                      S6105=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6105=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6100=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6100=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S8190=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
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
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                            currsigs.addElement(transferArmExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                            S4687=3;
                                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                              S4687=4;
                                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                                S4687=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                  S4687=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                      S4682=2;
                                                      S6105=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6105=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6100=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6100=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S8190=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
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
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                                  currsigs.addElement(transferArmRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                                  S4687=5;
                                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                    S4687=6;
                                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                        S4682=2;
                                                        S6105=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6105=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S6100=0;
                                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S6100=1;
                                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                              S8190=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
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
                                                      S4682=2;
                                                      S6105=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6105=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6100=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6100=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S8190=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                            if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                              enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 63, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 64, column: 5
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 72, column: 5
                              S4682=1;
                              if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 74, column: 8
                                System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 75, column: 6
                                S4687=0;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                                  S4687=1;
                                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                    S4687=2;
                                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                      S4687=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                        S4687=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                          S4687=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                            S4687=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              S4682=2;
                                              S6105=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6105=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6100=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6100=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S8190=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                        currsigs.addElement(transferArmExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                        S4687=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                          S4687=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                                    currsigs.addElement(motorOnOff);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                                    S4687=1;
                                    if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                      System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                      S4687=2;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                        S4687=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                          S4687=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                          currsigs.addElement(transferArmExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                          S4687=3;
                                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                            S4687=4;
                                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                                currsigs.addElement(transferArmRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                                S4687=5;
                                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                  S4687=6;
                                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                      S4682=2;
                                                      S6105=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6105=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S6100=0;
                                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S6100=1;
                                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                            S8190=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
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
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                      motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                      S4666=1;
                      S4666=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 63, column: 5
                        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                        S4666=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4661=0;
                        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 63, column: 5
                          S4661=1;
                          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 63, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 64, column: 5
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 72, column: 5
                            S4682=1;
                            if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 74, column: 8
                              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 75, column: 6
                              S4687=0;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                                S4687=1;
                                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                  S4687=2;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                    S4687=3;
                                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                      S4687=4;
                                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                        S4687=5;
                                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                          S4687=6;
                                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                              S4682=2;
                                              S6105=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6105=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6100=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6100=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S8190=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                            S4682=2;
                                            S6105=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6105=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6100=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6100=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S8190=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                          currsigs.addElement(transferArmRetract);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                          S4687=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                            S4687=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              S4682=2;
                                              S6105=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6105=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6100=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6100=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S8190=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                      currsigs.addElement(transferArmExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                      S4687=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                        S4687=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                          S4687=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                            S4687=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              S4682=2;
                                              S6105=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6105=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6100=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6100=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S8190=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                                  currsigs.addElement(motorOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                                  S4687=1;
                                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                                    S4687=2;
                                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                                      S4687=3;
                                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                        S4687=4;
                                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                          S4687=5;
                                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                            S4687=6;
                                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              S4682=2;
                                              S6105=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6105=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S6100=0;
                                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6100=1;
                                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S8190=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                            currsigs.addElement(transferArmRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                        currsigs.addElement(transferArmExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                        S4687=3;
                                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                          S4687=4;
                                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                            S4687=5;
                                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                              S4687=6;
                                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                S4682=2;
                                                S6105=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S6105=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S6100=0;
                                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6100=1;
                                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S8190=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                              currsigs.addElement(transferArmRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                              S4687=5;
                                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                                S4687=6;
                                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                                    S4682=2;
                                                    S6105=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6105=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S6100=0;
                                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S6100=1;
                                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                          S8190=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                                  S4682=2;
                                                  S6105=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                    S6105=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S6100=0;
                                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                      S6100=1;
                                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                        S8190=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                  switch(S4687){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                        S4687=1;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                          S4687=2;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                            S4687=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                              S4687=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                S4687=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                  S4687=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                              currsigs.addElement(transferArmExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                              S4687=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                S4687=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                          S4687=1;
                          if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                            System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                            S4687=2;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                              S4687=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                S4687=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                S4687=3;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                  S4687=4;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                      S4687=5;
                                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                        S4687=6;
                                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                            S4682=2;
                                            S6105=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6105=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6100=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6100=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S8190=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                            motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
                      if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                        System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                        S4687=2;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                          S4687=3;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                            S4687=4;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                              S4687=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                S4687=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                S4687=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                  S4687=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                            currsigs.addElement(transferArmExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                            S4687=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                              S4687=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                S4687=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                  S4687=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                        motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                        currsigs.addElement(motorOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                        S4687=3;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                          S4687=4;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                            S4687=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                              S4687=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                              S4687=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                S4687=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                          currsigs.addElement(transferArmExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                          S4687=3;
                          if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                            S4687=4;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                              S4687=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                S4687=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                currsigs.addElement(transferArmRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                S4687=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                  S4687=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                            transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                        S4687=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                          S4687=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                            S4687=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                            S4687=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                              S4687=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                        S4687=5;
                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                          S4687=6;
                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            S4682=2;
                            S6105=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                              S6105=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6100=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6100=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S8190=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                          currsigs.addElement(transferArmRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                          S4687=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                            S4687=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                        S4687=6;
                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                            S4682=2;
                            S6105=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                              S6105=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6100=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6100=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S8190=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                          S4682=2;
                          S6105=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                            S6105=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S6100=0;
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                              S6100=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                S8190=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                        currsigs.addElement(transferArmRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 6 : 
                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                        S4682=2;
                        S6105=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                          S6105=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S6100=0;
                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                            S6100=1;
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                              S8190=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                  switch(S6105){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                        S6105=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S6100){
                          case 0 : 
                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                              S6100=1;
                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                ends[3]=2;
                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                S8190=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                              ends[3]=2;
                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                              S8190=1;
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
                      S6105=1;
                      S6105=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                        S6105=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S6100=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                          S6100=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                            S8190=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S8190=1;
            S8190=0;
            if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 62, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S8190=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S4682=0;
              S4666=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 63, column: 5
                enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                S4666=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4661=0;
                if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                  enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 63, column: 5
                  S4661=1;
                  if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
                    enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
                    ends[3]=2;
                    ;//sysj\bottleReturnController.sysj line: 63, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 64, column: 5
                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 72, column: 5
                    S4682=1;
                    if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 74, column: 8
                      System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 75, column: 6
                      S4687=0;
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                        S4687=1;
                        if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                          System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                          S4687=2;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                            S4687=3;
                            if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                              S4687=4;
                              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                S4687=5;
                                if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                  w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                  System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                  S4687=6;
                                  if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                    System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                    if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                  currsigs.addElement(transferArmRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                              transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                              currsigs.addElement(transferArmExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                              S4687=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                S4687=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                          motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                          currsigs.addElement(motorOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                          S4687=1;
                          if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                            System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                            S4687=2;
                            if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                              S4687=3;
                              if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                S4687=4;
                                if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                  S4687=5;
                                  if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                    w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                    System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                    S4687=6;
                                    if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                      System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                      if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      S4682=2;
                                      S6105=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6105=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S6100=0;
                                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6100=1;
                                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S8190=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                    currsigs.addElement(transferArmRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                                currsigs.addElement(transferArmExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                                S4687=3;
                                if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                                  S4687=4;
                                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                                    S4687=5;
                                    if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                      w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                      System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                      S4687=6;
                                      if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                        System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                        if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        S4682=2;
                                        S6105=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S6105=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S6100=0;
                                          if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6100=1;
                                            if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S8190=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                                      currsigs.addElement(transferArmRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                                      S4687=5;
                                      if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                        w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                        System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                        S4687=6;
                                        if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                          System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                          if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                            S4682=2;
                                            S6105=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6105=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S6100=0;
                                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S6100=1;
                                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                  S8190=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          S4682=2;
                                          S6105=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                            S6105=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S6100=0;
                                            if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                              S6100=1;
                                              if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                                ends[3]=2;
                                                ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                                S8190=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                                  transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                            motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
                      S4682=2;
                      S6105=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                        S6105=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S6100=0;
                        if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                          S6100=1;
                          if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                            status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                            ends[3]=2;
                            ;//sysj\bottleReturnController.sysj line: 106, column: 5
                            S8190=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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

  public void thread25853(int [] tdone, int [] ends){
        switch(S4658){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 46, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 47, column: 8
            auto_1.setPresent();//sysj\bottleReturnController.sysj line: 47, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\bottleReturnController.sysj line: 48, column: 12
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

  public void thread25851(int [] tdone, int [] ends){
        S25846=1;
    OK_thread_3 = 0;//sysj\bottleReturnController.sysj line: 55, column: 3
    BLOCKED_thread_3 = 2;//sysj\bottleReturnController.sysj line: 56, column: 3
    w_thread_3 = null;//sysj\bottleReturnController.sysj line: 58, column: 3
    code_thread_3 = 0;//sysj\bottleReturnController.sysj line: 59, column: 3
    S8190=0;
    if(reset.getprestatus()){//sysj\bottleReturnController.sysj line: 62, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S8190=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S4682=0;
      S4666=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 63, column: 5
        enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
        S4666=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4661=0;
        if(!enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
          enable_in.setACK(true);//sysj\bottleReturnController.sysj line: 63, column: 5
          S4661=1;
          if(enable_in.isREQ()){//sysj\bottleReturnController.sysj line: 63, column: 5
            enable_in.setACK(false);//sysj\bottleReturnController.sysj line: 63, column: 5
            ends[3]=2;
            ;//sysj\bottleReturnController.sysj line: 63, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\bottleReturnController.sysj line: 64, column: 5
            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 72, column: 5
            S4682=1;
            if(w_thread_3 != null){//sysj\bottleReturnController.sysj line: 74, column: 8
              System.out.println("[BR] Returning " + w_thread_3 + " for reuse.");//sysj\bottleReturnController.sysj line: 75, column: 6
              S4687=0;
              if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 22
                S4687=1;
                if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                  System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                  S4687=2;
                  if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                    S4687=3;
                    if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                      S4687=4;
                      if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                        S4687=5;
                        if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                          w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                          System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                          code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                          S4687=6;
                          if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                            System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                            if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            S4682=2;
                            S6105=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                              status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                              S6105=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S6100=0;
                              if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6100=1;
                                if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  ends[3]=2;
                                  ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S8190=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                          currsigs.addElement(transferArmRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                          S4687=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                            S4687=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                      transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                      currsigs.addElement(transferArmExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                      S4687=3;
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                        S4687=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                          S4687=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                            S4687=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                            S4687=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                              S4687=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                  motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
                  currsigs.addElement(motorOnOff);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(motorOnOffM.getprestatus()){//sysj\bottleReturnController.sysj line: 77, column: 45
                  S4687=1;
                  if(bottleAtCollector.getprestatus()){//sysj\bottleReturnController.sysj line: 78, column: 22
                    System.out.println("[BR] " + w_thread_3 + " at the transfer point.");//sysj\bottleReturnController.sysj line: 81, column: 6
                    S4687=2;
                    if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 22
                      S4687=3;
                      if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                        S4687=4;
                        if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                          S4687=5;
                          if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                            w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                            System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                            code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                            S4687=6;
                            if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                              System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                              if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              S4682=2;
                              S6105=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                S6105=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S6100=0;
                                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6100=1;
                                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S8190=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                            currsigs.addElement(transferArmRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                            S4687=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                              S4687=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                        transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
                        currsigs.addElement(transferArmExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(transferArmExtendM.getprestatus()){//sysj\bottleReturnController.sysj line: 83, column: 45
                        S4687=3;
                        if(armAtLoader.getprestatus()){//sysj\bottleReturnController.sysj line: 84, column: 22
                          S4687=4;
                          if(auto_1.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 22
                            S4687=5;
                            if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                              w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                              System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                              code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                              S4687=6;
                              if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                S4682=2;
                                S6105=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                  status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                  S6105=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S6100=0;
                                  if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6100=1;
                                    if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S8190=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
                              currsigs.addElement(transferArmRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(transferArmRetractM.getprestatus()){//sysj\bottleReturnController.sysj line: 88, column: 45
                              S4687=5;
                              if(armAtHome.getprestatus()){//sysj\bottleReturnController.sysj line: 89, column: 22
                                w_thread_3.returnToCollector();//sysj\bottleReturnController.sysj line: 93, column: 6
                                System.out.println("[BR] " + w_thread_3 + " placed in the collector bin.");//sysj\bottleReturnController.sysj line: 94, column: 6
                                code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 96, column: 6
                                S4687=6;
                                if(collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 97, column: 14
                                  System.out.println("[BR] Collector bin is full; no further bottles until it is emptied.");//sysj\bottleReturnController.sysj line: 98, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\bottleReturnController.sysj line: 99, column: 7
                                  if(!collectorBinFull.getprestatus()){//sysj\bottleReturnController.sysj line: 101, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\bottleReturnController.sysj line: 102, column: 22
                                    S4682=2;
                                    S6105=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6105=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S6100=0;
                                      if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S6100=1;
                                        if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                          status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                          S8190=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  S4682=2;
                                  S6105=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                    S6105=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S6100=0;
                                    if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                                      S6100=1;
                                      if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                                        status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleReturnController.sysj line: 106, column: 5
                                        S8190=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                transferArmRetract.setPresent();//sysj\bottleReturnController.sysj line: 90, column: 7
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
                          transferArmExtend.setPresent();//sysj\bottleReturnController.sysj line: 85, column: 7
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
                    motorOnOff.setPresent();//sysj\bottleReturnController.sysj line: 79, column: 7
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
              S4682=2;
              S6105=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\bottleReturnController.sysj line: 106, column: 5
                status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                S6105=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S6100=0;
                if(status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\bottleReturnController.sysj line: 106, column: 5
                  S6100=1;
                  if(!status_o.isACK()){//sysj\bottleReturnController.sysj line: 106, column: 5
                    status_o.setREQ(false);//sysj\bottleReturnController.sysj line: 106, column: 5
                    ends[3]=2;
                    ;//sysj\bottleReturnController.sysj line: 106, column: 5
                    S8190=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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

  public void thread25850(int [] tdone, int [] ends){
        S4658=1;
    if(mode.getprestatus()){//sysj\bottleReturnController.sysj line: 46, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleReturnController.sysj line: 47, column: 8
        auto_1.setPresent();//sysj\bottleReturnController.sysj line: 47, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\bottleReturnController.sysj line: 48, column: 12
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
      switch(S25848){
        case 0 : 
          S25848=0;
          break RUN;
        
        case 1 : 
          S25848=2;
          S25848=2;
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 42, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 42, column: 2
          thread25850(tdone,ends);
          thread25851(tdone,ends);
          int biggest25852 = 0;
          if(ends[2]>=biggest25852){
            biggest25852=ends[2];
          }
          if(ends[3]>=biggest25852){
            biggest25852=ends[3];
          }
          if(biggest25852 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleReturnController.sysj line: 42, column: 2
          manual_1.setClear();//sysj\bottleReturnController.sysj line: 42, column: 2
          thread25853(tdone,ends);
          thread25854(tdone,ends);
          int biggest25855 = 0;
          if(ends[2]>=biggest25855){
            biggest25855=ends[2];
          }
          if(ends[3]>=biggest25855){
            biggest25855=ends[3];
          }
          if(biggest25855 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest25855 == 0){
            S25848=0;
            active[1]=0;
            ends[1]=0;
            S25848=0;
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
