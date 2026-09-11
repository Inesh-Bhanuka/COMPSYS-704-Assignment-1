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
  private int OK_thread_3;//sysj\splitterController.sysj line: 111, column: 3
  private int JAMMED_thread_3;//sysj\splitterController.sysj line: 113, column: 3
  private int STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 121, column: 3
  private WorkpieceTwin w_thread_3;//sysj\splitterController.sysj line: 125, column: 3
  private int t_thread_3;//sysj\splitterController.sysj line: 127, column: 3
  private int code_thread_3;//sysj\splitterController.sysj line: 129, column: 3
  private boolean confirmed_thread_3;//sysj\splitterController.sysj line: 131, column: 3
  private int S225490 = 1;
  private int S214720 = 1;
  private int S225336 = 1;
  private int S216490 = 1;
  private int S214745 = 1;
  private int S214729 = 1;
  private int S214724 = 1;
  private int S214835 = 1;
  private int S214987 = 1;
  private int S214982 = 1;
  private int S225488 = 1;
  private int S225386 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread225498(int [] tdone, int [] ends){
        switch(S225488){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S225386){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 265, column: 20
              S225386=1;
              if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 267, column: 20
                S225386=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 271, column: 14
                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 271, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 267, column: 20
              S225386=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 271, column: 14
                diverterExtend.setPresent();//sysj\splitterController.sysj line: 271, column: 32
                currsigs.addElement(diverterExtend);
                if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
                if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
            S225386=2;
            S225386=0;
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 265, column: 20
              S225386=1;
              if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 267, column: 20
                S225386=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 271, column: 14
                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 271, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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

  public void thread225497(int [] tdone, int [] ends){
        switch(S225336){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S216490){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 137, column: 20
              S216490=1;
              if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 141, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S216490=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S214745=0;
                S214729=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 143, column: 5
                  enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                  S214729=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S214724=0;
                  if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                    enable_in.setACK(true);//sysj\splitterController.sysj line: 143, column: 5
                    S214724=1;
                    if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                      enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 143, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
                      System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
                      S214745=1;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                        System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                        confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                        S214745=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                          currsigs.addElement(diverterExtend);
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 179, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                          S214745=3;
                          if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                            System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                            S214835=0;
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                              S214835=1;
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                                System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                                code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                                if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                  System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                }
                                S214745=4;
                                S214987=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                  S214987=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S214982=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                    S214982=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 249, column: 5
                                      S216490=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                                currsigs.addElement(diverterRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                              currsigs.addElement(diverterExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                            }
                            S214745=4;
                            S214987=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              S214987=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S214982=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                S214982=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 249, column: 5
                                  S216490=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 141, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S216490=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S214745){
                case 0 : 
                  switch(S214729){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 143, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                        S214729=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S214724){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                              enable_in.setACK(true);//sysj\splitterController.sysj line: 143, column: 5
                              S214724=1;
                              if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                                enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 143, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
                                System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
                                S214745=1;
                                if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                                  System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                                  t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                                  confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                                  S214745=2;
                                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                                    diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                                    currsigs.addElement(diverterExtend);
                                    if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 179, column: 5
                                    code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                                    S214745=3;
                                    if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                                      System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                                      S214835=0;
                                      if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                                        S214835=1;
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                                          if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                          }
                                          S214745=4;
                                          S214987=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                            S214987=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S214982=0;
                                            if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                              S214982=1;
                                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                                ends[3]=2;
                                                ;//sysj\splitterController.sysj line: 249, column: 5
                                                S216490=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                                          currsigs.addElement(diverterRetract);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                                        currsigs.addElement(diverterExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                      }
                                      S214745=4;
                                      S214987=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                        S214987=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S214982=0;
                                        if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                          S214982=1;
                                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 249, column: 5
                                            S216490=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                  admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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
                            if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                              enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 143, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
                              System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
                              S214745=1;
                              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                                System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                                confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                                S214745=2;
                                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                                  currsigs.addElement(diverterExtend);
                                  if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 179, column: 5
                                  code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                                  S214745=3;
                                  if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                                    System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                                    S214835=0;
                                    if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                                      S214835=1;
                                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                                        if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                        }
                                        S214745=4;
                                        S214987=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                          S214987=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S214982=0;
                                          if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                            S214982=1;
                                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                              ends[3]=2;
                                              ;//sysj\splitterController.sysj line: 249, column: 5
                                              S216490=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                                        currsigs.addElement(diverterRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                                      currsigs.addElement(diverterExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                      System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                    }
                                    S214745=4;
                                    S214987=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                      S214987=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S214982=0;
                                      if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                        S214982=1;
                                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 249, column: 5
                                          S216490=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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
                      S214729=1;
                      S214729=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 143, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                        S214729=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S214724=0;
                        if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                          enable_in.setACK(true);//sysj\splitterController.sysj line: 143, column: 5
                          S214724=1;
                          if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                            enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 143, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
                            System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
                            S214745=1;
                            if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                              System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                              t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                              confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                              S214745=2;
                              if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                                diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                                currsigs.addElement(diverterExtend);
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 179, column: 5
                                code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                                S214745=3;
                                if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                                  System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                                  S214835=0;
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                                    S214835=1;
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                                      System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                                      if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                      }
                                      S214745=4;
                                      S214987=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                        S214987=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S214982=0;
                                        if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                          S214982=1;
                                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 249, column: 5
                                            S216490=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                                      currsigs.addElement(diverterRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                                    currsigs.addElement(diverterExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                    System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                  }
                                  S214745=4;
                                  S214987=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                    S214987=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S214982=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                      S214982=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 249, column: 5
                                        S216490=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                              admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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
                  if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                    System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                    t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                    confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                    S214745=2;
                    if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                      currsigs.addElement(diverterExtend);
                      if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                        confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 179, column: 5
                      code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                      S214745=3;
                      if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                        System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                        S214835=0;
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                          S214835=1;
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                            System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                            code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                            if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                            }
                            S214745=4;
                            S214987=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              S214987=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S214982=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                S214982=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 249, column: 5
                                  S216490=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                            currsigs.addElement(diverterRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                          currsigs.addElement(diverterExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                        }
                        S214745=4;
                        S214987=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                          S214987=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S214982=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                            S214982=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 249, column: 5
                              S216490=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                    admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
                    currsigs.addElement(admitBottle);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                    diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                    currsigs.addElement(diverterExtend);
                    if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    ends[3]=2;
                    ;//sysj\splitterController.sysj line: 179, column: 5
                    code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                    S214745=3;
                    if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                      System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                      S214835=0;
                      if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                        S214835=1;
                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                          code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                          if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                          }
                          S214745=4;
                          S214987=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                            S214987=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S214982=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                              S214982=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 249, column: 5
                                S216490=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                          currsigs.addElement(diverterRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                        currsigs.addElement(diverterExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                        System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                      }
                      S214745=4;
                      S214987=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                        S214987=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S214982=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                          S214982=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 249, column: 5
                            S216490=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
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
                  switch(S214835){
                    case 0 : 
                      if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                        S214835=1;
                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                          System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                          code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                          if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                            System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                          }
                          S214745=4;
                          S214987=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                            S214987=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S214982=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                              S214982=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 249, column: 5
                                S216490=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                          currsigs.addElement(diverterRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                        currsigs.addElement(diverterExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                        code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                        if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                        }
                        S214745=4;
                        S214987=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                          S214987=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S214982=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                            S214982=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 249, column: 5
                              S216490=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                        currsigs.addElement(diverterRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 4 : 
                  switch(S214987){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                        S214987=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S214982){
                          case 0 : 
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                              S214982=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 249, column: 5
                                S216490=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 249, column: 5
                              S216490=2;
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
                      S214987=1;
                      S214987=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                        S214987=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S214982=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                          S214982=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 249, column: 5
                            S216490=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S216490=2;
            S216490=0;
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 137, column: 20
              S216490=1;
              if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 141, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S216490=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S214745=0;
                S214729=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 143, column: 5
                  enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                  S214729=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S214724=0;
                  if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                    enable_in.setACK(true);//sysj\splitterController.sysj line: 143, column: 5
                    S214724=1;
                    if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
                      enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 143, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
                      System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
                      S214745=1;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                        System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                        confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                        S214745=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                          currsigs.addElement(diverterExtend);
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 179, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                          S214745=3;
                          if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                            System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                            S214835=0;
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                              S214835=1;
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                                System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                                code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                                if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                                  System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                                }
                                S214745=4;
                                S214987=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                  S214987=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S214982=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                    S214982=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 249, column: 5
                                      S216490=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                                currsigs.addElement(diverterRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                              currsigs.addElement(diverterExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                              System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                            }
                            S214745=4;
                            S214987=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              S214987=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S214982=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                                S214982=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 249, column: 5
                                  S216490=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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

  public void thread225496(int [] tdone, int [] ends){
        switch(S214720){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\splitterController.sysj line: 91, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 93, column: 8
            auto_1.setPresent();//sysj\splitterController.sysj line: 93, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\splitterController.sysj line: 95, column: 12
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

  public void thread225494(int [] tdone, int [] ends){
        S225488=1;
    S225386=0;
    if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 265, column: 20
      S225386=1;
      if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 267, column: 20
        S225386=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 271, column: 14
          diverterExtend.setPresent();//sysj\splitterController.sysj line: 271, column: 32
          currsigs.addElement(diverterExtend);
          if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
            diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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
          if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 273, column: 14
            diverterRetract.setPresent();//sysj\splitterController.sysj line: 273, column: 33
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

  public void thread225493(int [] tdone, int [] ends){
        S225336=1;
    OK_thread_3 = 0;//sysj\splitterController.sysj line: 111, column: 3
    JAMMED_thread_3 = 1;//sysj\splitterController.sysj line: 113, column: 3
    STROKE_TIMEOUT_thread_3 = 12;//sysj\splitterController.sysj line: 121, column: 3
    w_thread_3 = null;//sysj\splitterController.sysj line: 125, column: 3
    t_thread_3 = 0;//sysj\splitterController.sysj line: 127, column: 3
    code_thread_3 = 0;//sysj\splitterController.sysj line: 129, column: 3
    confirmed_thread_3 = false;//sysj\splitterController.sysj line: 131, column: 3
    S216490=0;
    if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 137, column: 20
      S216490=1;
      if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 141, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S216490=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S214745=0;
        S214729=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 143, column: 5
          enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
          S214729=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S214724=0;
          if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
            enable_in.setACK(true);//sysj\splitterController.sysj line: 143, column: 5
            S214724=1;
            if(enable_in.isREQ()){//sysj\splitterController.sysj line: 143, column: 5
              enable_in.setACK(false);//sysj\splitterController.sysj line: 143, column: 5
              ends[3]=2;
              ;//sysj\splitterController.sysj line: 143, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 145, column: 5
              System.out.println("[SP] Armed for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 147, column: 5
              S214745=1;
              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 157, column: 21
                System.out.println("[SP] " + w_thread_3 + " at the decision point.");//sysj\splitterController.sysj line: 163, column: 5
                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 175, column: 5
                confirmed_thread_3 = false;//sysj\splitterController.sysj line: 177, column: 5
                S214745=2;
                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 179, column: 11
                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 181, column: 6
                  currsigs.addElement(diverterExtend);
                  if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 183, column: 14
                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 185, column: 7
                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 189, column: 6
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  ends[3]=2;
                  ;//sysj\splitterController.sysj line: 179, column: 5
                  code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 197, column: 5
                  S214745=3;
                  if(confirmed_thread_3){//sysj\splitterController.sysj line: 201, column: 5
                    System.out.println("[SP] Diverter at reject, routing " + w_thread_3 + " to the recycling conveyor.");//sysj\splitterController.sysj line: 203, column: 6
                    S214835=0;
                    if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 213, column: 22
                      S214835=1;
                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 219, column: 22
                        System.out.println("[SP] " + w_thread_3 + " released, diverter reset to the normal path.");//sysj\splitterController.sysj line: 225, column: 6
                        code_thread_3 = OK_thread_3;//sysj\splitterController.sysj line: 227, column: 6
                        if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                          System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                        }
                        S214745=4;
                        S214987=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                          S214987=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S214982=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                            S214982=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 249, column: 5
                              S216490=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 221, column: 7
                        currsigs.addElement(diverterRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 215, column: 7
                      currsigs.addElement(diverterExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(!confirmed_thread_3) {//sysj\splitterController.sysj line: 233, column: 19
                      System.out.println("[SP] FAULT: diverter did not reach the reject position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 235, column: 6
                    }
                    S214745=4;
                    S214987=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 249, column: 5
                      status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                      S214987=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S214982=0;
                      if(status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                        status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 249, column: 5
                        S214982=1;
                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 249, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 249, column: 5
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 249, column: 5
                          S216490=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
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
                admitBottle.setPresent();//sysj\splitterController.sysj line: 159, column: 6
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

  public void thread225492(int [] tdone, int [] ends){
        S214720=1;
    if(mode.getprestatus()){//sysj\splitterController.sysj line: 91, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 93, column: 8
        auto_1.setPresent();//sysj\splitterController.sysj line: 93, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\splitterController.sysj line: 95, column: 12
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
      switch(S225490){
        case 0 : 
          S225490=0;
          break RUN;
        
        case 1 : 
          S225490=2;
          S225490=2;
          auto_1.setClear();//sysj\splitterController.sysj line: 83, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 83, column: 2
          thread225492(tdone,ends);
          thread225493(tdone,ends);
          thread225494(tdone,ends);
          int biggest225495 = 0;
          if(ends[2]>=biggest225495){
            biggest225495=ends[2];
          }
          if(ends[3]>=biggest225495){
            biggest225495=ends[3];
          }
          if(ends[4]>=biggest225495){
            biggest225495=ends[4];
          }
          if(biggest225495 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\splitterController.sysj line: 83, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 83, column: 2
          thread225496(tdone,ends);
          thread225497(tdone,ends);
          thread225498(tdone,ends);
          int biggest225499 = 0;
          if(ends[2]>=biggest225499){
            biggest225499=ends[2];
          }
          if(ends[3]>=biggest225499){
            biggest225499=ends[3];
          }
          if(ends[4]>=biggest225499){
            biggest225499=ends[4];
          }
          if(biggest225499 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest225499 == 0){
            S225490=0;
            active[1]=0;
            ends[1]=0;
            S225490=0;
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
