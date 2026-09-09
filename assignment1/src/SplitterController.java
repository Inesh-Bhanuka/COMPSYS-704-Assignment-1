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
  public Signal bottleAtSplitter = new Signal("bottleAtSplitter", Signal.INPUT);
  public Signal divertAtNormal = new Signal("divertAtNormal", Signal.INPUT);
  public Signal divertAtReject = new Signal("divertAtReject", Signal.INPUT);
  public Signal bottleLeftSplitter = new Signal("bottleLeftSplitter", Signal.INPUT);
  public Signal diverterExtendM = new Signal("diverterExtendM", Signal.INPUT);
  public Signal diverterRetractM = new Signal("diverterRetractM", Signal.INPUT);
  public Signal admitBottle = new Signal("admitBottle", Signal.OUTPUT);
  public Signal diverterExtend = new Signal("diverterExtend", Signal.OUTPUT);
  public Signal diverterRetract = new Signal("diverterRetract", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj/splitterController.sysj line: 56, column: 3
  private int JAMMED_thread_3;//sysj/splitterController.sysj line: 57, column: 3
  private int STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 61, column: 3
  private Workpiece w_thread_3;//sysj/splitterController.sysj line: 63, column: 3
  private int t_thread_3;//sysj/splitterController.sysj line: 64, column: 3
  private int code_thread_3;//sysj/splitterController.sysj line: 65, column: 3
  private boolean confirmed_thread_3;//sysj/splitterController.sysj line: 66, column: 3
  private int S207284 = 1;
  private int S196514 = 1;
  private int S207130 = 1;
  private int S198284 = 1;
  private int S196539 = 1;
  private int S196523 = 1;
  private int S196518 = 1;
  private int S196629 = 1;
  private int S196781 = 1;
  private int S196776 = 1;
  private int S207282 = 1;
  private int S207180 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread207292(int [] tdone, int [] ends){
        switch(S207282){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S207180){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 133, column: 20
              S207180=1;
              if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 134, column: 20
                S207180=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj/splitterController.sysj line: 136, column: 14
                  diverterExtend.setPresent();//sysj/splitterController.sysj line: 136, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                    diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                    currsigs.addElement(diverterRetract);
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
                  if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                    diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                    currsigs.addElement(diverterRetract);
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
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 134, column: 20
              S207180=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(diverterExtendM.getprestatus()){//sysj/splitterController.sysj line: 136, column: 14
                diverterExtend.setPresent();//sysj/splitterController.sysj line: 136, column: 32
                currsigs.addElement(diverterExtend);
                if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                  diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                  currsigs.addElement(diverterRetract);
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
                if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                  diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                  currsigs.addElement(diverterRetract);
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
            break;
          
          case 2 : 
            S207180=2;
            S207180=0;
            if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 133, column: 20
              S207180=1;
              if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 134, column: 20
                S207180=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj/splitterController.sysj line: 136, column: 14
                  diverterExtend.setPresent();//sysj/splitterController.sysj line: 136, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                    diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                    currsigs.addElement(diverterRetract);
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
                  if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
                    diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
                    currsigs.addElement(diverterRetract);
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
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread207291(int [] tdone, int [] ends){
        switch(S207130){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S198284){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 69, column: 20
              S198284=1;
              if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 71, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S198284=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S196539=0;
                S196523=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/splitterController.sysj line: 72, column: 5
                  enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                  S196523=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S196518=0;
                  if(!enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                    enable_in.setACK(true);//sysj/splitterController.sysj line: 72, column: 5
                    S196518=1;
                    if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                      enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                      ends[3]=2;
                      ;//sysj/splitterController.sysj line: 72, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
                      System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
                      S196539=1;
                      if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                        System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                        confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                        S196539=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                          diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                          currsigs.addElement(diverterExtend);
                          if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                            confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                            t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj/splitterController.sysj line: 90, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                          S196539=3;
                          if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                            System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                            S196629=0;
                            if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                              S196629=1;
                              if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                                System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                                code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                                if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                  System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                }
                                S196539=4;
                                S196781=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                  S196781=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S196776=0;
                                  if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                    S196776=1;
                                    if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj/splitterController.sysj line: 125, column: 5
                                      S198284=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                                currsigs.addElement(diverterRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                              currsigs.addElement(diverterExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                            }
                            S196539=4;
                            S196781=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              S196781=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S196776=0;
                              if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                S196776=1;
                                if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj/splitterController.sysj line: 125, column: 5
                                  S198284=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                        admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                        currsigs.addElement(admitBottle);
                        active[3]=1;
                        ends[3]=1;
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
            if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 71, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S198284=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S196539){
                case 0 : 
                  switch(S196523){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/splitterController.sysj line: 72, column: 5
                        enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                        S196523=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S196518){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                              enable_in.setACK(true);//sysj/splitterController.sysj line: 72, column: 5
                              S196518=1;
                              if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                                enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                                ends[3]=2;
                                ;//sysj/splitterController.sysj line: 72, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
                                System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
                                S196539=1;
                                if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                                  System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                                  t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                                  confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                                  S196539=2;
                                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                                    diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                                    currsigs.addElement(diverterExtend);
                                    if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                                      confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                                      t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj/splitterController.sysj line: 90, column: 5
                                    code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                                    S196539=3;
                                    if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                                      System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                                      S196629=0;
                                      if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                                        S196629=1;
                                        if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                                          code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                                          if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                          }
                                          S196539=4;
                                          S196781=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                            S196781=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S196776=0;
                                            if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                              S196776=1;
                                              if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                                status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                                ends[3]=2;
                                                ;//sysj/splitterController.sysj line: 125, column: 5
                                                S198284=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                                          currsigs.addElement(diverterRetract);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                                        currsigs.addElement(diverterExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                      }
                                      S196539=4;
                                      S196781=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                        S196781=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S196776=0;
                                        if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                          S196776=1;
                                          if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                            ends[3]=2;
                                            ;//sysj/splitterController.sysj line: 125, column: 5
                                            S198284=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                  admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                                  currsigs.addElement(admitBottle);
                                  active[3]=1;
                                  ends[3]=1;
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
                            if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                              enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                              ends[3]=2;
                              ;//sysj/splitterController.sysj line: 72, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
                              System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
                              S196539=1;
                              if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                                System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                                confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                                S196539=2;
                                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                                  diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                                  currsigs.addElement(diverterExtend);
                                  if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                                    confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                                    t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj/splitterController.sysj line: 90, column: 5
                                  code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                                  S196539=3;
                                  if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                                    System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                                    S196629=0;
                                    if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                                      S196629=1;
                                      if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                                        code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                                        if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                        }
                                        S196539=4;
                                        S196781=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                          S196781=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S196776=0;
                                          if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                            S196776=1;
                                            if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                              ends[3]=2;
                                              ;//sysj/splitterController.sysj line: 125, column: 5
                                              S198284=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                                        currsigs.addElement(diverterRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                                      currsigs.addElement(diverterExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                      System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                    }
                                    S196539=4;
                                    S196781=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                      S196781=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S196776=0;
                                      if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                        S196776=1;
                                        if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj/splitterController.sysj line: 125, column: 5
                                          S198284=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                                currsigs.addElement(admitBottle);
                                active[3]=1;
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
                      S196523=1;
                      S196523=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/splitterController.sysj line: 72, column: 5
                        enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                        S196523=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S196518=0;
                        if(!enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                          enable_in.setACK(true);//sysj/splitterController.sysj line: 72, column: 5
                          S196518=1;
                          if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                            enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                            ends[3]=2;
                            ;//sysj/splitterController.sysj line: 72, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
                            System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
                            S196539=1;
                            if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                              System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                              t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                              confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                              S196539=2;
                              if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                                diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                                currsigs.addElement(diverterExtend);
                                if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                                  confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                                  t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                ends[3]=2;
                                ;//sysj/splitterController.sysj line: 90, column: 5
                                code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                                S196539=3;
                                if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                                  System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                                  S196629=0;
                                  if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                                    S196629=1;
                                    if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                                      System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                                      code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                                      if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                      }
                                      S196539=4;
                                      S196781=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                        S196781=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S196776=0;
                                        if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                          S196776=1;
                                          if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                            ends[3]=2;
                                            ;//sysj/splitterController.sysj line: 125, column: 5
                                            S198284=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                                      currsigs.addElement(diverterRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                                    currsigs.addElement(diverterExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                    System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                  }
                                  S196539=4;
                                  S196781=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                    S196781=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S196776=0;
                                    if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                      S196776=1;
                                      if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj/splitterController.sysj line: 125, column: 5
                                        S198284=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                              admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                              currsigs.addElement(admitBottle);
                              active[3]=1;
                              ends[3]=1;
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
                  if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                    System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                    t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                    confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                    S196539=2;
                    if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                      diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                      currsigs.addElement(diverterExtend);
                      if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                        confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                        t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      ends[3]=2;
                      ;//sysj/splitterController.sysj line: 90, column: 5
                      code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                      S196539=3;
                      if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                        System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                        S196629=0;
                        if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                          S196629=1;
                          if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                            System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                            code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                            if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                            }
                            S196539=4;
                            S196781=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              S196781=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S196776=0;
                              if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                S196776=1;
                                if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj/splitterController.sysj line: 125, column: 5
                                  S198284=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                            currsigs.addElement(diverterRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                          currsigs.addElement(diverterExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                        }
                        S196539=4;
                        S196781=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                          S196781=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S196776=0;
                          if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                            S196776=1;
                            if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj/splitterController.sysj line: 125, column: 5
                              S198284=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                    admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                    currsigs.addElement(admitBottle);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                    diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                    currsigs.addElement(diverterExtend);
                    if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                      confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                      t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    ends[3]=2;
                    ;//sysj/splitterController.sysj line: 90, column: 5
                    code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                    S196539=3;
                    if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                      System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                      S196629=0;
                      if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                        S196629=1;
                        if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                          code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                          if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                          }
                          S196539=4;
                          S196781=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                            S196781=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S196776=0;
                            if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                              S196776=1;
                              if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj/splitterController.sysj line: 125, column: 5
                                S198284=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                          currsigs.addElement(diverterRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                        currsigs.addElement(diverterExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                      }
                      S196539=4;
                      S196781=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                        S196781=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S196776=0;
                        if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                          S196776=1;
                          if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj/splitterController.sysj line: 125, column: 5
                            S198284=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
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
                
                case 3 : 
                  switch(S196629){
                    case 0 : 
                      if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                        S196629=1;
                        if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                          code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                          if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                          }
                          S196539=4;
                          S196781=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                            S196781=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S196776=0;
                            if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                              S196776=1;
                              if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj/splitterController.sysj line: 125, column: 5
                                S198284=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                          currsigs.addElement(diverterRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                        currsigs.addElement(diverterExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                        code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                        if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                        }
                        S196539=4;
                        S196781=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                          S196781=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S196776=0;
                          if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                            S196776=1;
                            if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj/splitterController.sysj line: 125, column: 5
                              S198284=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                        currsigs.addElement(diverterRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 4 : 
                  switch(S196781){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                        S196781=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S196776){
                          case 0 : 
                            if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                              S196776=1;
                              if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj/splitterController.sysj line: 125, column: 5
                                S198284=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj/splitterController.sysj line: 125, column: 5
                              S198284=2;
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
                      S196781=1;
                      S196781=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                        S196781=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S196776=0;
                        if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                          S196776=1;
                          if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj/splitterController.sysj line: 125, column: 5
                            S198284=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S198284=2;
            S198284=0;
            if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 69, column: 20
              S198284=1;
              if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 71, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S198284=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S196539=0;
                S196523=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/splitterController.sysj line: 72, column: 5
                  enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                  S196523=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S196518=0;
                  if(!enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                    enable_in.setACK(true);//sysj/splitterController.sysj line: 72, column: 5
                    S196518=1;
                    if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
                      enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
                      ends[3]=2;
                      ;//sysj/splitterController.sysj line: 72, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
                      System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
                      S196539=1;
                      if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                        System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                        confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                        S196539=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                          diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                          currsigs.addElement(diverterExtend);
                          if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                            confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                            t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj/splitterController.sysj line: 90, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                          S196539=3;
                          if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                            System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                            S196629=0;
                            if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                              S196629=1;
                              if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                                System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                                code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                                if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                                  System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                                }
                                S196539=4;
                                S196781=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                  S196781=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S196776=0;
                                  if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                    S196776=1;
                                    if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj/splitterController.sysj line: 125, column: 5
                                      S198284=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                                currsigs.addElement(diverterRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                              currsigs.addElement(diverterExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                            }
                            S196539=4;
                            S196781=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              S196781=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S196776=0;
                              if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                                S196776=1;
                                if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj/splitterController.sysj line: 125, column: 5
                                  S198284=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                        admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                        currsigs.addElement(admitBottle);
                        active[3]=1;
                        ends[3]=1;
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

  public void thread207290(int [] tdone, int [] ends){
        switch(S196514){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/splitterController.sysj line: 46, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/splitterController.sysj line: 47, column: 8
            auto_1.setPresent();//sysj/splitterController.sysj line: 47, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/splitterController.sysj line: 48, column: 12
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

  public void thread207288(int [] tdone, int [] ends){
        S207282=1;
    S207180=0;
    if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 133, column: 20
      S207180=1;
      if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 134, column: 20
        S207180=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(diverterExtendM.getprestatus()){//sysj/splitterController.sysj line: 136, column: 14
          diverterExtend.setPresent();//sysj/splitterController.sysj line: 136, column: 32
          currsigs.addElement(diverterExtend);
          if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
            diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
            currsigs.addElement(diverterRetract);
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
          if(diverterRetractM.getprestatus()){//sysj/splitterController.sysj line: 137, column: 14
            diverterRetract.setPresent();//sysj/splitterController.sysj line: 137, column: 33
            currsigs.addElement(diverterRetract);
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
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread207287(int [] tdone, int [] ends){
        S207130=1;
    OK_thread_3 = 0;//sysj/splitterController.sysj line: 56, column: 3
    JAMMED_thread_3 = 1;//sysj/splitterController.sysj line: 57, column: 3
    STROKE_TIMEOUT_thread_3 = 12;//sysj/splitterController.sysj line: 61, column: 3
    w_thread_3 = null;//sysj/splitterController.sysj line: 63, column: 3
    t_thread_3 = 0;//sysj/splitterController.sysj line: 64, column: 3
    code_thread_3 = 0;//sysj/splitterController.sysj line: 65, column: 3
    confirmed_thread_3 = false;//sysj/splitterController.sysj line: 66, column: 3
    S198284=0;
    if(auto_1.getprestatus()){//sysj/splitterController.sysj line: 69, column: 20
      S198284=1;
      if(manual_1.getprestatus()){//sysj/splitterController.sysj line: 71, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S198284=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S196539=0;
        S196523=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/splitterController.sysj line: 72, column: 5
          enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
          S196523=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S196518=0;
          if(!enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
            enable_in.setACK(true);//sysj/splitterController.sysj line: 72, column: 5
            S196518=1;
            if(enable_in.isREQ()){//sysj/splitterController.sysj line: 72, column: 5
              enable_in.setACK(false);//sysj/splitterController.sysj line: 72, column: 5
              ends[3]=2;
              ;//sysj/splitterController.sysj line: 72, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/splitterController.sysj line: 73, column: 5
              System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 74, column: 5
              S196539=1;
              if(bottleAtSplitter.getprestatus()){//sysj/splitterController.sysj line: 79, column: 21
                System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj/splitterController.sysj line: 82, column: 5
                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj/splitterController.sysj line: 88, column: 5
                confirmed_thread_3 = false;//sysj/splitterController.sysj line: 89, column: 5
                S196539=2;
                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj/splitterController.sysj line: 90, column: 11
                  diverterExtend.setPresent();//sysj/splitterController.sysj line: 91, column: 6
                  currsigs.addElement(diverterExtend);
                  if(divertAtReject.getprestatus()){//sysj/splitterController.sysj line: 92, column: 14
                    confirmed_thread_3 = true;//sysj/splitterController.sysj line: 93, column: 7
                    t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    t_thread_3 = t_thread_3 - 1;//sysj/splitterController.sysj line: 95, column: 6
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  ends[3]=2;
                  ;//sysj/splitterController.sysj line: 90, column: 5
                  code_thread_3 = JAMMED_thread_3;//sysj/splitterController.sysj line: 99, column: 5
                  S196539=3;
                  if(confirmed_thread_3){//sysj/splitterController.sysj line: 101, column: 5
                    System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj/splitterController.sysj line: 102, column: 6
                    S196629=0;
                    if(bottleLeftSplitter.getprestatus()){//sysj/splitterController.sysj line: 107, column: 22
                      S196629=1;
                      if(divertAtNormal.getprestatus()){//sysj/splitterController.sysj line: 110, column: 22
                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj/splitterController.sysj line: 113, column: 6
                        code_thread_3 = OK_thread_3;//sysj/splitterController.sysj line: 114, column: 6
                        if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                        }
                        S196539=4;
                        S196781=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                          S196781=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S196776=0;
                          if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                            S196776=1;
                            if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj/splitterController.sysj line: 125, column: 5
                              S198284=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        diverterRetract.setPresent();//sysj/splitterController.sysj line: 111, column: 7
                        currsigs.addElement(diverterRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      diverterExtend.setPresent();//sysj/splitterController.sysj line: 108, column: 7
                      currsigs.addElement(diverterExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(!confirmed_thread_3) {//sysj/splitterController.sysj line: 117, column: 19
                      System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj/splitterController.sysj line: 118, column: 6
                    }
                    S196539=4;
                    S196781=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/splitterController.sysj line: 125, column: 5
                      status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                      S196781=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S196776=0;
                      if(status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                        status_o.setVal(new Integer(code_thread_3));//sysj/splitterController.sysj line: 125, column: 5
                        S196776=1;
                        if(!status_o.isACK()){//sysj/splitterController.sysj line: 125, column: 5
                          status_o.setREQ(false);//sysj/splitterController.sysj line: 125, column: 5
                          ends[3]=2;
                          ;//sysj/splitterController.sysj line: 125, column: 5
                          S198284=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
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
                admitBottle.setPresent();//sysj/splitterController.sysj line: 80, column: 6
                currsigs.addElement(admitBottle);
                active[3]=1;
                ends[3]=1;
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

  public void thread207286(int [] tdone, int [] ends){
        S196514=1;
    if(mode.getprestatus()){//sysj/splitterController.sysj line: 46, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/splitterController.sysj line: 47, column: 8
        auto_1.setPresent();//sysj/splitterController.sysj line: 47, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/splitterController.sysj line: 48, column: 12
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
      switch(S207284){
        case 0 : 
          S207284=0;
          break RUN;
        
        case 1 : 
          S207284=2;
          S207284=2;
          auto_1.setClear();//sysj/splitterController.sysj line: 42, column: 2
          manual_1.setClear();//sysj/splitterController.sysj line: 42, column: 2
          thread207286(tdone,ends);
          thread207287(tdone,ends);
          thread207288(tdone,ends);
          int biggest207289 = 0;
          if(ends[2]>=biggest207289){
            biggest207289=ends[2];
          }
          if(ends[3]>=biggest207289){
            biggest207289=ends[3];
          }
          if(ends[4]>=biggest207289){
            biggest207289=ends[4];
          }
          if(biggest207289 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/splitterController.sysj line: 42, column: 2
          manual_1.setClear();//sysj/splitterController.sysj line: 42, column: 2
          thread207290(tdone,ends);
          thread207291(tdone,ends);
          thread207292(tdone,ends);
          int biggest207293 = 0;
          if(ends[2]>=biggest207293){
            biggest207293=ends[2];
          }
          if(ends[3]>=biggest207293){
            biggest207293=ends[3];
          }
          if(ends[4]>=biggest207293){
            biggest207293=ends[4];
          }
          if(biggest207293 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest207293 == 0){
            S207284=0;
            active[1]=0;
            ends[1]=0;
            S207284=0;
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
          bottleAtSplitter.gethook();
          divertAtNormal.gethook();
          divertAtReject.gethook();
          bottleLeftSplitter.gethook();
          diverterExtendM.gethook();
          diverterRetractM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtSplitter.setpreclear();
      divertAtNormal.setpreclear();
      divertAtReject.setpreclear();
      bottleLeftSplitter.setpreclear();
      diverterExtendM.setpreclear();
      diverterRetractM.setpreclear();
      admitBottle.setpreclear();
      diverterExtend.setpreclear();
      diverterRetract.setpreclear();
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
      admitBottle.sethook();
      admitBottle.setClear();
      diverterExtend.sethook();
      diverterExtend.setClear();
      diverterRetract.sethook();
      diverterRetract.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        bottleAtSplitter.gethook();
        divertAtNormal.gethook();
        divertAtReject.gethook();
        bottleLeftSplitter.gethook();
        diverterExtendM.gethook();
        diverterRetractM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
