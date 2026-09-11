import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class FillerController extends ClockDomain{
  public FillerController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal valveOpenM = new Signal("valveOpenM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal fillTarget = new Signal("fillTarget", Signal.OUTPUT);
  public Signal valveOpen = new Signal("valveOpen", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private FillerTwin t_thread_3;//sysj\fillerController.sysj line: 44, column: 3
  private WorkpieceTwin w_thread_3;//sysj\fillerController.sysj line: 45, column: 3
  private int ml_thread_3;//sysj\fillerController.sysj line: 46, column: 3
  private int asked_thread_3;//sysj\fillerController.sysj line: 47, column: 3
  private boolean permitted_thread_3;//sysj\fillerController.sysj line: 56, column: 1
  private int S47562 = 1;
  private int S31455 = 1;
  private int S47489 = 1;
  private int S34128 = 1;
  private int S31480 = 1;
  private int S31464 = 1;
  private int S31459 = 1;
  private int S31481 = 1;
  private int S31671 = 1;
  private int S31666 = 1;
  private int S47560 = 1;
  private int S47512 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread47570(int [] tdone, int [] ends){
        switch(S47560){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S47512){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 128, column: 20
              S47512=1;
              if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 129, column: 20
                S47512=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 131, column: 14
                  valveOpen.setPresent();//sysj\fillerController.sysj line: 131, column: 27
                  currsigs.addElement(valveOpen);
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
            if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 129, column: 20
              S47512=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 131, column: 14
                valveOpen.setPresent();//sysj\fillerController.sysj line: 131, column: 27
                currsigs.addElement(valveOpen);
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
            S47512=2;
            S47512=0;
            if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 128, column: 20
              S47512=1;
              if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 129, column: 20
                S47512=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 131, column: 14
                  valveOpen.setPresent();//sysj\fillerController.sysj line: 131, column: 27
                  currsigs.addElement(valveOpen);
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

  public void thread47569(int [] tdone, int [] ends){
        switch(S47489){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S34128){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 50, column: 20
              S34128=1;
              if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S34128=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S31480=0;
                S31464=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                  S31464=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S31459=0;
                  if(!start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\fillerController.sysj line: 53, column: 5
                    S31459=1;
                    if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\fillerController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
                      S31480=1;
                      if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                        S31481=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                        asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                        S31480=2;
                        if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                          if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                            w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                            w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                          }
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                            System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                            w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                              twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                              S31480=3;
                              S31671=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                S31671=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S31666=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                  S31666=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 120, column: 5
                                    S34128=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S31480=3;
                              S31671=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                S31671=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S31666=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                  S31666=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 120, column: 5
                                    S34128=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                              ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                              System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                            }
                            System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                            w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                              twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
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
            if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 52, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S34128=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S31480){
                case 0 : 
                  switch(S31464){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                        S31464=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S31459){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                              start_in.setACK(true);//sysj\fillerController.sysj line: 53, column: 5
                              S31459=1;
                              if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                                start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 53, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
                                S31480=1;
                                if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                                  permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                                  S31481=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                                  asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                                  S31480=2;
                                  if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                                    if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                                      w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                                      w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                                    }
                                    S31480=3;
                                    S31671=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      S31671=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S31666=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                        S31666=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 120, column: 5
                                          S34128=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                                      System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                                      w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                                        ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                                        System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                                      }
                                      System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                                      w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                            S31480=3;
                                            S31671=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              S31671=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S31666=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                                S31666=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                                  S34128=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                            S31480=3;
                                            S31671=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              S31671=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S31666=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                                S31666=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                                  S34128=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                            S31480=3;
                                            S31671=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              S31671=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S31666=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                                S31666=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                                  S34128=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                            S31480=3;
                                            S31671=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              S31671=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S31666=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                                S31666=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                                  S34128=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
                                active[3]=1;
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
                            if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                              start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 53, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
                              S31480=1;
                              if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                                permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                                S31481=0;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                                asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                                S31480=2;
                                if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                                  if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                                    w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                                    w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                                  }
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                                    System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                                    w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                                      twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                                      S31480=3;
                                      S31671=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        S31671=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S31666=0;
                                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                          S31666=1;
                                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            ends[3]=2;
                                            ;//sysj\fillerController.sysj line: 120, column: 5
                                            S34128=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      S31480=3;
                                      S31671=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        S31671=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S31666=0;
                                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                          S31666=1;
                                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            ends[3]=2;
                                            ;//sysj\fillerController.sysj line: 120, column: 5
                                            S34128=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                                      ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                                      System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                                    }
                                    System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                                    w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                                      twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                        }
                                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                          twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                          S31480=3;
                                          S31671=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            S31671=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S31666=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                              S31666=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 120, column: 5
                                                S34128=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                          S31480=3;
                                          S31671=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            S31671=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S31666=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                              S31666=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 120, column: 5
                                                S34128=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                        currsigs.addElement(valveOpen);
                                        fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                        currsigs.addElement(fillTarget);
                                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                        }
                                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                          twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                          S31480=3;
                                          S31671=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            S31671=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S31666=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                              S31666=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 120, column: 5
                                                S34128=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                          S31480=3;
                                          S31671=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                            S31671=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S31666=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                              S31666=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 120, column: 5
                                                S34128=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
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
                                        valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                        currsigs.addElement(valveOpen);
                                        fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                        currsigs.addElement(fillTarget);
                                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S31464=1;
                      S31464=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                        S31464=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31459=0;
                        if(!start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                          start_in.setACK(true);//sysj\fillerController.sysj line: 53, column: 5
                          S31459=1;
                          if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                            start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 53, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
                            S31480=1;
                            if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                              permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                              S31481=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                              asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                              S31480=2;
                              if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                                if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                                  w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                                  w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                                }
                                S31480=3;
                                S31671=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  S31671=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S31666=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                    S31666=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 120, column: 5
                                      S34128=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                                  System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                                  w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                                    S31480=3;
                                    S31671=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      S31671=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S31666=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                        S31666=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 120, column: 5
                                          S34128=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S31480=3;
                                    S31671=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      S31671=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S31666=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                        S31666=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 120, column: 5
                                          S34128=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                                    ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                                    System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                                  }
                                  System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                                  w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                                    if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                      w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                      if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                        System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                        w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                      }
                                      w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                      t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                        System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                      currsigs.addElement(valveOpen);
                                      fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                      currsigs.addElement(fillTarget);
                                      fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                      w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                      if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                        System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                        w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                      }
                                      w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                      t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                        System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                        S31480=3;
                                        S31671=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                          S31671=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S31666=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                            S31666=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 120, column: 5
                                              S34128=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                      currsigs.addElement(valveOpen);
                                      fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                      currsigs.addElement(fillTarget);
                                      fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
                            active[3]=1;
                            ends[3]=1;
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
                  switch(S31481){
                    case 0 : 
                      S31481=0;
                      S31481=1;
                      if(!permitted_thread_3){//sysj\fillerController.sysj line: 58, column: 19
                        permitted_thread_3 = GuiStep.take(w_thread_3.nextLiquid() == 0 ? "FILL1" : "FILL2", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\fillerController.sysj line: 59, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\fillerController.sysj line: 58, column: 13
                        S31481=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!permitted_thread_3){//sysj\fillerController.sysj line: 58, column: 19
                        permitted_thread_3 = GuiStep.take(w_thread_3.nextLiquid() == 0 ? "FILL1" : "FILL2", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\fillerController.sysj line: 59, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\fillerController.sysj line: 58, column: 13
                        S31481=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      S31481=2;
                      ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                      asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                      S31480=2;
                      if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                        if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                          w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                          w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                        }
                        S31480=3;
                        S31671=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                          S31671=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S31666=0;
                          if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                            S31666=1;
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 120, column: 5
                              S34128=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                          System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                          w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                            S31480=3;
                            S31671=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                              S31671=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S31666=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                S31666=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                  S34128=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S31480=3;
                            S31671=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                              S31671=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S31666=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                S31666=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 120, column: 5
                                  S34128=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                          if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                            ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                            System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                          }
                          System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                          w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                            if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                              w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                              if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                              }
                              w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                              t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                S31480=3;
                                S31671=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  S31671=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S31666=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                    S31666=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 120, column: 5
                                      S34128=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                S31480=3;
                                S31671=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  S31671=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S31666=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                    S31666=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 120, column: 5
                                      S34128=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                              currsigs.addElement(valveOpen);
                              fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                              currsigs.addElement(fillTarget);
                              fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                              w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                              if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                              }
                              w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                              t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                S31480=3;
                                S31671=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  S31671=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S31666=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                    S31666=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 120, column: 5
                                      S34128=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                S31480=3;
                                S31671=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                  S31671=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S31666=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                    S31666=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 120, column: 5
                                      S34128=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                              currsigs.addElement(valveOpen);
                              fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                              currsigs.addElement(fillTarget);
                              fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                    w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                    if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                      System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                      w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                    }
                    w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                    t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                      twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                      System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                      S31480=3;
                      S31671=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31666=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                          S31666=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 120, column: 5
                            S34128=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                      S31480=3;
                      S31671=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31666=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                          S31666=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 120, column: 5
                            S34128=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
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
                    valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                    currsigs.addElement(valveOpen);
                    fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                    currsigs.addElement(fillTarget);
                    fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  switch(S31671){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S31666){
                          case 0 : 
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 120, column: 5
                              S34128=2;
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
                      S31671=1;
                      S31671=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31666=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                          S31666=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 120, column: 5
                            S34128=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                
                case 4 : 
                  S34128=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S34128=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 6 : 
                  S34128=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S34128=2;
            S34128=0;
            if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 50, column: 20
              S34128=1;
              if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S34128=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S31480=0;
                S31464=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                  S31464=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S31459=0;
                  if(!start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\fillerController.sysj line: 53, column: 5
                    S31459=1;
                    if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\fillerController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
                      S31480=1;
                      if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                        S31481=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                        asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                        S31480=2;
                        if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                          if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                            w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                            w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                          }
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                            System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                            w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                              twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                              S31480=3;
                              S31671=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                S31671=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S31666=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                  S31666=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 120, column: 5
                                    S34128=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S31480=3;
                              S31671=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                S31671=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S31666=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                  S31666=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 120, column: 5
                                    S34128=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                              ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                              System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                            }
                            System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                            w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                              twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                                  S31480=3;
                                  S31671=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                    S31671=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S31666=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                                      S31666=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 120, column: 5
                                        S34128=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
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

  public void thread47568(int [] tdone, int [] ends){
        switch(S31455){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\fillerController.sysj line: 35, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\fillerController.sysj line: 36, column: 8
            auto_1.setPresent();//sysj\fillerController.sysj line: 36, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\fillerController.sysj line: 37, column: 12
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

  public void thread47566(int [] tdone, int [] ends){
        S47560=1;
    S47512=0;
    if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 128, column: 20
      S47512=1;
      if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 129, column: 20
        S47512=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 131, column: 14
          valveOpen.setPresent();//sysj\fillerController.sysj line: 131, column: 27
          currsigs.addElement(valveOpen);
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

  public void thread47565(int [] tdone, int [] ends){
        S47489=1;
    t_thread_3 = new FillerTwin();//sysj\fillerController.sysj line: 44, column: 3
    w_thread_3 = null;//sysj\fillerController.sysj line: 45, column: 3
    ml_thread_3 = 0;//sysj\fillerController.sysj line: 46, column: 3
    asked_thread_3 = 0;//sysj\fillerController.sysj line: 47, column: 3
    S34128=0;
    if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 50, column: 20
      S34128=1;
      if(manual_1.getprestatus()){//sysj\fillerController.sysj line: 52, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S34128=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S31480=0;
        S31464=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 53, column: 5
          start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
          S31464=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S31459=0;
          if(!start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
            start_in.setACK(true);//sysj\fillerController.sysj line: 53, column: 5
            S31459=1;
            if(start_in.isREQ()){//sysj\fillerController.sysj line: 53, column: 5
              start_in.setACK(false);//sysj\fillerController.sysj line: 53, column: 5
              ends[3]=2;
              ;//sysj\fillerController.sysj line: 53, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 54, column: 5
              S31480=1;
              if(w_thread_3 != null){//sysj\fillerController.sysj line: 55, column: 4
                permitted_thread_3 = false;//sysj\fillerController.sysj line: 56, column: 1
                S31481=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 65, column: 5
                asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 66, column: 5
                S31480=2;
                if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 68, column: 8
                  if(w_thread_3 != null) {//sysj\fillerController.sysj line: 71, column: 19
                    w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 72, column: 7
                    w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 73, column: 7
                  }
                  S31480=3;
                  S31671=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                    done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                    S31671=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S31666=0;
                    if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                      S31666=1;
                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        ends[3]=2;
                        ;//sysj\fillerController.sysj line: 120, column: 5
                        S34128=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 76, column: 13
                    System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 78, column: 6
                    w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 79, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 80, column: 6
                      twin.setPresent();//sysj\fillerController.sysj line: 81, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 81, column: 7
                      S31480=3;
                      S31671=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31666=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                          S31666=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 120, column: 5
                            S34128=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      S31480=3;
                      S31671=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                        S31671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S31666=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                          S31666=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 120, column: 5
                            S34128=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
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
                    if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 87, column: 33
                      ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 88, column: 7
                      System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 89, column: 7
                    }
                    System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 91, column: 6
                    w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 92, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 93, column: 6
                      twin.setPresent();//sysj\fillerController.sysj line: 94, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 94, column: 7
                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                        }
                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                          twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                        valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                        currsigs.addElement(valveOpen);
                        fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                        currsigs.addElement(fillTarget);
                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 99, column: 22
                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 107, column: 6
                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 108, column: 39
                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 109, column: 7
                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 110, column: 7
                        }
                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 112, column: 6
                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 113, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 114, column: 6
                          twin.setPresent();//sysj\fillerController.sysj line: 115, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 115, column: 7
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 117, column: 6
                          S31480=3;
                          S31671=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 120, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                            S31671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S31666=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 120, column: 5
                              S31666=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 120, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 120, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 120, column: 5
                                S34128=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                        valveOpen.setPresent();//sysj\fillerController.sysj line: 101, column: 8
                        currsigs.addElement(valveOpen);
                        fillTarget.setPresent();//sysj\fillerController.sysj line: 102, column: 8
                        currsigs.addElement(fillTarget);
                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 102, column: 8
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
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
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

  public void thread47564(int [] tdone, int [] ends){
        S31455=1;
    if(mode.getprestatus()){//sysj\fillerController.sysj line: 35, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\fillerController.sysj line: 36, column: 8
        auto_1.setPresent();//sysj\fillerController.sysj line: 36, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\fillerController.sysj line: 37, column: 12
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
      switch(S47562){
        case 0 : 
          S47562=0;
          break RUN;
        
        case 1 : 
          S47562=2;
          S47562=2;
          auto_1.setClear();//sysj\fillerController.sysj line: 31, column: 2
          manual_1.setClear();//sysj\fillerController.sysj line: 31, column: 2
          thread47564(tdone,ends);
          thread47565(tdone,ends);
          thread47566(tdone,ends);
          int biggest47567 = 0;
          if(ends[2]>=biggest47567){
            biggest47567=ends[2];
          }
          if(ends[3]>=biggest47567){
            biggest47567=ends[3];
          }
          if(ends[4]>=biggest47567){
            biggest47567=ends[4];
          }
          if(biggest47567 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\fillerController.sysj line: 31, column: 2
          manual_1.setClear();//sysj\fillerController.sysj line: 31, column: 2
          thread47568(tdone,ends);
          thread47569(tdone,ends);
          thread47570(tdone,ends);
          int biggest47571 = 0;
          if(ends[2]>=biggest47571){
            biggest47571=ends[2];
          }
          if(ends[3]>=biggest47571){
            biggest47571=ends[3];
          }
          if(ends[4]>=biggest47571){
            biggest47571=ends[4];
          }
          if(biggest47571 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest47571 == 0){
            S47562=0;
            active[1]=0;
            ends[1]=0;
            S47562=0;
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
          start_in.gethook();
          done_o.gethook();
          operatorPermit.gethook();
          mode.gethook();
          filled.gethook();
          valveOpenM.gethook();
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
      mode.setpreclear();
      filled.setpreclear();
      valveOpenM.setpreclear();
      twin.setpreclear();
      fillTarget.setpreclear();
      valveOpen.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = filled.getStatus() ? filled.setprepresent() : filled.setpreclear();
      filled.setpreval(filled.getValue());
      filled.setClear();
      dummyint = valveOpenM.getStatus() ? valveOpenM.setprepresent() : valveOpenM.setpreclear();
      valveOpenM.setpreval(valveOpenM.getValue());
      valveOpenM.setClear();
      twin.sethook();
      twin.setClear();
      fillTarget.sethook();
      fillTarget.setClear();
      valveOpen.sethook();
      valveOpen.setClear();
      auto_1.setClear();
      manual_1.setClear();
      start_in.sethook();
      done_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        start_in.gethook();
        done_o.gethook();
        operatorPermit.gethook();
        mode.gethook();
        filled.gethook();
        valveOpenM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
