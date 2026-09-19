import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SplitterController extends ClockDomain{
  public SplitterController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtSplitter = new Signal("bottleAtSplitter", Signal.INPUT);
  public Signal divertAtNormal = new Signal("divertAtNormal", Signal.INPUT);
  public Signal divertAtReject = new Signal("divertAtReject", Signal.INPUT);
  public Signal bottleLeftSplitter = new Signal("bottleLeftSplitter", Signal.INPUT);
  public Signal diverterExtendM = new Signal("diverterExtendM", Signal.INPUT);
  public Signal diverterRetractM = new Signal("diverterRetractM", Signal.INPUT);
  public Signal admitBottleM = new Signal("admitBottleM", Signal.INPUT);
  public Signal admitBottle = new Signal("admitBottle", Signal.OUTPUT);
  public Signal diverterExtend = new Signal("diverterExtend", Signal.OUTPUT);
  public Signal diverterRetract = new Signal("diverterRetract", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private Signal diverterM_1;
  private int FORWARD_thread_4;//sysj\splitterController.sysj line: 69, column: 3
  private int DIVERTED_thread_4;//sysj\splitterController.sysj line: 70, column: 3
  private int JAMMED_thread_4;//sysj\splitterController.sysj line: 71, column: 3
  private int STROKE_TIMEOUT_thread_4;//sysj\splitterController.sysj line: 75, column: 3
  private WorkpieceTwin w_thread_4;//sysj\splitterController.sysj line: 77, column: 3
  private int t_thread_4;//sysj\splitterController.sysj line: 78, column: 3
  private int code_thread_4;//sysj\splitterController.sysj line: 79, column: 3
  private boolean reject_thread_4;//sysj\splitterController.sysj line: 80, column: 3
  private boolean confirmed_thread_4;//sysj\splitterController.sysj line: 81, column: 3
  private boolean cleared_thread_4;//sysj\splitterController.sysj line: 82, column: 3
  private boolean home_thread_4;//sysj\splitterController.sysj line: 83, column: 3
  private int S588753 = 1;
  private int S315885 = 1;
  private int S315873 = 1;
  private int S315899 = 1;
  private int S588751 = 1;
  private int S361375 = 1;
  private int S315923 = 1;
  private int S315907 = 1;
  private int S315902 = 1;
  private int S337730 = 1;
  private int S337725 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread588761(int [] tdone, int [] ends){
        switch(S588751){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S361375){
          case 0 : 
            if(reset.getprestatus()){//sysj\splitterController.sysj line: 86, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S361375=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              switch(S315923){
                case 0 : 
                  switch(S315907){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 87, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                        S315907=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        switch(S315902){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                              enable_in.setACK(true);//sysj\splitterController.sysj line: 87, column: 5
                              S315902=1;
                              if(enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                                enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 87, column: 5
                                w_thread_4 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 88, column: 5
                                S315923=1;
                                if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
                                  S315923=2;
                                  if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                    reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                    w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                    System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                    S315923=3;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                    currsigs.addElement(admitBottle);
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                                    S315923=2;
                                    if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                      reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                      w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                      System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                      S315923=3;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                      currsigs.addElement(admitBottle);
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
                            if(enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                              enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 87, column: 5
                              w_thread_4 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 88, column: 5
                              S315923=1;
                              if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
                                S315923=2;
                                if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                  reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                  w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                  System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                  S315923=3;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                  currsigs.addElement(admitBottle);
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                                  S315923=2;
                                  if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                    reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                    w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                    System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                    S315923=3;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                    currsigs.addElement(admitBottle);
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
                      S315907=1;
                      S315907=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 87, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                        S315907=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S315902=0;
                        if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                          enable_in.setACK(true);//sysj\splitterController.sysj line: 87, column: 5
                          S315902=1;
                          if(enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                            enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 87, column: 5
                            w_thread_4 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 88, column: 5
                            S315923=1;
                            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
                              S315923=2;
                              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                S315923=3;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                currsigs.addElement(admitBottle);
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                                S315923=2;
                                if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                                  reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                                  w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                                  System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                                  S315923=3;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                                  currsigs.addElement(admitBottle);
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
                
                case 1 : 
                  if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
                    S315923=2;
                    if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                      reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                      w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                      System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                      S315923=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                      currsigs.addElement(admitBottle);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                      S315923=2;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                        reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                        w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                        System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                        S315923=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                        currsigs.addElement(admitBottle);
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
                
                case 2 : 
                  if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                    reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                    w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                    System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                    S315923=3;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                    currsigs.addElement(admitBottle);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  break;
                
                case 3 : 
                  S315923=3;
                  S315923=4;
                  if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 107, column: 21
                    t_thread_4 = STROKE_TIMEOUT_thread_4;//sysj\splitterController.sysj line: 108, column: 5
                    confirmed_thread_4 = false;//sysj\splitterController.sysj line: 109, column: 5
                    S315923=5;
                    if(t_thread_4 > 0 && !confirmed_thread_4){//sysj\splitterController.sysj line: 110, column: 11
                      if(reject_thread_4){//sysj\splitterController.sysj line: 111, column: 6
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 111, column: 18
                        currsigs.addElement(diverterExtend);
                        if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                      else {
                        if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                    }
                    else {
                      ends[4]=2;
                      ;//sysj\splitterController.sysj line: 110, column: 5
                      code_thread_4 = JAMMED_thread_4;//sysj\splitterController.sysj line: 123, column: 5
                      S315923=6;
                      if(confirmed_thread_4){//sysj\splitterController.sysj line: 125, column: 5
                        cleared_thread_4 = false;//sysj\splitterController.sysj line: 128, column: 6
                        if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                          if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                            diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                            currsigs.addElement(diverterExtend);
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                        else {
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 129, column: 6
                          code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                          if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                            code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                          }
                          System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                          S315923=7;
                          if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                            System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                            w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                            cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                            if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 150, column: 6
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                          }
                        }
                      }
                      else {
                        S315923=7;
                        if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                          w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                          cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                          if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 150, column: 6
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                          S315923=8;
                          if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                              home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 167, column: 5
                            S315923=9;
                            S337730=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              S337730=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S337725=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                S337725=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 177, column: 5
                                  S361375=1;
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
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(diverterM_1.getprestatus()){//sysj\splitterController.sysj line: 107, column: 44
                      t_thread_4 = STROKE_TIMEOUT_thread_4;//sysj\splitterController.sysj line: 108, column: 5
                      confirmed_thread_4 = false;//sysj\splitterController.sysj line: 109, column: 5
                      S315923=5;
                      if(t_thread_4 > 0 && !confirmed_thread_4){//sysj\splitterController.sysj line: 110, column: 11
                        if(reject_thread_4){//sysj\splitterController.sysj line: 111, column: 6
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 111, column: 18
                          currsigs.addElement(diverterExtend);
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                            currsigs.addElement(diverterRetract);
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                            currsigs.addElement(diverterRetract);
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[4]=2;
                        ;//sysj\splitterController.sysj line: 110, column: 5
                        code_thread_4 = JAMMED_thread_4;//sysj\splitterController.sysj line: 123, column: 5
                        S315923=6;
                        if(confirmed_thread_4){//sysj\splitterController.sysj line: 125, column: 5
                          cleared_thread_4 = false;//sysj\splitterController.sysj line: 128, column: 6
                          if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                            if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                              diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                              currsigs.addElement(diverterExtend);
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                                currsigs.addElement(diverterRetract);
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                                currsigs.addElement(diverterRetract);
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                          else {
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 129, column: 6
                            code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                            if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                              code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                            }
                            System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                            S315923=7;
                            if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                              System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                              w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                              cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                              if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 150, column: 6
                                home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                                S315923=8;
                                if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                    home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 167, column: 5
                                  S315923=9;
                                  S337730=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    S337730=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S337725=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                      S337725=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                        ends[4]=2;
                                        ;//sysj\splitterController.sysj line: 177, column: 5
                                        S361375=1;
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
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                        }
                        else {
                          S315923=7;
                          if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                            System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                            w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                            cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                            if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 150, column: 6
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
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
                  break;
                
                case 4 : 
                  if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 107, column: 21
                    t_thread_4 = STROKE_TIMEOUT_thread_4;//sysj\splitterController.sysj line: 108, column: 5
                    confirmed_thread_4 = false;//sysj\splitterController.sysj line: 109, column: 5
                    S315923=5;
                    if(t_thread_4 > 0 && !confirmed_thread_4){//sysj\splitterController.sysj line: 110, column: 11
                      if(reject_thread_4){//sysj\splitterController.sysj line: 111, column: 6
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 111, column: 18
                        currsigs.addElement(diverterExtend);
                        if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                      else {
                        if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                    }
                    else {
                      ends[4]=2;
                      ;//sysj\splitterController.sysj line: 110, column: 5
                      code_thread_4 = JAMMED_thread_4;//sysj\splitterController.sysj line: 123, column: 5
                      S315923=6;
                      if(confirmed_thread_4){//sysj\splitterController.sysj line: 125, column: 5
                        cleared_thread_4 = false;//sysj\splitterController.sysj line: 128, column: 6
                        if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                          if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                            diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                            currsigs.addElement(diverterExtend);
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                        else {
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 129, column: 6
                          code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                          if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                            code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                          }
                          System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                          S315923=7;
                          if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                            System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                            w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                            cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                            if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 150, column: 6
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                          }
                        }
                      }
                      else {
                        S315923=7;
                        if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                          w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                          cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                          if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 150, column: 6
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                          S315923=8;
                          if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                              home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 167, column: 5
                            S315923=9;
                            S337730=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              S337730=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S337725=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                S337725=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 177, column: 5
                                  S361375=1;
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
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(diverterM_1.getprestatus()){//sysj\splitterController.sysj line: 107, column: 44
                      t_thread_4 = STROKE_TIMEOUT_thread_4;//sysj\splitterController.sysj line: 108, column: 5
                      confirmed_thread_4 = false;//sysj\splitterController.sysj line: 109, column: 5
                      S315923=5;
                      if(t_thread_4 > 0 && !confirmed_thread_4){//sysj\splitterController.sysj line: 110, column: 11
                        if(reject_thread_4){//sysj\splitterController.sysj line: 111, column: 6
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 111, column: 18
                          currsigs.addElement(diverterExtend);
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                            currsigs.addElement(diverterRetract);
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                            currsigs.addElement(diverterRetract);
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                          else {
                            if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                              if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                    confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                            else {
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                  confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                      else {
                        ends[4]=2;
                        ;//sysj\splitterController.sysj line: 110, column: 5
                        code_thread_4 = JAMMED_thread_4;//sysj\splitterController.sysj line: 123, column: 5
                        S315923=6;
                        if(confirmed_thread_4){//sysj\splitterController.sysj line: 125, column: 5
                          cleared_thread_4 = false;//sysj\splitterController.sysj line: 128, column: 6
                          if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                            if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                              diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                              currsigs.addElement(diverterExtend);
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                                currsigs.addElement(diverterRetract);
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                              if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                                currsigs.addElement(diverterRetract);
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                          else {
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 129, column: 6
                            code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                            if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                              code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                            }
                            System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                            S315923=7;
                            if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                              System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                              w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                              cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                              if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                  cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 150, column: 6
                                home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                                S315923=8;
                                if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                    home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 167, column: 5
                                  S315923=9;
                                  S337730=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    S337730=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S337725=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                      S337725=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                        ends[4]=2;
                                        ;//sysj\splitterController.sysj line: 177, column: 5
                                        S361375=1;
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
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                        }
                        else {
                          S315923=7;
                          if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                            System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                            w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                            cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                            if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                                cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 150, column: 6
                              home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                              S315923=8;
                              if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                  home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 167, column: 5
                                S315923=9;
                                S337730=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  S337730=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S337725=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                    S337725=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                      ends[4]=2;
                                      ;//sysj\splitterController.sysj line: 177, column: 5
                                      S361375=1;
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
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
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
                  break;
                
                case 5 : 
                  if(t_thread_4 > 0 && !confirmed_thread_4){//sysj\splitterController.sysj line: 110, column: 11
                    if(reject_thread_4){//sysj\splitterController.sysj line: 111, column: 6
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 111, column: 18
                      currsigs.addElement(diverterExtend);
                      if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                        currsigs.addElement(diverterRetract);
                        if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(!reject_thread_4){//sysj\splitterController.sysj line: 112, column: 9
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 112, column: 19
                        currsigs.addElement(diverterRetract);
                        if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(reject_thread_4){//sysj\splitterController.sysj line: 113, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_4 = true;//sysj\splitterController.sysj line: 114, column: 32
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                                confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 116, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 117, column: 15
                              confirmed_thread_4 = true;//sysj\splitterController.sysj line: 117, column: 32
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            t_thread_4 = t_thread_4 - 1;//sysj\splitterController.sysj line: 119, column: 6
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    ends[4]=2;
                    ;//sysj\splitterController.sysj line: 110, column: 5
                    code_thread_4 = JAMMED_thread_4;//sysj\splitterController.sysj line: 123, column: 5
                    S315923=6;
                    if(confirmed_thread_4){//sysj\splitterController.sysj line: 125, column: 5
                      cleared_thread_4 = false;//sysj\splitterController.sysj line: 128, column: 6
                      if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                        if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                          currsigs.addElement(diverterExtend);
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                            currsigs.addElement(diverterRetract);
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                          if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                            currsigs.addElement(diverterRetract);
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                      else {
                        ends[4]=2;
                        ;//sysj\splitterController.sysj line: 129, column: 6
                        code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                        if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                          code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                        }
                        System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                        S315923=7;
                        if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                          w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                          cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                          if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                              cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 150, column: 6
                            home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                            S315923=8;
                            if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                                home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 167, column: 5
                              S315923=9;
                              S337730=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                S337730=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S337725=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                  S337725=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                    ends[4]=2;
                                    ;//sysj\splitterController.sysj line: 177, column: 5
                                    S361375=1;
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
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                          S315923=8;
                          if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                              home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 167, column: 5
                            S315923=9;
                            S337730=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              S337730=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S337725=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                S337725=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 177, column: 5
                                  S361375=1;
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
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                    }
                    else {
                      S315923=7;
                      if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                        System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                        w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                        cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                        if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                            cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 150, column: 6
                          home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                          S315923=8;
                          if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                              home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 167, column: 5
                            S315923=9;
                            S337730=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              S337730=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S337725=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                                S337725=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                  ends[4]=2;
                                  ;//sysj\splitterController.sysj line: 177, column: 5
                                  S361375=1;
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
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                          }
                        }
                      }
                      else {
                        home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                        S315923=8;
                        if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                            home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 167, column: 5
                          S315923=9;
                          S337730=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                            S337730=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S337725=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                              S337725=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 177, column: 5
                                S361375=1;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                    }
                  }
                  break;
                
                case 6 : 
                  if(!cleared_thread_4){//sysj\splitterController.sysj line: 129, column: 12
                    if(reject_thread_4){//sysj\splitterController.sysj line: 130, column: 7
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 130, column: 19
                      currsigs.addElement(diverterExtend);
                      if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                        currsigs.addElement(diverterRetract);
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                          cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                          cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                      if(!reject_thread_4){//sysj\splitterController.sysj line: 131, column: 10
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 131, column: 20
                        currsigs.addElement(diverterRetract);
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                          cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 132, column: 15
                          cleared_thread_4 = true;//sysj\splitterController.sysj line: 132, column: 36
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
                  else {
                    ends[4]=2;
                    ;//sysj\splitterController.sysj line: 129, column: 6
                    code_thread_4 = FORWARD_thread_4;//sysj\splitterController.sysj line: 135, column: 6
                    if(reject_thread_4) {//sysj\splitterController.sysj line: 136, column: 16
                      code_thread_4 = DIVERTED_thread_4;//sysj\splitterController.sysj line: 136, column: 18
                    }
                    System.out.println("[SP] " + w_thread_4 + " released down the " + (reject_thread_4 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 137, column: 6
                    S315923=7;
                    if(!confirmed_thread_4){//sysj\splitterController.sysj line: 141, column: 8
                      System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_4 ? "reject" : "normal") + " position for " + w_thread_4 + ".");//sysj\splitterController.sysj line: 146, column: 6
                      w_thread_4.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 148, column: 6
                      cleared_thread_4 = false;//sysj\splitterController.sysj line: 149, column: 6
                      if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                          cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                        ends[4]=2;
                        ;//sysj\splitterController.sysj line: 150, column: 6
                        home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                        S315923=8;
                        if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                            home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 167, column: 5
                          S315923=9;
                          S337730=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                            S337730=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S337725=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                              S337725=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 177, column: 5
                                S361375=1;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                    }
                    else {
                      home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                      S315923=8;
                      if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                        currsigs.addElement(diverterRetract);
                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                          home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                        ends[4]=2;
                        ;//sysj\splitterController.sysj line: 167, column: 5
                        S315923=9;
                        S337730=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                          S337730=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S337725=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                            status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                            S337725=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 177, column: 5
                              S361375=1;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                    }
                  }
                  break;
                
                case 7 : 
                  if(!cleared_thread_4){//sysj\splitterController.sysj line: 150, column: 12
                    if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 151, column: 15
                      cleared_thread_4 = true;//sysj\splitterController.sysj line: 151, column: 36
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
                    ends[4]=2;
                    ;//sysj\splitterController.sysj line: 150, column: 6
                    home_thread_4 = false;//sysj\splitterController.sysj line: 166, column: 5
                    S315923=8;
                    if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                      currsigs.addElement(diverterRetract);
                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                        home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                      ends[4]=2;
                      ;//sysj\splitterController.sysj line: 167, column: 5
                      S315923=9;
                      S337730=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                        S337730=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S337725=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                          status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                          S337725=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 177, column: 5
                            S361375=1;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 8 : 
                  if(!home_thread_4){//sysj\splitterController.sysj line: 167, column: 11
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 168, column: 6
                    currsigs.addElement(diverterRetract);
                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 169, column: 14
                      home_thread_4 = true;//sysj\splitterController.sysj line: 169, column: 31
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
                    ends[4]=2;
                    ;//sysj\splitterController.sysj line: 167, column: 5
                    S315923=9;
                    S337730=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                      status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                      S337730=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S337725=0;
                      if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                        status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                        S337725=1;
                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                          ends[4]=2;
                          ;//sysj\splitterController.sysj line: 177, column: 5
                          S361375=1;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                  break;
                
                case 9 : 
                  switch(S337730){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                        S337730=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        switch(S337725){
                          case 0 : 
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                              S337725=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                                ends[4]=2;
                                ;//sysj\splitterController.sysj line: 177, column: 5
                                S361375=1;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                              ends[4]=2;
                              ;//sysj\splitterController.sysj line: 177, column: 5
                              S361375=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
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
                      S337730=1;
                      S337730=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 177, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                        S337730=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S337725=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                          status_o.setVal(new Integer(code_thread_4));//sysj\splitterController.sysj line: 177, column: 5
                          S337725=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 177, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 177, column: 5
                            ends[4]=2;
                            ;//sysj\splitterController.sysj line: 177, column: 5
                            S361375=1;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S361375=1;
            S361375=0;
            if(reset.getprestatus()){//sysj\splitterController.sysj line: 86, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S361375=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S315923=0;
              S315907=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 87, column: 5
                enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                S315907=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S315902=0;
                if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                  enable_in.setACK(true);//sysj\splitterController.sysj line: 87, column: 5
                  S315902=1;
                  if(enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
                    enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
                    ends[4]=2;
                    ;//sysj\splitterController.sysj line: 87, column: 5
                    w_thread_4 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 88, column: 5
                    S315923=1;
                    if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
                      S315923=2;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                        reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                        w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                        System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                        S315923=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                        currsigs.addElement(admitBottle);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                        S315923=2;
                        if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                          reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                          w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                          System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                          S315923=3;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                          currsigs.addElement(admitBottle);
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
            break;
          
        }
        break;
      
    }
  }

  public void thread588760(int [] tdone, int [] ends){
        switch(S315899){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\splitterController.sysj line: 57, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 60, column: 8
            auto_1.setPresent();//sysj\splitterController.sysj line: 60, column: 30
            currsigs.addElement(auto_1);
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\splitterController.sysj line: 61, column: 13
              manual_1.setPresent();//sysj\splitterController.sysj line: 61, column: 35
              currsigs.addElement(manual_1);
              active[3]=1;
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
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread588759(int [] tdone, int [] ends){
        switch(S315885){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S315873){
          case 0 : 
            S315873=0;
            if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 49, column: 12
              diverterM_1.setPresent();//sysj\splitterController.sysj line: 49, column: 30
              currsigs.addElement(diverterM_1);
              if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
                diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
                currsigs.addElement(diverterM_1);
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
                diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
                currsigs.addElement(diverterM_1);
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 1 : 
            S315873=1;
            S315873=0;
            if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 49, column: 12
              diverterM_1.setPresent();//sysj\splitterController.sysj line: 49, column: 30
              currsigs.addElement(diverterM_1);
              if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
                diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
                currsigs.addElement(diverterM_1);
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
                diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
                currsigs.addElement(diverterM_1);
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S315873=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread588757(int [] tdone, int [] ends){
        S588751=1;
    FORWARD_thread_4 = 0;//sysj\splitterController.sysj line: 69, column: 3
    DIVERTED_thread_4 = 1;//sysj\splitterController.sysj line: 70, column: 3
    JAMMED_thread_4 = 2;//sysj\splitterController.sysj line: 71, column: 3
    STROKE_TIMEOUT_thread_4 = PlantTiming.ticks(12);//sysj\splitterController.sysj line: 75, column: 3
    w_thread_4 = null;//sysj\splitterController.sysj line: 77, column: 3
    t_thread_4 = 0;//sysj\splitterController.sysj line: 78, column: 3
    code_thread_4 = 0;//sysj\splitterController.sysj line: 79, column: 3
    reject_thread_4 = false;//sysj\splitterController.sysj line: 80, column: 3
    confirmed_thread_4 = false;//sysj\splitterController.sysj line: 81, column: 3
    cleared_thread_4 = false;//sysj\splitterController.sysj line: 82, column: 3
    home_thread_4 = false;//sysj\splitterController.sysj line: 83, column: 3
    S361375=0;
    if(reset.getprestatus()){//sysj\splitterController.sysj line: 86, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S361375=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S315923=0;
      S315907=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 87, column: 5
        enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
        S315907=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S315902=0;
        if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
          enable_in.setACK(true);//sysj\splitterController.sysj line: 87, column: 5
          S315902=1;
          if(enable_in.isREQ()){//sysj\splitterController.sysj line: 87, column: 5
            enable_in.setACK(false);//sysj\splitterController.sysj line: 87, column: 5
            ends[4]=2;
            ;//sysj\splitterController.sysj line: 87, column: 5
            w_thread_4 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 88, column: 5
            S315923=1;
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 93, column: 21
              S315923=2;
              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                S315923=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                currsigs.addElement(admitBottle);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(admitBottleM.getprestatus()){//sysj\splitterController.sysj line: 93, column: 44
                S315923=2;
                if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 94, column: 21
                  reject_thread_4 = w_thread_4.isRejected();//sysj\splitterController.sysj line: 99, column: 5
                  w_thread_4.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 100, column: 5
                  System.out.println("[SP] " + w_thread_4 + " at the decision point - " + (reject_thread_4 ? "reject path (" + w_thread_4.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 101, column: 5
                  S315923=3;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  admitBottle.setPresent();//sysj\splitterController.sysj line: 95, column: 6
                  currsigs.addElement(admitBottle);
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
  }

  public void thread588756(int [] tdone, int [] ends){
        S315899=1;
    if(mode.getprestatus()){//sysj\splitterController.sysj line: 57, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 60, column: 8
        auto_1.setPresent();//sysj\splitterController.sysj line: 60, column: 30
        currsigs.addElement(auto_1);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\splitterController.sysj line: 61, column: 13
          manual_1.setPresent();//sysj\splitterController.sysj line: 61, column: 35
          currsigs.addElement(manual_1);
          active[3]=1;
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
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread588755(int [] tdone, int [] ends){
        S315885=1;
    S315873=0;
    if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 49, column: 12
      diverterM_1.setPresent();//sysj\splitterController.sysj line: 49, column: 30
      currsigs.addElement(diverterM_1);
      if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
        diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
        currsigs.addElement(diverterM_1);
        S315873=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S315873=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 50, column: 12
        diverterM_1.setPresent();//sysj\splitterController.sysj line: 50, column: 31
        currsigs.addElement(diverterM_1);
        S315873=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S315873=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S588753){
        case 0 : 
          S588753=0;
          break RUN;
        
        case 1 : 
          S588753=2;
          S588753=2;
          auto_1.setClear();//sysj\splitterController.sysj line: 38, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 38, column: 2
          diverterM_1.setClear();//sysj\splitterController.sysj line: 45, column: 2
          thread588755(tdone,ends);
          thread588756(tdone,ends);
          thread588757(tdone,ends);
          int biggest588758 = 0;
          if(ends[2]>=biggest588758){
            biggest588758=ends[2];
          }
          if(ends[3]>=biggest588758){
            biggest588758=ends[3];
          }
          if(ends[4]>=biggest588758){
            biggest588758=ends[4];
          }
          if(biggest588758 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\splitterController.sysj line: 38, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 38, column: 2
          diverterM_1.setClear();//sysj\splitterController.sysj line: 45, column: 2
          thread588759(tdone,ends);
          thread588760(tdone,ends);
          thread588761(tdone,ends);
          int biggest588762 = 0;
          if(ends[2]>=biggest588762){
            biggest588762=ends[2];
          }
          if(ends[3]>=biggest588762){
            biggest588762=ends[3];
          }
          if(ends[4]>=biggest588762){
            biggest588762=ends[4];
          }
          if(biggest588762 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest588762 == 0){
            S588753=0;
            active[1]=0;
            ends[1]=0;
            S588753=0;
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
    diverterM_1 = new Signal();
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
          bottleAtSplitter.gethook();
          divertAtNormal.gethook();
          divertAtReject.gethook();
          bottleLeftSplitter.gethook();
          diverterExtendM.gethook();
          diverterRetractM.gethook();
          admitBottleM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      bottleAtSplitter.setpreclear();
      divertAtNormal.setpreclear();
      divertAtReject.setpreclear();
      bottleLeftSplitter.setpreclear();
      diverterExtendM.setpreclear();
      diverterRetractM.setpreclear();
      admitBottleM.setpreclear();
      admitBottle.setpreclear();
      diverterExtend.setpreclear();
      diverterRetract.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      diverterM_1.setpreclear();
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
      dummyint = bottleAtSplitter.getStatus() ? bottleAtSplitter.setprepresent() : bottleAtSplitter.setpreclear();
      bottleAtSplitter.setpreval(bottleAtSplitter.getValue());
      bottleAtSplitter.setClear();
      dummyint = divertAtNormal.getStatus() ? divertAtNormal.setprepresent() : divertAtNormal.setpreclear();
      divertAtNormal.setpreval(divertAtNormal.getValue());
      divertAtNormal.setClear();
      dummyint = divertAtReject.getStatus() ? divertAtReject.setprepresent() : divertAtReject.setpreclear();
      divertAtReject.setpreval(divertAtReject.getValue());
      divertAtReject.setClear();
      dummyint = bottleLeftSplitter.getStatus() ? bottleLeftSplitter.setprepresent() : bottleLeftSplitter.setpreclear();
      bottleLeftSplitter.setpreval(bottleLeftSplitter.getValue());
      bottleLeftSplitter.setClear();
      dummyint = diverterExtendM.getStatus() ? diverterExtendM.setprepresent() : diverterExtendM.setpreclear();
      diverterExtendM.setpreval(diverterExtendM.getValue());
      diverterExtendM.setClear();
      dummyint = diverterRetractM.getStatus() ? diverterRetractM.setprepresent() : diverterRetractM.setpreclear();
      diverterRetractM.setpreval(diverterRetractM.getValue());
      diverterRetractM.setClear();
      dummyint = admitBottleM.getStatus() ? admitBottleM.setprepresent() : admitBottleM.setpreclear();
      admitBottleM.setpreval(admitBottleM.getValue());
      admitBottleM.setClear();
      admitBottle.sethook();
      admitBottle.setClear();
      diverterExtend.sethook();
      diverterExtend.setClear();
      diverterRetract.sethook();
      diverterRetract.setClear();
      auto_1.setClear();
      manual_1.setClear();
      diverterM_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        reset.gethook();
        bottleAtSplitter.gethook();
        divertAtNormal.gethook();
        divertAtReject.gethook();
        bottleLeftSplitter.gethook();
        diverterExtendM.gethook();
        diverterRetractM.gethook();
        admitBottleM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
