import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal capSeated = new Signal("capSeated", Signal.INPUT);
  public Signal screwOnM = new Signal("screwOnM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal screwOn = new Signal("screwOn", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LidCapperTwin t_thread_3;//sysj\capperController.sysj line: 47, column: 3
  private WorkpieceTwin w_thread_3;//sysj\capperController.sysj line: 48, column: 3
  private int S32550 = 1;
  private int S26804 = 1;
  private int S32548 = 1;
  private int S27762 = 1;
  private int S26828 = 1;
  private int S26812 = 1;
  private int S26807 = 1;
  private int S26829 = 1;
  private int S27019 = 1;
  private int S27014 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread32556(int [] tdone, int [] ends){
        switch(S32548){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S27762){
          case 0 : 
            if(reset.getprestatus()){//sysj\capperController.sysj line: 51, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S27762=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S26828){
                case 0 : 
                  switch(S26812){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                        S26812=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S26807){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                              start_in.setACK(true);//sysj\capperController.sysj line: 52, column: 5
                              S26807=1;
                              if(start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                                start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 52, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 53, column: 5
                                S26828=1;
                                if(w_thread_3 != null){//sysj\capperController.sysj line: 56, column: 8
                                  System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 57, column: 6
                                  w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 58, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 59, column: 6
                                    twin.setPresent();//sysj\capperController.sysj line: 60, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\capperController.sysj line: 60, column: 7
                                    S26829=0;
                                    if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                      S26829=1;
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                        if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                          System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                          w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                        }
                                        w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                        S26829=1;
                                        if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                          if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                            System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                            w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                          }
                                          w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                          t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                            twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                            S26828=2;
                                            S27019=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              S27019=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S27014=0;
                                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                                S27014=1;
                                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\capperController.sysj line: 84, column: 5
                                                  S27762=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                            S26828=2;
                                            S27019=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              S27019=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S27014=0;
                                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                                S27014=1;
                                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\capperController.sysj line: 84, column: 5
                                                  S27762=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                          currsigs.addElement(screwOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S26829=0;
                                    if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                      S26829=1;
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                        if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                          System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                          w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                        }
                                        w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                        S26829=1;
                                        if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                          if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                            System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                            w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                          }
                                          w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                          t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                            twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                            S26828=2;
                                            S27019=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              S27019=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S27014=0;
                                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                                S27014=1;
                                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\capperController.sysj line: 84, column: 5
                                                  S27762=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                            S26828=2;
                                            S27019=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              S27019=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S27014=0;
                                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                                S27014=1;
                                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\capperController.sysj line: 84, column: 5
                                                  S27762=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                          currsigs.addElement(screwOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  S26828=2;
                                  S27019=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    S27019=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S27014=0;
                                    if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                      S27014=1;
                                      if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                        ends[3]=2;
                                        ;//sysj\capperController.sysj line: 84, column: 5
                                        S27762=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                              start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 52, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 53, column: 5
                              S26828=1;
                              if(w_thread_3 != null){//sysj\capperController.sysj line: 56, column: 8
                                System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 57, column: 6
                                w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 58, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 59, column: 6
                                  twin.setPresent();//sysj\capperController.sysj line: 60, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\capperController.sysj line: 60, column: 7
                                  S26829=0;
                                  if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                    S26829=1;
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                      }
                                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                      S26829=1;
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                        if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                          System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                          w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                        }
                                        w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S26829=0;
                                  if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                    S26829=1;
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                      }
                                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                      S26829=1;
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                        if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                          System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                          w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                        }
                                        w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                          S26828=2;
                                          S27019=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            S27019=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S27014=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                              S27014=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 84, column: 5
                                                S27762=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S26828=2;
                                S27019=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  S27019=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S27014=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                    S27014=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 84, column: 5
                                      S27762=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S26812=1;
                      S26812=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                        S26812=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S26807=0;
                        if(!start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                          start_in.setACK(true);//sysj\capperController.sysj line: 52, column: 5
                          S26807=1;
                          if(start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                            start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 52, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 53, column: 5
                            S26828=1;
                            if(w_thread_3 != null){//sysj\capperController.sysj line: 56, column: 8
                              System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 57, column: 6
                              w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 58, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 59, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 60, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 60, column: 7
                                S26829=0;
                                if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                  S26829=1;
                                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                    if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                      System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                      w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                    }
                                    w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                      twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                      S26828=2;
                                      S27019=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                        S27019=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S27014=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                          S27014=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 84, column: 5
                                            S27762=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                      S26828=2;
                                      S27019=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                        S27019=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S27014=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                          S27014=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 84, column: 5
                                            S27762=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                    currsigs.addElement(screwOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                    S26829=1;
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                      }
                                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S26829=0;
                                if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                                  S26829=1;
                                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                    if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                      System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                      w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                    }
                                    w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                      twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                      S26828=2;
                                      S27019=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                        S27019=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S27014=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                          S27014=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 84, column: 5
                                            S27762=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                      S26828=2;
                                      S27019=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                        S27019=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S27014=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                          S27014=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 84, column: 5
                                            S27762=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                    currsigs.addElement(screwOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                                    S26829=1;
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                                      }
                                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                        S26828=2;
                                        S27019=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                          S27019=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S27014=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                            S27014=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 84, column: 5
                                              S27762=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S26829){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                        S26829=1;
                        if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                          if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                            System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                            w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                          }
                          w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                          t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                            twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                            S26828=2;
                            S27019=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              S27019=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S27014=0;
                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                S27014=1;
                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  ends[3]=2;
                                  ;//sysj\capperController.sysj line: 84, column: 5
                                  S27762=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                            S26828=2;
                            S27019=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              S27019=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S27014=0;
                              if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                S27014=1;
                                if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  ends[3]=2;
                                  ;//sysj\capperController.sysj line: 84, column: 5
                                  S27762=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                          currsigs.addElement(screwOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                          S26829=1;
                          if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                            if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                              System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                              w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                            }
                            w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                            t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                              twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                            currsigs.addElement(screwOn);
                            active[3]=1;
                            ends[3]=1;
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
                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                        if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                          System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                          w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                        }
                        w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                          twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                          S26828=2;
                          S27019=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            S27019=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S27014=0;
                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                              S27014=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 84, column: 5
                                S27762=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                          S26828=2;
                          S27019=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            S27019=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S27014=0;
                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                              S27014=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 84, column: 5
                                S27762=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                        currsigs.addElement(screwOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  switch(S27019){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S27014){
                          case 0 : 
                            if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                              S27014=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 84, column: 5
                                S27762=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 84, column: 5
                              S27762=1;
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
                      S27019=1;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S27762=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S27762=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S27762=1;
            S27762=0;
            if(reset.getprestatus()){//sysj\capperController.sysj line: 51, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S27762=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S26828=0;
              S26812=0;
              if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 52, column: 5
                start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                S26812=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S26807=0;
                if(!start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                  start_in.setACK(true);//sysj\capperController.sysj line: 52, column: 5
                  S26807=1;
                  if(start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
                    start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
                    ends[3]=2;
                    ;//sysj\capperController.sysj line: 52, column: 5
                    w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 53, column: 5
                    S26828=1;
                    if(w_thread_3 != null){//sysj\capperController.sysj line: 56, column: 8
                      System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 57, column: 6
                      w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 58, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 59, column: 6
                        twin.setPresent();//sysj\capperController.sysj line: 60, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 60, column: 7
                        S26829=0;
                        if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                          S26829=1;
                          if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                            if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                              System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                              w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                            }
                            w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                            t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                              twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                            currsigs.addElement(screwOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                            S26829=1;
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                              if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                              }
                              w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                S26828=2;
                                S27019=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  S27019=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S27014=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                    S27014=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 84, column: 5
                                      S27762=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                S26828=2;
                                S27019=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  S27019=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S27014=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                    S27014=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 84, column: 5
                                      S27762=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S26829=0;
                        if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                          S26829=1;
                          if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                            if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                              System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                              w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                            }
                            w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                            t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                              twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                              S26828=2;
                              S27019=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                S27019=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S27014=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                  S27014=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 84, column: 5
                                    S27762=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                            currsigs.addElement(screwOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                            S26829=1;
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                              if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                                System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                                w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                              }
                              w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                S26828=2;
                                S27019=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  S27019=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S27014=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                    S27014=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 84, column: 5
                                      S27762=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                                S26828=2;
                                S27019=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                  S27019=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S27014=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                                    S27014=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 84, column: 5
                                      S27762=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      S26828=2;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
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

  public void thread32555(int [] tdone, int [] ends){
        switch(S26804){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\capperController.sysj line: 36, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\capperController.sysj line: 39, column: 8
            auto_1.setPresent();//sysj\capperController.sysj line: 39, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\capperController.sysj line: 40, column: 13
              manual_1.setPresent();//sysj\capperController.sysj line: 40, column: 35
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

  public void thread32553(int [] tdone, int [] ends){
        S32548=1;
    t_thread_3 = new LidCapperTwin();//sysj\capperController.sysj line: 47, column: 3
    w_thread_3 = null;//sysj\capperController.sysj line: 48, column: 3
    S27762=0;
    if(reset.getprestatus()){//sysj\capperController.sysj line: 51, column: 20
      start_in.setPreempted();
      done_o.setPreempted();
      S27762=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S26828=0;
      S26812=0;
      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 52, column: 5
        start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
        S26812=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S26807=0;
        if(!start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
          start_in.setACK(true);//sysj\capperController.sysj line: 52, column: 5
          S26807=1;
          if(start_in.isREQ()){//sysj\capperController.sysj line: 52, column: 5
            start_in.setACK(false);//sysj\capperController.sysj line: 52, column: 5
            ends[3]=2;
            ;//sysj\capperController.sysj line: 52, column: 5
            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 53, column: 5
            S26828=1;
            if(w_thread_3 != null){//sysj\capperController.sysj line: 56, column: 8
              System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 57, column: 6
              w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 58, column: 6
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 59, column: 6
                twin.setPresent();//sysj\capperController.sysj line: 60, column: 7
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 60, column: 7
                S26829=0;
                if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                  S26829=1;
                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                    if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                      System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                      w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                    }
                    w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                      twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                      S26828=2;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                      S26828=2;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                    currsigs.addElement(screwOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                    S26829=1;
                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                      }
                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                        S26828=2;
                        S27019=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                          S27019=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S27014=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                            S27014=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 84, column: 5
                              S27762=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                        S26828=2;
                        S27019=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                          S27019=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S27014=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                            S27014=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 84, column: 5
                              S27762=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                      currsigs.addElement(screwOn);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                S26829=0;
                if(auto_1.getprestatus()){//sysj\capperController.sysj line: 63, column: 22
                  S26829=1;
                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                    if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                      System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                      w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                    }
                    w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                      twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                      S26828=2;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                      S26828=2;
                      S27019=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                        S27019=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S27014=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                          S27014=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 84, column: 5
                            S27762=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                    currsigs.addElement(screwOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 63, column: 45
                    S26829=1;
                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 64, column: 22
                      if(w_thread_3.catchFault("cap-loose")) {//sysj\capperController.sysj line: 71, column: 35
                        System.out.println("[CAP] Cap did not seat on " + w_thread_3 + ".");//sysj\capperController.sysj line: 72, column: 7
                        w_thread_3.reject(Machine.LID_CAPPER, "cap not seated");//sysj\capperController.sysj line: 73, column: 7
                      }
                      w_thread_3.cap();//sysj\capperController.sysj line: 75, column: 6
                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 76, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 77, column: 6
                        twin.setPresent();//sysj\capperController.sysj line: 78, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 78, column: 7
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                        S26828=2;
                        S27019=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                          S27019=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S27014=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                            S27014=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 84, column: 5
                              S27762=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 80, column: 6
                        S26828=2;
                        S27019=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                          S27019=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S27014=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                            S27014=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 84, column: 5
                              S27762=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      screwOn.setPresent();//sysj\capperController.sysj line: 65, column: 7
                      currsigs.addElement(screwOn);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
            }
            else {
              S26828=2;
              S27019=0;
              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 84, column: 5
                done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                S27019=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S27014=0;
                if(done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 84, column: 5
                  S27014=1;
                  if(!done_o.isACK()){//sysj\capperController.sysj line: 84, column: 5
                    done_o.setREQ(false);//sysj\capperController.sysj line: 84, column: 5
                    ends[3]=2;
                    ;//sysj\capperController.sysj line: 84, column: 5
                    S27762=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
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

  public void thread32552(int [] tdone, int [] ends){
        S26804=1;
    if(mode.getprestatus()){//sysj\capperController.sysj line: 36, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\capperController.sysj line: 39, column: 8
        auto_1.setPresent();//sysj\capperController.sysj line: 39, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\capperController.sysj line: 40, column: 13
          manual_1.setPresent();//sysj\capperController.sysj line: 40, column: 35
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
      switch(S32550){
        case 0 : 
          S32550=0;
          break RUN;
        
        case 1 : 
          S32550=2;
          S32550=2;
          auto_1.setClear();//sysj\capperController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\capperController.sysj line: 32, column: 2
          thread32552(tdone,ends);
          thread32553(tdone,ends);
          int biggest32554 = 0;
          if(ends[2]>=biggest32554){
            biggest32554=ends[2];
          }
          if(ends[3]>=biggest32554){
            biggest32554=ends[3];
          }
          if(biggest32554 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\capperController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\capperController.sysj line: 32, column: 2
          thread32555(tdone,ends);
          thread32556(tdone,ends);
          int biggest32557 = 0;
          if(ends[2]>=biggest32557){
            biggest32557=ends[2];
          }
          if(ends[3]>=biggest32557){
            biggest32557=ends[3];
          }
          if(biggest32557 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest32557 == 0){
            S32550=0;
            active[1]=0;
            ends[1]=0;
            S32550=0;
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
          capSeated.gethook();
          screwOnM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      capSeated.setpreclear();
      screwOnM.setpreclear();
      twin.setpreclear();
      screwOn.setpreclear();
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
      dummyint = capSeated.getStatus() ? capSeated.setprepresent() : capSeated.setpreclear();
      capSeated.setpreval(capSeated.getValue());
      capSeated.setClear();
      dummyint = screwOnM.getStatus() ? screwOnM.setprepresent() : screwOnM.setpreclear();
      screwOnM.setpreval(screwOnM.getValue());
      screwOnM.setClear();
      twin.sethook();
      twin.setClear();
      screwOn.sethook();
      screwOn.setClear();
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
        capSeated.gethook();
        screwOnM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
