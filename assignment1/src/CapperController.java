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
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal capSeated = new Signal("capSeated", Signal.INPUT);
  public Signal screwOnM = new Signal("screwOnM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal screwOn = new Signal("screwOn", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LidCapperTwin t_thread_3;//sysj\capperController.sysj line: 41, column: 3
  private WorkpieceTwin w_thread_3;//sysj\capperController.sysj line: 42, column: 3
  private boolean permitted_thread_3;//sysj\capperController.sysj line: 51, column: 1
  private int S32314 = 1;
  private int S19735 = 1;
  private int S32241 = 1;
  private int S21820 = 1;
  private int S19760 = 1;
  private int S19744 = 1;
  private int S19739 = 1;
  private int S19761 = 1;
  private int S19931 = 1;
  private int S19926 = 1;
  private int S32312 = 1;
  private int S32264 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread32322(int [] tdone, int [] ends){
        switch(S32312){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S32264){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\capperController.sysj line: 88, column: 20
              S32264=1;
              if(auto_1.getprestatus()){//sysj\capperController.sysj line: 89, column: 20
                S32264=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 91, column: 14
                  screwOn.setPresent();//sysj\capperController.sysj line: 91, column: 25
                  currsigs.addElement(screwOn);
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
            if(auto_1.getprestatus()){//sysj\capperController.sysj line: 89, column: 20
              S32264=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 91, column: 14
                screwOn.setPresent();//sysj\capperController.sysj line: 91, column: 25
                currsigs.addElement(screwOn);
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
            S32264=2;
            S32264=0;
            if(manual_1.getprestatus()){//sysj\capperController.sysj line: 88, column: 20
              S32264=1;
              if(auto_1.getprestatus()){//sysj\capperController.sysj line: 89, column: 20
                S32264=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 91, column: 14
                  screwOn.setPresent();//sysj\capperController.sysj line: 91, column: 25
                  currsigs.addElement(screwOn);
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

  public void thread32321(int [] tdone, int [] ends){
        switch(S32241){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S21820){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\capperController.sysj line: 45, column: 20
              S21820=1;
              if(manual_1.getprestatus()){//sysj\capperController.sysj line: 47, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S21820=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S19760=0;
                S19744=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 48, column: 5
                  start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                  S19744=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S19739=0;
                  if(!start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                    start_in.setACK(true);//sysj\capperController.sysj line: 48, column: 5
                    S19739=1;
                    if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                      start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                      ends[3]=2;
                      ;//sysj\capperController.sysj line: 48, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
                      S19760=1;
                      if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                        permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                        S19761=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19760=2;
                        if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                          System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                          w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                            twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                              w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                              w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S19760=3;
                          S19931=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                            S19931=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S19926=0;
                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                              S19926=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 80, column: 5
                                S21820=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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
            if(manual_1.getprestatus()){//sysj\capperController.sysj line: 47, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S21820=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S19760){
                case 0 : 
                  switch(S19744){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 48, column: 5
                        start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                        S19744=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S19739){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                              start_in.setACK(true);//sysj\capperController.sysj line: 48, column: 5
                              S19739=1;
                              if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                                start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 48, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
                                S19760=1;
                                if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                                  permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                                  S19761=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19760=2;
                                  if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                                    System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                                    w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                                      twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                        w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                          S19760=3;
                                          S19931=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            S19931=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S19926=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                              S19926=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 80, column: 5
                                                S21820=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                          S19760=3;
                                          S19931=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            S19931=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S19926=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                              S19926=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 80, column: 5
                                                S21820=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                        w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                        t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                          twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                          S19760=3;
                                          S19931=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            S19931=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S19926=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                              S19926=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 80, column: 5
                                                S21820=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                          S19760=3;
                                          S19931=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            S19931=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S19926=0;
                                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                              S19926=1;
                                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                                ends[3]=2;
                                                ;//sysj\capperController.sysj line: 80, column: 5
                                                S21820=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                        currsigs.addElement(screwOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S19760=3;
                                    S19931=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      S19931=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S19926=0;
                                      if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                        S19926=1;
                                        if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                          ends[3]=2;
                                          ;//sysj\capperController.sysj line: 80, column: 5
                                          S21820=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                active[3]=1;
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
                            if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                              start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 48, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
                              S19760=1;
                              if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                                permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                                S19761=0;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S19760=2;
                                if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                                  System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                                  w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                                    twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                      w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                        S19760=3;
                                        S19931=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                          S19931=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S19926=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                            S19926=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 80, column: 5
                                              S21820=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                        S19760=3;
                                        S19931=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                          S19931=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S19926=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                            S19926=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 80, column: 5
                                              S21820=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                      w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                        twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                        S19760=3;
                                        S19931=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                          S19931=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S19926=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                            S19926=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 80, column: 5
                                              S21820=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                        S19760=3;
                                        S19931=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                          S19931=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S19926=0;
                                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                            S19926=1;
                                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                              ends[3]=2;
                                              ;//sysj\capperController.sysj line: 80, column: 5
                                              S21820=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                      currsigs.addElement(screwOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S19760=3;
                                  S19931=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                    S19931=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S19926=0;
                                    if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                      S19926=1;
                                      if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                        ends[3]=2;
                                        ;//sysj\capperController.sysj line: 80, column: 5
                                        S21820=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S19744=1;
                      S19744=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 48, column: 5
                        start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                        S19744=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19739=0;
                        if(!start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                          start_in.setACK(true);//sysj\capperController.sysj line: 48, column: 5
                          S19739=1;
                          if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                            start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 48, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
                            S19760=1;
                            if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                              permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                              S19761=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S19760=2;
                              if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                                System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                                w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                                  twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                    w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                      twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                      S19760=3;
                                      S19931=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                        S19931=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S19926=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                          S19926=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 80, column: 5
                                            S21820=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                      S19760=3;
                                      S19931=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                        S19931=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S19926=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                          S19926=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 80, column: 5
                                            S21820=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                    currsigs.addElement(screwOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                                    w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                      twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                      S19760=3;
                                      S19931=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                        S19931=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S19926=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                          S19926=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 80, column: 5
                                            S21820=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                      S19760=3;
                                      S19931=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                        S19931=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S19926=0;
                                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                          S19926=1;
                                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                            ends[3]=2;
                                            ;//sysj\capperController.sysj line: 80, column: 5
                                            S21820=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                                    currsigs.addElement(screwOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                            active[3]=1;
                            ends[3]=1;
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
                  switch(S19761){
                    case 0 : 
                      S19761=0;
                      S19761=1;
                      if(!permitted_thread_3){//sysj\capperController.sysj line: 53, column: 19
                        permitted_thread_3 = GuiStep.take("CAP", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\capperController.sysj line: 54, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\capperController.sysj line: 53, column: 13
                        S19761=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!permitted_thread_3){//sysj\capperController.sysj line: 53, column: 19
                        permitted_thread_3 = GuiStep.take("CAP", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\capperController.sysj line: 54, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\capperController.sysj line: 53, column: 13
                        S19761=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      S19761=2;
                      S19760=2;
                      if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                        System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                        w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                          twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                          if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                            w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                            t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                              twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                              S19760=3;
                              S19931=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                S19931=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S19926=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                  S19926=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 80, column: 5
                                    S21820=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                              S19760=3;
                              S19931=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                S19931=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S19926=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                  S19926=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 80, column: 5
                                    S21820=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                            currsigs.addElement(screwOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                            w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                            t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                              twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                              S19760=3;
                              S19931=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                S19931=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S19926=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                  S19926=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 80, column: 5
                                    S21820=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                              S19760=3;
                              S19931=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                S19931=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S19926=0;
                                if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                  S19926=1;
                                  if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                    ends[3]=2;
                                    ;//sysj\capperController.sysj line: 80, column: 5
                                    S21820=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                            currsigs.addElement(screwOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S19760=3;
                        S19931=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                          S19931=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S19926=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                            S19926=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                
                case 2 : 
                  if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                    w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                    t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                      twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                      S19760=3;
                      S19931=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                        S19931=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19926=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                          S19926=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 80, column: 5
                            S21820=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                      S19760=3;
                      S19931=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                        S19931=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19926=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                          S19926=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 80, column: 5
                            S21820=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                    currsigs.addElement(screwOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  switch(S19931){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                        S19931=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S19926){
                          case 0 : 
                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                              S19926=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 80, column: 5
                                S21820=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
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
                      S19931=1;
                      S19931=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                        S19931=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19926=0;
                        if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                          S19926=1;
                          if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                            ends[3]=2;
                            ;//sysj\capperController.sysj line: 80, column: 5
                            S21820=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S21820=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S21820=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S21820=2;
            S21820=0;
            if(auto_1.getprestatus()){//sysj\capperController.sysj line: 45, column: 20
              S21820=1;
              if(manual_1.getprestatus()){//sysj\capperController.sysj line: 47, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S21820=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S19760=0;
                S19744=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 48, column: 5
                  start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                  S19744=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S19739=0;
                  if(!start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                    start_in.setACK(true);//sysj\capperController.sysj line: 48, column: 5
                    S19739=1;
                    if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
                      start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
                      ends[3]=2;
                      ;//sysj\capperController.sysj line: 48, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
                      S19760=1;
                      if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                        permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                        S19761=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S19760=2;
                        if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                          System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                          w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                            twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                              w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                              w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                              t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                                twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                                S19760=3;
                                S19931=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                                  done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                  S19931=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S19926=0;
                                  if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                    done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                                    S19926=1;
                                    if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                      done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                      ends[3]=2;
                                      ;//sysj\capperController.sysj line: 80, column: 5
                                      S21820=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                              currsigs.addElement(screwOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S19760=3;
                          S19931=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                            S19931=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S19926=0;
                            if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                              S19926=1;
                              if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                                done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                                ends[3]=2;
                                ;//sysj\capperController.sysj line: 80, column: 5
                                S21820=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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

  public void thread32320(int [] tdone, int [] ends){
        switch(S19735){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\capperController.sysj line: 32, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\capperController.sysj line: 33, column: 8
            auto_1.setPresent();//sysj\capperController.sysj line: 33, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\capperController.sysj line: 34, column: 12
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

  public void thread32318(int [] tdone, int [] ends){
        S32312=1;
    S32264=0;
    if(manual_1.getprestatus()){//sysj\capperController.sysj line: 88, column: 20
      S32264=1;
      if(auto_1.getprestatus()){//sysj\capperController.sysj line: 89, column: 20
        S32264=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(screwOnM.getprestatus()){//sysj\capperController.sysj line: 91, column: 14
          screwOn.setPresent();//sysj\capperController.sysj line: 91, column: 25
          currsigs.addElement(screwOn);
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

  public void thread32317(int [] tdone, int [] ends){
        S32241=1;
    t_thread_3 = new LidCapperTwin();//sysj\capperController.sysj line: 41, column: 3
    w_thread_3 = null;//sysj\capperController.sysj line: 42, column: 3
    S21820=0;
    if(auto_1.getprestatus()){//sysj\capperController.sysj line: 45, column: 20
      S21820=1;
      if(manual_1.getprestatus()){//sysj\capperController.sysj line: 47, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S21820=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S19760=0;
        S19744=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\capperController.sysj line: 48, column: 5
          start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
          S19744=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S19739=0;
          if(!start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
            start_in.setACK(true);//sysj\capperController.sysj line: 48, column: 5
            S19739=1;
            if(start_in.isREQ()){//sysj\capperController.sysj line: 48, column: 5
              start_in.setACK(false);//sysj\capperController.sysj line: 48, column: 5
              ends[3]=2;
              ;//sysj\capperController.sysj line: 48, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\capperController.sysj line: 49, column: 5
              S19760=1;
              if(w_thread_3 != null){//sysj\capperController.sysj line: 50, column: 4
                permitted_thread_3 = false;//sysj\capperController.sysj line: 51, column: 1
                S19761=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S19760=2;
                if(w_thread_3 != null){//sysj\capperController.sysj line: 61, column: 8
                  System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj\capperController.sysj line: 62, column: 6
                  w_thread_3.started(Machine.LID_CAPPER, "screwing cap");//sysj\capperController.sysj line: 63, column: 6
                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "screwOn", "sealing " + w_thread_3.id)){//sysj\capperController.sysj line: 64, column: 6
                    twin.setPresent();//sysj\capperController.sysj line: 65, column: 7
                    currsigs.addElement(twin);
                    twin.setValue(t_thread_3);//sysj\capperController.sysj line: 65, column: 7
                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                      w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                        twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                        S19760=3;
                        S19931=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                          S19931=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S19926=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                            S19926=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                        S19760=3;
                        S19931=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                          S19931=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S19926=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                            S19926=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                      currsigs.addElement(screwOn);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(capSeated.getprestatus()){//sysj\capperController.sysj line: 68, column: 22
                      w_thread_3.cap();//sysj\capperController.sysj line: 72, column: 6
                      t_thread_3.setAppliedTurns(12);//sysj\capperController.sysj line: 73, column: 6
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "released", "sealed " + w_thread_3.id)){//sysj\capperController.sysj line: 74, column: 6
                        twin.setPresent();//sysj\capperController.sysj line: 75, column: 7
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\capperController.sysj line: 75, column: 7
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                        S19760=3;
                        S19931=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                          S19931=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S19926=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                            S19926=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj\capperController.sysj line: 77, column: 6
                        S19760=3;
                        S19931=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                          done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                          S19931=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S19926=0;
                          if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                            done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                            S19926=1;
                            if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                              done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                              ends[3]=2;
                              ;//sysj\capperController.sysj line: 80, column: 5
                              S21820=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      screwOn.setPresent();//sysj\capperController.sysj line: 69, column: 7
                      currsigs.addElement(screwOn);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  S19760=3;
                  S19931=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\capperController.sysj line: 80, column: 5
                    done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                    S19931=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S19926=0;
                    if(done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                      done_o.setVal(w_thread_3);//sysj\capperController.sysj line: 80, column: 5
                      S19926=1;
                      if(!done_o.isACK()){//sysj\capperController.sysj line: 80, column: 5
                        done_o.setREQ(false);//sysj\capperController.sysj line: 80, column: 5
                        ends[3]=2;
                        ;//sysj\capperController.sysj line: 80, column: 5
                        S21820=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
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
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
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

  public void thread32316(int [] tdone, int [] ends){
        S19735=1;
    if(mode.getprestatus()){//sysj\capperController.sysj line: 32, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\capperController.sysj line: 33, column: 8
        auto_1.setPresent();//sysj\capperController.sysj line: 33, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\capperController.sysj line: 34, column: 12
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
      switch(S32314){
        case 0 : 
          S32314=0;
          break RUN;
        
        case 1 : 
          S32314=2;
          S32314=2;
          auto_1.setClear();//sysj\capperController.sysj line: 28, column: 2
          manual_1.setClear();//sysj\capperController.sysj line: 28, column: 2
          thread32316(tdone,ends);
          thread32317(tdone,ends);
          thread32318(tdone,ends);
          int biggest32319 = 0;
          if(ends[2]>=biggest32319){
            biggest32319=ends[2];
          }
          if(ends[3]>=biggest32319){
            biggest32319=ends[3];
          }
          if(ends[4]>=biggest32319){
            biggest32319=ends[4];
          }
          if(biggest32319 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\capperController.sysj line: 28, column: 2
          manual_1.setClear();//sysj\capperController.sysj line: 28, column: 2
          thread32320(tdone,ends);
          thread32321(tdone,ends);
          thread32322(tdone,ends);
          int biggest32323 = 0;
          if(ends[2]>=biggest32323){
            biggest32323=ends[2];
          }
          if(ends[3]>=biggest32323){
            biggest32323=ends[3];
          }
          if(ends[4]>=biggest32323){
            biggest32323=ends[4];
          }
          if(biggest32323 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest32323 == 0){
            S32314=0;
            active[1]=0;
            ends[1]=0;
            S32314=0;
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
          capSeated.gethook();
          screwOnM.gethook();
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
      mode.setpreclear();
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
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
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
        operatorPermit.gethook();
        mode.gethook();
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
