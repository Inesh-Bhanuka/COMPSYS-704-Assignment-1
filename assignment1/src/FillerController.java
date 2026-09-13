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
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal valveOpenM = new Signal("valveOpenM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal fillTarget = new Signal("fillTarget", Signal.OUTPUT);
  public Signal valveOpen = new Signal("valveOpen", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private FillerTwin t_thread_3;//sysj\fillerController.sysj line: 50, column: 3
  private WorkpieceTwin w_thread_3;//sysj\fillerController.sysj line: 51, column: 3
  private int ml_thread_3;//sysj\fillerController.sysj line: 52, column: 3
  private int asked_thread_3;//sysj\fillerController.sysj line: 53, column: 3
  private boolean lidded_thread_3;//sysj\fillerController.sysj line: 54, column: 3
  private int S69540 = 1;
  private int S62018 = 1;
  private int S69538 = 1;
  private int S63272 = 1;
  private int S62042 = 1;
  private int S62026 = 1;
  private int S62021 = 1;
  private int S62049 = 1;
  private int S62265 = 1;
  private int S62260 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread69546(int [] tdone, int [] ends){
        switch(S69538){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S63272){
          case 0 : 
            if(reset.getprestatus()){//sysj\fillerController.sysj line: 57, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S63272=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S62042){
                case 0 : 
                  switch(S62026){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 58, column: 5
                        start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                        S62026=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S62021){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                              start_in.setACK(true);//sysj\fillerController.sysj line: 58, column: 5
                              S62021=1;
                              if(start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                                start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 58, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 59, column: 5
                                ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 62, column: 5
                                asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 63, column: 5
                                lidded_thread_3 = false;//sysj\fillerController.sysj line: 85, column: 5
                                if(w_thread_3 != null) {//sysj\fillerController.sysj line: 86, column: 18
                                  if(w_thread_3.catchFault("lid-fitted")) {//sysj\fillerController.sysj line: 87, column: 36
                                    w_thread_3.lid();//sysj\fillerController.sysj line: 88, column: 7
                                    w_thread_3.reject(Machine.FILLER, "arrived with a lid already fitted");//sysj\fillerController.sysj line: 89, column: 7
                                  }
                                  lidded_thread_3 = w_thread_3.isLidded();//sysj\fillerController.sysj line: 91, column: 6
                                }
                                S62042=1;
                                if(lidded_thread_3){//sysj\fillerController.sysj line: 94, column: 5
                                  System.out.println("[FILL] " + w_thread_3 + " has a lid fitted - refusing to fill.");//sysj\fillerController.sysj line: 95, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "lid fitted")){//sysj\fillerController.sysj line: 96, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 97, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 97, column: 7
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 100, column: 13
                                    if(w_thread_3 != null) {//sysj\fillerController.sysj line: 103, column: 19
                                      w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 104, column: 7
                                      w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 105, column: 7
                                    }
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 108, column: 13
                                      System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 110, column: 6
                                      w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 111, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 112, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 113, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 113, column: 7
                                        S62042=2;
                                        S62265=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          S62265=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S62260=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                            S62260=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 171, column: 5
                                              S63272=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        S62042=2;
                                        S62265=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          S62265=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S62260=0;
                                          if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                            S62260=1;
                                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              ends[3]=2;
                                              ;//sysj\fillerController.sysj line: 171, column: 5
                                              S63272=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 119, column: 33
                                        ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 134, column: 7
                                        if(ml_thread_3 < 1) {//sysj\fillerController.sysj line: 135, column: 17
                                          ml_thread_3 = 1;//sysj\fillerController.sysj line: 136, column: 8
                                        }
                                        System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 138, column: 7
                                      }
                                      System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 140, column: 6
                                      w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 141, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 142, column: 6
                                        twin.setPresent();//sysj\fillerController.sysj line: 143, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 143, column: 7
                                        S62049=0;
                                        if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                          S62049=1;
                                          if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                            w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                            if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                              System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                              w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                            }
                                            w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                            t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                              twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                            currsigs.addElement(valveOpen);
                                            fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                            currsigs.addElement(fillTarget);
                                            fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                            S62049=1;
                                            if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                              w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                              if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                                System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                                w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                              }
                                              w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                              t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                                twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                                currsigs.addElement(twin);
                                                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                                S62042=2;
                                                S62265=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62265=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S62260=0;
                                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                    S62260=1;
                                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                                      S63272=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                                S62042=2;
                                                S62265=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62265=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S62260=0;
                                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                    S62260=1;
                                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                                      S63272=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                              currsigs.addElement(valveOpen);
                                              fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                              currsigs.addElement(fillTarget);
                                              fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        S62049=0;
                                        if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                          S62049=1;
                                          if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                            w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                            if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                              System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                              w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                            }
                                            w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                            t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                              twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                            currsigs.addElement(valveOpen);
                                            fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                            currsigs.addElement(fillTarget);
                                            fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                            S62049=1;
                                            if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                              w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                              if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                                System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                                w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                              }
                                              w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                              t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                                twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                                currsigs.addElement(twin);
                                                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                                S62042=2;
                                                S62265=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62265=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S62260=0;
                                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                    S62260=1;
                                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                                      S63272=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                                S62042=2;
                                                S62265=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62265=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S62260=0;
                                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                    S62260=1;
                                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                                      S63272=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                              currsigs.addElement(valveOpen);
                                              fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                              currsigs.addElement(fillTarget);
                                              fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                            if(start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                              start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 58, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 59, column: 5
                              ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 62, column: 5
                              asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 63, column: 5
                              lidded_thread_3 = false;//sysj\fillerController.sysj line: 85, column: 5
                              if(w_thread_3 != null) {//sysj\fillerController.sysj line: 86, column: 18
                                if(w_thread_3.catchFault("lid-fitted")) {//sysj\fillerController.sysj line: 87, column: 36
                                  w_thread_3.lid();//sysj\fillerController.sysj line: 88, column: 7
                                  w_thread_3.reject(Machine.FILLER, "arrived with a lid already fitted");//sysj\fillerController.sysj line: 89, column: 7
                                }
                                lidded_thread_3 = w_thread_3.isLidded();//sysj\fillerController.sysj line: 91, column: 6
                              }
                              S62042=1;
                              if(lidded_thread_3){//sysj\fillerController.sysj line: 94, column: 5
                                System.out.println("[FILL] " + w_thread_3 + " has a lid fitted - refusing to fill.");//sysj\fillerController.sysj line: 95, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "lid fitted")){//sysj\fillerController.sysj line: 96, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 97, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 97, column: 7
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 100, column: 13
                                  if(w_thread_3 != null) {//sysj\fillerController.sysj line: 103, column: 19
                                    w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 104, column: 7
                                    w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 105, column: 7
                                  }
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 108, column: 13
                                    System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 110, column: 6
                                    w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 111, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 112, column: 6
                                      twin.setPresent();//sysj\fillerController.sysj line: 113, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 113, column: 7
                                      S62042=2;
                                      S62265=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        S62265=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S62260=0;
                                        if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                          S62260=1;
                                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            ends[3]=2;
                                            ;//sysj\fillerController.sysj line: 171, column: 5
                                            S63272=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      S62042=2;
                                      S62265=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        S62265=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S62260=0;
                                        if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                          S62260=1;
                                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            ends[3]=2;
                                            ;//sysj\fillerController.sysj line: 171, column: 5
                                            S63272=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 119, column: 33
                                      ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 134, column: 7
                                      if(ml_thread_3 < 1) {//sysj\fillerController.sysj line: 135, column: 17
                                        ml_thread_3 = 1;//sysj\fillerController.sysj line: 136, column: 8
                                      }
                                      System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 138, column: 7
                                    }
                                    System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 140, column: 6
                                    w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 141, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 142, column: 6
                                      twin.setPresent();//sysj\fillerController.sysj line: 143, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 143, column: 7
                                      S62049=0;
                                      if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                        S62049=1;
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                          S62049=1;
                                          if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                            w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                            if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                              System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                              w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                            }
                                            w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                            t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                              twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                            currsigs.addElement(valveOpen);
                                            fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                            currsigs.addElement(fillTarget);
                                            fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      S62049=0;
                                      if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                        S62049=1;
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                          S62049=1;
                                          if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                            w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                            if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                              System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                              w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                            }
                                            w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                            t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                              twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                              S62042=2;
                                              S62265=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                S62265=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S62260=0;
                                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                  S62260=1;
                                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                                    S63272=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                            currsigs.addElement(valveOpen);
                                            fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                            currsigs.addElement(fillTarget);
                                            fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                      S62026=1;
                      S62026=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 58, column: 5
                        start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                        S62026=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S62021=0;
                        if(!start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                          start_in.setACK(true);//sysj\fillerController.sysj line: 58, column: 5
                          S62021=1;
                          if(start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                            start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 58, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 59, column: 5
                            ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 62, column: 5
                            asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 63, column: 5
                            lidded_thread_3 = false;//sysj\fillerController.sysj line: 85, column: 5
                            if(w_thread_3 != null) {//sysj\fillerController.sysj line: 86, column: 18
                              if(w_thread_3.catchFault("lid-fitted")) {//sysj\fillerController.sysj line: 87, column: 36
                                w_thread_3.lid();//sysj\fillerController.sysj line: 88, column: 7
                                w_thread_3.reject(Machine.FILLER, "arrived with a lid already fitted");//sysj\fillerController.sysj line: 89, column: 7
                              }
                              lidded_thread_3 = w_thread_3.isLidded();//sysj\fillerController.sysj line: 91, column: 6
                            }
                            S62042=1;
                            if(lidded_thread_3){//sysj\fillerController.sysj line: 94, column: 5
                              System.out.println("[FILL] " + w_thread_3 + " has a lid fitted - refusing to fill.");//sysj\fillerController.sysj line: 95, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "lid fitted")){//sysj\fillerController.sysj line: 96, column: 6
                                twin.setPresent();//sysj\fillerController.sysj line: 97, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 97, column: 7
                                S62042=2;
                                S62265=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  S62265=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S62260=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                    S62260=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                      S63272=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S62042=2;
                                S62265=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  S62265=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S62260=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                    S62260=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                      S63272=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 100, column: 13
                                if(w_thread_3 != null) {//sysj\fillerController.sysj line: 103, column: 19
                                  w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 104, column: 7
                                  w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 105, column: 7
                                }
                                S62042=2;
                                S62265=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  S62265=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S62260=0;
                                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                    S62260=1;
                                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      ends[3]=2;
                                      ;//sysj\fillerController.sysj line: 171, column: 5
                                      S63272=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 108, column: 13
                                  System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 110, column: 6
                                  w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 111, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 112, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 113, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 113, column: 7
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 119, column: 33
                                    ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 134, column: 7
                                    if(ml_thread_3 < 1) {//sysj\fillerController.sysj line: 135, column: 17
                                      ml_thread_3 = 1;//sysj\fillerController.sysj line: 136, column: 8
                                    }
                                    System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 138, column: 7
                                  }
                                  System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 140, column: 6
                                  w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 141, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 142, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 143, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 143, column: 7
                                    S62049=0;
                                    if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                      S62049=1;
                                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                        }
                                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                          twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                          S62042=2;
                                          S62265=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            S62265=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S62260=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                              S62260=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 171, column: 5
                                                S63272=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                          S62042=2;
                                          S62265=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            S62265=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S62260=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                              S62260=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 171, column: 5
                                                S63272=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                        currsigs.addElement(valveOpen);
                                        fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                        currsigs.addElement(fillTarget);
                                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                        S62049=1;
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S62049=0;
                                    if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                                      S62049=1;
                                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                        }
                                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                          twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                          S62042=2;
                                          S62265=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            S62265=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S62260=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                              S62260=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 171, column: 5
                                                S63272=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                          S62042=2;
                                          S62265=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                            S62265=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S62260=0;
                                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                              S62260=1;
                                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                ends[3]=2;
                                                ;//sysj\fillerController.sysj line: 171, column: 5
                                                S63272=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                        currsigs.addElement(valveOpen);
                                        fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                        currsigs.addElement(fillTarget);
                                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                        S62049=1;
                                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                          }
                                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                            S62042=2;
                                            S62265=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                              S62265=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S62260=0;
                                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                                S62260=1;
                                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                                  S63272=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                          currsigs.addElement(valveOpen);
                                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                          currsigs.addElement(fillTarget);
                                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                  switch(S62049){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                        S62049=1;
                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                          }
                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                          currsigs.addElement(valveOpen);
                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                          currsigs.addElement(fillTarget);
                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                          S62049=1;
                          if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                            w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                            if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                              System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                              w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                            }
                            w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                            t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                              twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                              S62042=2;
                              S62265=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                S62265=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S62260=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                  S62260=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                    S63272=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                              S62042=2;
                              S62265=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                S62265=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S62260=0;
                                if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                  S62260=1;
                                  if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    ends[3]=2;
                                    ;//sysj\fillerController.sysj line: 171, column: 5
                                    S63272=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                            currsigs.addElement(valveOpen);
                            fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                            currsigs.addElement(fillTarget);
                            fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                            active[3]=1;
                            ends[3]=1;
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
                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                        }
                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                          twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                        currsigs.addElement(valveOpen);
                        fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                        currsigs.addElement(fillTarget);
                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  switch(S62265){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                        S62265=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S62260){
                          case 0 : 
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 171, column: 5
                              S63272=1;
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
                      S62265=1;
                      S62265=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                        S62265=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S62260=0;
                        if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                          S62260=1;
                          if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            ends[3]=2;
                            ;//sysj\fillerController.sysj line: 171, column: 5
                            S63272=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                
                case 3 : 
                  S63272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S63272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S63272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 6 : 
                  S63272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S63272=1;
            S63272=0;
            if(reset.getprestatus()){//sysj\fillerController.sysj line: 57, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S63272=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S62042=0;
              S62026=0;
              if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 58, column: 5
                start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                S62026=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S62021=0;
                if(!start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                  start_in.setACK(true);//sysj\fillerController.sysj line: 58, column: 5
                  S62021=1;
                  if(start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
                    start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
                    ends[3]=2;
                    ;//sysj\fillerController.sysj line: 58, column: 5
                    w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 59, column: 5
                    ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 62, column: 5
                    asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 63, column: 5
                    lidded_thread_3 = false;//sysj\fillerController.sysj line: 85, column: 5
                    if(w_thread_3 != null) {//sysj\fillerController.sysj line: 86, column: 18
                      if(w_thread_3.catchFault("lid-fitted")) {//sysj\fillerController.sysj line: 87, column: 36
                        w_thread_3.lid();//sysj\fillerController.sysj line: 88, column: 7
                        w_thread_3.reject(Machine.FILLER, "arrived with a lid already fitted");//sysj\fillerController.sysj line: 89, column: 7
                      }
                      lidded_thread_3 = w_thread_3.isLidded();//sysj\fillerController.sysj line: 91, column: 6
                    }
                    S62042=1;
                    if(lidded_thread_3){//sysj\fillerController.sysj line: 94, column: 5
                      System.out.println("[FILL] " + w_thread_3 + " has a lid fitted - refusing to fill.");//sysj\fillerController.sysj line: 95, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "lid fitted")){//sysj\fillerController.sysj line: 96, column: 6
                        twin.setPresent();//sysj\fillerController.sysj line: 97, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 97, column: 7
                        S62042=2;
                        S62265=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                          S62265=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S62260=0;
                          if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                            S62260=1;
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 171, column: 5
                              S63272=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S62042=2;
                        S62265=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                          S62265=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S62260=0;
                          if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                            S62260=1;
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 171, column: 5
                              S63272=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 100, column: 13
                        if(w_thread_3 != null) {//sysj\fillerController.sysj line: 103, column: 19
                          w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 104, column: 7
                          w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 105, column: 7
                        }
                        S62042=2;
                        S62265=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                          S62265=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S62260=0;
                          if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                            S62260=1;
                            if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              ends[3]=2;
                              ;//sysj\fillerController.sysj line: 171, column: 5
                              S63272=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 108, column: 13
                          System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 110, column: 6
                          w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 111, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 112, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 113, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 113, column: 7
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 119, column: 33
                            ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 134, column: 7
                            if(ml_thread_3 < 1) {//sysj\fillerController.sysj line: 135, column: 17
                              ml_thread_3 = 1;//sysj\fillerController.sysj line: 136, column: 8
                            }
                            System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 138, column: 7
                          }
                          System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 140, column: 6
                          w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 141, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 142, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 143, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 143, column: 7
                            S62049=0;
                            if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                              S62049=1;
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                S62049=1;
                                if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                  w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                  if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                    System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                    w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                  }
                                  w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                  t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                  currsigs.addElement(valveOpen);
                                  fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                  currsigs.addElement(fillTarget);
                                  fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S62049=0;
                            if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                              S62049=1;
                              if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                  System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                  w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                }
                                w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                  twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                  S62042=2;
                                  S62265=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                    done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                    S62265=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S62260=0;
                                    if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                      S62260=1;
                                      if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                        ends[3]=2;
                                        ;//sysj\fillerController.sysj line: 171, column: 5
                                        S63272=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                currsigs.addElement(valveOpen);
                                fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                                S62049=1;
                                if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                                  w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                                  if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                                    System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                                    w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                                  }
                                  w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                                  t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                                    twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                                    S62042=2;
                                    S62265=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                      S62265=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S62260=0;
                                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                        S62260=1;
                                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                          ends[3]=2;
                                          ;//sysj\fillerController.sysj line: 171, column: 5
                                          S63272=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                                  currsigs.addElement(valveOpen);
                                  fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                                  currsigs.addElement(fillTarget);
                                  fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
            break;
          
        }
        break;
      
    }
  }

  public void thread69545(int [] tdone, int [] ends){
        switch(S62018){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\fillerController.sysj line: 39, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\fillerController.sysj line: 42, column: 8
            auto_1.setPresent();//sysj\fillerController.sysj line: 42, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\fillerController.sysj line: 43, column: 13
              manual_1.setPresent();//sysj\fillerController.sysj line: 43, column: 35
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

  public void thread69543(int [] tdone, int [] ends){
        S69538=1;
    t_thread_3 = new FillerTwin();//sysj\fillerController.sysj line: 50, column: 3
    w_thread_3 = null;//sysj\fillerController.sysj line: 51, column: 3
    ml_thread_3 = 0;//sysj\fillerController.sysj line: 52, column: 3
    asked_thread_3 = 0;//sysj\fillerController.sysj line: 53, column: 3
    lidded_thread_3 = false;//sysj\fillerController.sysj line: 54, column: 3
    S63272=0;
    if(reset.getprestatus()){//sysj\fillerController.sysj line: 57, column: 20
      start_in.setPreempted();
      done_o.setPreempted();
      S63272=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S62042=0;
      S62026=0;
      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\fillerController.sysj line: 58, column: 5
        start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
        S62026=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S62021=0;
        if(!start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
          start_in.setACK(true);//sysj\fillerController.sysj line: 58, column: 5
          S62021=1;
          if(start_in.isREQ()){//sysj\fillerController.sysj line: 58, column: 5
            start_in.setACK(false);//sysj\fillerController.sysj line: 58, column: 5
            ends[3]=2;
            ;//sysj\fillerController.sysj line: 58, column: 5
            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\fillerController.sysj line: 59, column: 5
            ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj\fillerController.sysj line: 62, column: 5
            asked_thread_3 = ml_thread_3;//sysj\fillerController.sysj line: 63, column: 5
            lidded_thread_3 = false;//sysj\fillerController.sysj line: 85, column: 5
            if(w_thread_3 != null) {//sysj\fillerController.sysj line: 86, column: 18
              if(w_thread_3.catchFault("lid-fitted")) {//sysj\fillerController.sysj line: 87, column: 36
                w_thread_3.lid();//sysj\fillerController.sysj line: 88, column: 7
                w_thread_3.reject(Machine.FILLER, "arrived with a lid already fitted");//sysj\fillerController.sysj line: 89, column: 7
              }
              lidded_thread_3 = w_thread_3.isLidded();//sysj\fillerController.sysj line: 91, column: 6
            }
            S62042=1;
            if(lidded_thread_3){//sysj\fillerController.sysj line: 94, column: 5
              System.out.println("[FILL] " + w_thread_3 + " has a lid fitted - refusing to fill.");//sysj\fillerController.sysj line: 95, column: 6
              if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "lid fitted")){//sysj\fillerController.sysj line: 96, column: 6
                twin.setPresent();//sysj\fillerController.sysj line: 97, column: 7
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 97, column: 7
                S62042=2;
                S62265=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                  S62265=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S62260=0;
                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                    S62260=1;
                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                      ends[3]=2;
                      ;//sysj\fillerController.sysj line: 171, column: 5
                      S63272=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                S62042=2;
                S62265=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                  S62265=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S62260=0;
                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                    S62260=1;
                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                      ends[3]=2;
                      ;//sysj\fillerController.sysj line: 171, column: 5
                      S63272=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
            }
            else {
              if(ml_thread_3 == 0){//sysj\fillerController.sysj line: 100, column: 13
                if(w_thread_3 != null) {//sysj\fillerController.sysj line: 103, column: 19
                  w_thread_3.dispensed(0);//sysj\fillerController.sysj line: 104, column: 7
                  w_thread_3.completed(Machine.FILLER, "zero-percent ingredient");//sysj\fillerController.sysj line: 105, column: 7
                }
                S62042=2;
                S62265=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                  S62265=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S62260=0;
                  if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                    done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                    S62260=1;
                    if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                      ends[3]=2;
                      ;//sysj\fillerController.sysj line: 171, column: 5
                      S63272=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                if(!w_thread_3.fits(ml_thread_3)){//sysj\fillerController.sysj line: 108, column: 13
                  System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj\fillerController.sysj line: 110, column: 6
                  w_thread_3.reject(Machine.FILLER, "would overflow");//sysj\fillerController.sysj line: 111, column: 6
                  if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", "overflow")){//sysj\fillerController.sysj line: 112, column: 6
                    twin.setPresent();//sysj\fillerController.sysj line: 113, column: 7
                    currsigs.addElement(twin);
                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 113, column: 7
                    S62042=2;
                    S62265=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                      S62265=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S62260=0;
                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                        S62260=1;
                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                          ends[3]=2;
                          ;//sysj\fillerController.sysj line: 171, column: 5
                          S63272=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    S62042=2;
                    S62265=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                      done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                      S62265=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S62260=0;
                      if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                        done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                        S62260=1;
                        if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                          done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                          ends[3]=2;
                          ;//sysj\fillerController.sysj line: 171, column: 5
                          S63272=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                }
                else {
                  if(w_thread_3.catchFault("misfill")) {//sysj\fillerController.sysj line: 119, column: 33
                    ml_thread_3 = ml_thread_3 - 30;//sysj\fillerController.sysj line: 134, column: 7
                    if(ml_thread_3 < 1) {//sysj\fillerController.sysj line: 135, column: 17
                      ml_thread_3 = 1;//sysj\fillerController.sysj line: 136, column: 8
                    }
                    System.out.println("[FILL] Metering fault on " + w_thread_3 + ".");//sysj\fillerController.sysj line: 138, column: 7
                  }
                  System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj\fillerController.sysj line: 140, column: 6
                  w_thread_3.started(Machine.FILLER, "liquid " + w_thread_3.nextLiquidName());//sysj\fillerController.sysj line: 141, column: 6
                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "valveOpen", ml_thread_3 + "ml")){//sysj\fillerController.sysj line: 142, column: 6
                    twin.setPresent();//sysj\fillerController.sysj line: 143, column: 7
                    currsigs.addElement(twin);
                    twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 143, column: 7
                    S62049=0;
                    if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                      S62049=1;
                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                        }
                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                          twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                        currsigs.addElement(valveOpen);
                        fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                        currsigs.addElement(fillTarget);
                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                        S62049=1;
                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                          }
                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                          currsigs.addElement(valveOpen);
                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                          currsigs.addElement(fillTarget);
                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    S62049=0;
                    if(auto_1.getprestatus()){//sysj\fillerController.sysj line: 148, column: 22
                      S62049=1;
                      if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                        w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                        if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                          System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                          w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                        }
                        w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                        t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                          twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                          S62042=2;
                          S62265=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                            done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                            S62265=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S62260=0;
                            if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                              S62260=1;
                              if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                ends[3]=2;
                                ;//sysj\fillerController.sysj line: 171, column: 5
                                S63272=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                        currsigs.addElement(valveOpen);
                        fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                        currsigs.addElement(fillTarget);
                        fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(valveOpenM.getprestatus()){//sysj\fillerController.sysj line: 148, column: 45
                        S62049=1;
                        if(filled.getprestatus()){//sysj\fillerController.sysj line: 149, column: 22
                          w_thread_3.dispensed(ml_thread_3);//sysj\fillerController.sysj line: 157, column: 6
                          if(!w_thread_3.lastFillInTolerance(asked_thread_3)) {//sysj\fillerController.sysj line: 158, column: 39
                            System.out.println("[FILL] Out of tolerance: asked " + asked_thread_3 + "ml, metered " + ml_thread_3 + "ml.");//sysj\fillerController.sysj line: 159, column: 7
                            w_thread_3.reject(Machine.FILLER, "fill out of tolerance");//sysj\fillerController.sysj line: 160, column: 7
                          }
                          w_thread_3.completed(Machine.FILLER, "fill complete");//sysj\fillerController.sysj line: 162, column: 6
                          t_thread_3.setDispensed(ml_thread_3, ml_thread_3 / 20);//sysj\fillerController.sysj line: 163, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "valveShut", ml_thread_3 + "ml dispensed")){//sysj\fillerController.sysj line: 164, column: 6
                            twin.setPresent();//sysj\fillerController.sysj line: 165, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\fillerController.sysj line: 165, column: 7
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj\fillerController.sysj line: 167, column: 6
                            S62042=2;
                            S62265=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\fillerController.sysj line: 171, column: 5
                              done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                              S62265=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S62260=0;
                              if(done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                done_o.setVal(w_thread_3);//sysj\fillerController.sysj line: 171, column: 5
                                S62260=1;
                                if(!done_o.isACK()){//sysj\fillerController.sysj line: 171, column: 5
                                  done_o.setREQ(false);//sysj\fillerController.sysj line: 171, column: 5
                                  ends[3]=2;
                                  ;//sysj\fillerController.sysj line: 171, column: 5
                                  S63272=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          valveOpen.setPresent();//sysj\fillerController.sysj line: 151, column: 8
                          currsigs.addElement(valveOpen);
                          fillTarget.setPresent();//sysj\fillerController.sysj line: 152, column: 8
                          currsigs.addElement(fillTarget);
                          fillTarget.setValue(ml_thread_3);//sysj\fillerController.sysj line: 152, column: 8
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
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

  public void thread69542(int [] tdone, int [] ends){
        S62018=1;
    if(mode.getprestatus()){//sysj\fillerController.sysj line: 39, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\fillerController.sysj line: 42, column: 8
        auto_1.setPresent();//sysj\fillerController.sysj line: 42, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\fillerController.sysj line: 43, column: 13
          manual_1.setPresent();//sysj\fillerController.sysj line: 43, column: 35
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
      switch(S69540){
        case 0 : 
          S69540=0;
          break RUN;
        
        case 1 : 
          S69540=2;
          S69540=2;
          auto_1.setClear();//sysj\fillerController.sysj line: 35, column: 2
          manual_1.setClear();//sysj\fillerController.sysj line: 35, column: 2
          thread69542(tdone,ends);
          thread69543(tdone,ends);
          int biggest69544 = 0;
          if(ends[2]>=biggest69544){
            biggest69544=ends[2];
          }
          if(ends[3]>=biggest69544){
            biggest69544=ends[3];
          }
          if(biggest69544 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\fillerController.sysj line: 35, column: 2
          manual_1.setClear();//sysj\fillerController.sysj line: 35, column: 2
          thread69545(tdone,ends);
          thread69546(tdone,ends);
          int biggest69547 = 0;
          if(ends[2]>=biggest69547){
            biggest69547=ends[2];
          }
          if(ends[3]>=biggest69547){
            biggest69547=ends[3];
          }
          if(biggest69547 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest69547 == 0){
            S69540=0;
            active[1]=0;
            ends[1]=0;
            S69540=0;
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
          start_in.gethook();
          done_o.gethook();
          mode.gethook();
          reset.gethook();
          filled.gethook();
          valveOpenM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
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
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
        mode.gethook();
        reset.gethook();
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
