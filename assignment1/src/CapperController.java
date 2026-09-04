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
  public Signal capSeated = new Signal("capSeated", Signal.INPUT);
  public Signal screwOnM = new Signal("screwOnM", Signal.INPUT);
  public Signal screwOn = new Signal("screwOn", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private Workpiece w_thread_3;//sysj/capperController.sysj line: 37, column: 3
  private int S9294 = 1;
  private int S4887 = 1;
  private int S9221 = 1;
  private int S5609 = 1;
  private int S4911 = 1;
  private int S4895 = 1;
  private int S4890 = 1;
  private int S4958 = 1;
  private int S4953 = 1;
  private int S9292 = 1;
  private int S9244 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread9302(int [] tdone, int [] ends){
        switch(S9292){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S9244){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/capperController.sysj line: 65, column: 20
              S9244=1;
              if(auto_1.getprestatus()){//sysj/capperController.sysj line: 66, column: 20
                S9244=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(screwOnM.getprestatus()){//sysj/capperController.sysj line: 68, column: 14
                  screwOn.setPresent();//sysj/capperController.sysj line: 68, column: 25
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
            if(auto_1.getprestatus()){//sysj/capperController.sysj line: 66, column: 20
              S9244=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(screwOnM.getprestatus()){//sysj/capperController.sysj line: 68, column: 14
                screwOn.setPresent();//sysj/capperController.sysj line: 68, column: 25
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
            S9244=2;
            S9244=0;
            if(manual_1.getprestatus()){//sysj/capperController.sysj line: 65, column: 20
              S9244=1;
              if(auto_1.getprestatus()){//sysj/capperController.sysj line: 66, column: 20
                S9244=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(screwOnM.getprestatus()){//sysj/capperController.sysj line: 68, column: 14
                  screwOn.setPresent();//sysj/capperController.sysj line: 68, column: 25
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

  public void thread9301(int [] tdone, int [] ends){
        switch(S9221){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S5609){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/capperController.sysj line: 40, column: 20
              S5609=1;
              if(manual_1.getprestatus()){//sysj/capperController.sysj line: 42, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S5609=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4911=0;
                S4895=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/capperController.sysj line: 43, column: 5
                  start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                  S4895=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S4890=0;
                  if(!start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                    start_in.setACK(true);//sysj/capperController.sysj line: 43, column: 5
                    S4890=1;
                    if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                      start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                      ends[3]=2;
                      ;//sysj/capperController.sysj line: 43, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
                      S4911=1;
                      if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                        System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                        if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                          w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                          S4911=2;
                          S4958=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                            done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                            S4958=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S4953=0;
                            if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                              S4953=1;
                              if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                ends[3]=2;
                                ;//sysj/capperController.sysj line: 57, column: 5
                                S5609=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                          currsigs.addElement(screwOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S4911=2;
                        S4958=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                          done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                          S4958=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S4953=0;
                          if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                            done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                            S4953=1;
                            if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                              ends[3]=2;
                              ;//sysj/capperController.sysj line: 57, column: 5
                              S5609=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj/capperController.sysj line: 42, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S5609=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S4911){
                case 0 : 
                  switch(S4895){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/capperController.sysj line: 43, column: 5
                        start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                        S4895=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4890){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                              start_in.setACK(true);//sysj/capperController.sysj line: 43, column: 5
                              S4890=1;
                              if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                                start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                                ends[3]=2;
                                ;//sysj/capperController.sysj line: 43, column: 5
                                w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
                                S4911=1;
                                if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                                  System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                                  if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                                    w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                                    System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                                    S4911=2;
                                    S4958=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                      done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                      S4958=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S4953=0;
                                      if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                        done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                        S4953=1;
                                        if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                          done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                          ends[3]=2;
                                          ;//sysj/capperController.sysj line: 57, column: 5
                                          S5609=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                                    currsigs.addElement(screwOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S4911=2;
                                  S4958=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                    done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                    S4958=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S4953=0;
                                    if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                      done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                      S4953=1;
                                      if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                        done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                        ends[3]=2;
                                        ;//sysj/capperController.sysj line: 57, column: 5
                                        S5609=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                              start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                              ends[3]=2;
                              ;//sysj/capperController.sysj line: 43, column: 5
                              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
                              S4911=1;
                              if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                                System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                                if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                                  w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                                  System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                                  S4911=2;
                                  S4958=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                    done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                    S4958=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S4953=0;
                                    if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                      done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                      S4953=1;
                                      if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                        done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                        ends[3]=2;
                                        ;//sysj/capperController.sysj line: 57, column: 5
                                        S5609=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                                  currsigs.addElement(screwOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S4911=2;
                                S4958=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                  done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                  S4958=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S4953=0;
                                  if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                    done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                    S4953=1;
                                    if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                      done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                      ends[3]=2;
                                      ;//sysj/capperController.sysj line: 57, column: 5
                                      S5609=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S4895=1;
                      S4895=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/capperController.sysj line: 43, column: 5
                        start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                        S4895=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4890=0;
                        if(!start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                          start_in.setACK(true);//sysj/capperController.sysj line: 43, column: 5
                          S4890=1;
                          if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                            start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                            ends[3]=2;
                            ;//sysj/capperController.sysj line: 43, column: 5
                            w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
                            S4911=1;
                            if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                              System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                              if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                                w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                                System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                                S4911=2;
                                S4958=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                  done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                  S4958=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S4953=0;
                                  if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                    done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                    S4953=1;
                                    if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                      done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                      ends[3]=2;
                                      ;//sysj/capperController.sysj line: 57, column: 5
                                      S5609=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                                currsigs.addElement(screwOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S4911=2;
                              S4958=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                                done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                S4958=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S4953=0;
                                if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                  done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                                  S4953=1;
                                  if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                    done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                    ends[3]=2;
                                    ;//sysj/capperController.sysj line: 57, column: 5
                                    S5609=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                    w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                    System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                    S4911=2;
                    S4958=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                      done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                      S4958=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S4953=0;
                      if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                        done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                        S4953=1;
                        if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                          done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                          ends[3]=2;
                          ;//sysj/capperController.sysj line: 57, column: 5
                          S5609=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                    currsigs.addElement(screwOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  switch(S4958){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                        done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                        S4958=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S4953){
                          case 0 : 
                            if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                              S4953=1;
                              if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                ends[3]=2;
                                ;//sysj/capperController.sysj line: 57, column: 5
                                S5609=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                              ends[3]=2;
                              ;//sysj/capperController.sysj line: 57, column: 5
                              S5609=2;
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
                      S4958=1;
                      S4958=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                        done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                        S4958=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S4953=0;
                        if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                          done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                          S4953=1;
                          if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                            done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                            ends[3]=2;
                            ;//sysj/capperController.sysj line: 57, column: 5
                            S5609=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S5609=2;
            S5609=0;
            if(auto_1.getprestatus()){//sysj/capperController.sysj line: 40, column: 20
              S5609=1;
              if(manual_1.getprestatus()){//sysj/capperController.sysj line: 42, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S5609=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4911=0;
                S4895=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/capperController.sysj line: 43, column: 5
                  start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                  S4895=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S4890=0;
                  if(!start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                    start_in.setACK(true);//sysj/capperController.sysj line: 43, column: 5
                    S4890=1;
                    if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
                      start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
                      ends[3]=2;
                      ;//sysj/capperController.sysj line: 43, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
                      S4911=1;
                      if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                        System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                        if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                          w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                          System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                          S4911=2;
                          S4958=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                            done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                            S4958=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S4953=0;
                            if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                              S4953=1;
                              if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                                done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                                ends[3]=2;
                                ;//sysj/capperController.sysj line: 57, column: 5
                                S5609=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                          currsigs.addElement(screwOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S4911=2;
                        S4958=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                          done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                          S4958=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S4953=0;
                          if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                            done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                            S4953=1;
                            if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                              done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                              ends[3]=2;
                              ;//sysj/capperController.sysj line: 57, column: 5
                              S5609=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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

  public void thread9300(int [] tdone, int [] ends){
        switch(S4887){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/capperController.sysj line: 28, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/capperController.sysj line: 29, column: 8
            auto_1.setPresent();//sysj/capperController.sysj line: 29, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/capperController.sysj line: 30, column: 12
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

  public void thread9298(int [] tdone, int [] ends){
        S9292=1;
    S9244=0;
    if(manual_1.getprestatus()){//sysj/capperController.sysj line: 65, column: 20
      S9244=1;
      if(auto_1.getprestatus()){//sysj/capperController.sysj line: 66, column: 20
        S9244=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(screwOnM.getprestatus()){//sysj/capperController.sysj line: 68, column: 14
          screwOn.setPresent();//sysj/capperController.sysj line: 68, column: 25
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

  public void thread9297(int [] tdone, int [] ends){
        S9221=1;
    w_thread_3 = null;//sysj/capperController.sysj line: 37, column: 3
    S5609=0;
    if(auto_1.getprestatus()){//sysj/capperController.sysj line: 40, column: 20
      S5609=1;
      if(manual_1.getprestatus()){//sysj/capperController.sysj line: 42, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S5609=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4911=0;
        S4895=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/capperController.sysj line: 43, column: 5
          start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
          S4895=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S4890=0;
          if(!start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
            start_in.setACK(true);//sysj/capperController.sysj line: 43, column: 5
            S4890=1;
            if(start_in.isREQ()){//sysj/capperController.sysj line: 43, column: 5
              start_in.setACK(false);//sysj/capperController.sysj line: 43, column: 5
              ends[3]=2;
              ;//sysj/capperController.sysj line: 43, column: 5
              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/capperController.sysj line: 44, column: 5
              S4911=1;
              if(w_thread_3 != null){//sysj/capperController.sysj line: 46, column: 8
                System.out.println("[CAP] Sealing " + w_thread_3 + ".");//sysj/capperController.sysj line: 47, column: 6
                if(capSeated.getprestatus()){//sysj/capperController.sysj line: 49, column: 22
                  w_thread_3.cap();//sysj/capperController.sysj line: 53, column: 6
                  System.out.println("[CAP] " + w_thread_3 + " sealed.");//sysj/capperController.sysj line: 54, column: 6
                  S4911=2;
                  S4958=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                    done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                    S4958=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S4953=0;
                    if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                      done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                      S4953=1;
                      if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                        done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                        ends[3]=2;
                        ;//sysj/capperController.sysj line: 57, column: 5
                        S5609=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  screwOn.setPresent();//sysj/capperController.sysj line: 50, column: 7
                  currsigs.addElement(screwOn);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S4911=2;
                S4958=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/capperController.sysj line: 57, column: 5
                  done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                  S4958=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S4953=0;
                  if(done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                    done_o.setVal(w_thread_3);//sysj/capperController.sysj line: 57, column: 5
                    S4953=1;
                    if(!done_o.isACK()){//sysj/capperController.sysj line: 57, column: 5
                      done_o.setREQ(false);//sysj/capperController.sysj line: 57, column: 5
                      ends[3]=2;
                      ;//sysj/capperController.sysj line: 57, column: 5
                      S5609=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread9296(int [] tdone, int [] ends){
        S4887=1;
    if(mode.getprestatus()){//sysj/capperController.sysj line: 28, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/capperController.sysj line: 29, column: 8
        auto_1.setPresent();//sysj/capperController.sysj line: 29, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/capperController.sysj line: 30, column: 12
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
      switch(S9294){
        case 0 : 
          S9294=0;
          break RUN;
        
        case 1 : 
          S9294=2;
          S9294=2;
          auto_1.setClear();//sysj/capperController.sysj line: 24, column: 2
          manual_1.setClear();//sysj/capperController.sysj line: 24, column: 2
          thread9296(tdone,ends);
          thread9297(tdone,ends);
          thread9298(tdone,ends);
          int biggest9299 = 0;
          if(ends[2]>=biggest9299){
            biggest9299=ends[2];
          }
          if(ends[3]>=biggest9299){
            biggest9299=ends[3];
          }
          if(ends[4]>=biggest9299){
            biggest9299=ends[4];
          }
          if(biggest9299 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/capperController.sysj line: 24, column: 2
          manual_1.setClear();//sysj/capperController.sysj line: 24, column: 2
          thread9300(tdone,ends);
          thread9301(tdone,ends);
          thread9302(tdone,ends);
          int biggest9303 = 0;
          if(ends[2]>=biggest9303){
            biggest9303=ends[2];
          }
          if(ends[3]>=biggest9303){
            biggest9303=ends[3];
          }
          if(ends[4]>=biggest9303){
            biggest9303=ends[4];
          }
          if(biggest9303 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest9303 == 0){
            S9294=0;
            active[1]=0;
            ends[1]=0;
            S9294=0;
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
          mode.gethook();
          capSeated.gethook();
          screwOnM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      capSeated.setpreclear();
      screwOnM.setpreclear();
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
      dummyint = capSeated.getStatus() ? capSeated.setprepresent() : capSeated.setpreclear();
      capSeated.setpreval(capSeated.getValue());
      capSeated.setClear();
      dummyint = screwOnM.getStatus() ? screwOnM.setprepresent() : screwOnM.setpreclear();
      screwOnM.setpreval(screwOnM.getValue());
      screwOnM.setClear();
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
