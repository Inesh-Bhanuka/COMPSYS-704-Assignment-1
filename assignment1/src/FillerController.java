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
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal valveOpenM = new Signal("valveOpenM", Signal.INPUT);
  public Signal fillTarget = new Signal("fillTarget", Signal.OUTPUT);
  public Signal valveOpen = new Signal("valveOpen", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private Workpiece w_thread_3;//sysj/fillerController.sysj line: 40, column: 3
  private int ml_thread_3;//sysj/fillerController.sysj line: 41, column: 3
  private int S17915 = 1;
  private int S12248 = 1;
  private int S17842 = 1;
  private int S13181 = 1;
  private int S12273 = 1;
  private int S12257 = 1;
  private int S12252 = 1;
  private int S12324 = 1;
  private int S12319 = 1;
  private int S17913 = 1;
  private int S17865 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread17923(int [] tdone, int [] ends){
        switch(S17913){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S17865){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 78, column: 20
              S17865=1;
              if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 79, column: 20
                S17865=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(valveOpenM.getprestatus()){//sysj/fillerController.sysj line: 81, column: 14
                  valveOpen.setPresent();//sysj/fillerController.sysj line: 81, column: 27
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
            if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 79, column: 20
              S17865=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(valveOpenM.getprestatus()){//sysj/fillerController.sysj line: 81, column: 14
                valveOpen.setPresent();//sysj/fillerController.sysj line: 81, column: 27
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
            S17865=2;
            S17865=0;
            if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 78, column: 20
              S17865=1;
              if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 79, column: 20
                S17865=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(valveOpenM.getprestatus()){//sysj/fillerController.sysj line: 81, column: 14
                  valveOpen.setPresent();//sysj/fillerController.sysj line: 81, column: 27
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

  public void thread17922(int [] tdone, int [] ends){
        switch(S17842){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S13181){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 44, column: 20
              S13181=1;
              if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S13181=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S12273=0;
                S12257=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/fillerController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                  S12257=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S12252=0;
                  if(!start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj/fillerController.sysj line: 47, column: 5
                    S12252=1;
                    if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj/fillerController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
                      ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
                      S12273=1;
                      if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                        S12273=2;
                        S12324=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                          S12324=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S12319=0;
                          if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                            done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                            S12319=1;
                            if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj/fillerController.sysj line: 70, column: 5
                              S13181=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                          System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                          S12273=2;
                          S12324=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                            done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                            S12324=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S12319=0;
                            if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                              S12319=1;
                              if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj/fillerController.sysj line: 70, column: 5
                                S13181=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                          fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                          currsigs.addElement(fillTarget);
                          fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                          if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                            w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                            S12273=2;
                            S12324=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                              S12324=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S12319=0;
                              if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                S12319=1;
                                if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                  done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                  ends[3]=2;
                                  ;//sysj/fillerController.sysj line: 70, column: 5
                                  S13181=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                            currsigs.addElement(valveOpen);
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
            if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 46, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S13181=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S12273){
                case 0 : 
                  switch(S12257){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/fillerController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                        S12257=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S12252){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                              start_in.setACK(true);//sysj/fillerController.sysj line: 47, column: 5
                              S12252=1;
                              if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                                start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                                ends[3]=2;
                                ;//sysj/fillerController.sysj line: 47, column: 5
                                w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
                                ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
                                S12273=1;
                                if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                                  S12273=2;
                                  S12324=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                    S12324=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S12319=0;
                                    if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                      S12319=1;
                                      if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                        ends[3]=2;
                                        ;//sysj/fillerController.sysj line: 70, column: 5
                                        S13181=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                                    System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                                    S12273=2;
                                    S12324=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                      S12324=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S12319=0;
                                      if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                        S12319=1;
                                        if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                          ends[3]=2;
                                          ;//sysj/fillerController.sysj line: 70, column: 5
                                          S13181=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                                    fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                                    currsigs.addElement(fillTarget);
                                    fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                                    if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                                      w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                                      System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                                      S12273=2;
                                      S12324=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                        S12324=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S12319=0;
                                        if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                          done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                          S12319=1;
                                          if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                            done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                            ends[3]=2;
                                            ;//sysj/fillerController.sysj line: 70, column: 5
                                            S13181=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                                      currsigs.addElement(valveOpen);
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
                            if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                              start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                              ends[3]=2;
                              ;//sysj/fillerController.sysj line: 47, column: 5
                              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
                              ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
                              S12273=1;
                              if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                                S12273=2;
                                S12324=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                  done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                  S12324=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S12319=0;
                                  if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                    S12319=1;
                                    if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                      ends[3]=2;
                                      ;//sysj/fillerController.sysj line: 70, column: 5
                                      S13181=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                                  System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                                  S12273=2;
                                  S12324=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                    S12324=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S12319=0;
                                    if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                      S12319=1;
                                      if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                        ends[3]=2;
                                        ;//sysj/fillerController.sysj line: 70, column: 5
                                        S13181=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                                  fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                                  currsigs.addElement(fillTarget);
                                  fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                                  if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                                    w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                                    S12273=2;
                                    S12324=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                      S12324=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S12319=0;
                                      if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                        S12319=1;
                                        if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                          ends[3]=2;
                                          ;//sysj/fillerController.sysj line: 70, column: 5
                                          S13181=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                                    currsigs.addElement(valveOpen);
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
                      S12257=1;
                      S12257=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/fillerController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                        S12257=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S12252=0;
                        if(!start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                          start_in.setACK(true);//sysj/fillerController.sysj line: 47, column: 5
                          S12252=1;
                          if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                            start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                            ends[3]=2;
                            ;//sysj/fillerController.sysj line: 47, column: 5
                            w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
                            ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
                            S12273=1;
                            if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                              S12273=2;
                              S12324=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                S12324=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S12319=0;
                                if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                  done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                  S12319=1;
                                  if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                    ends[3]=2;
                                    ;//sysj/fillerController.sysj line: 70, column: 5
                                    S13181=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                                System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                                S12273=2;
                                S12324=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                  done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                  S12324=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S12319=0;
                                  if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                    S12319=1;
                                    if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                      ends[3]=2;
                                      ;//sysj/fillerController.sysj line: 70, column: 5
                                      S13181=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                                fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                                currsigs.addElement(fillTarget);
                                fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                                if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                                  w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                                  System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                                  S12273=2;
                                  S12324=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                                    done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                    S12324=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S12319=0;
                                    if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                      done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                      S12319=1;
                                      if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                        ends[3]=2;
                                        ;//sysj/fillerController.sysj line: 70, column: 5
                                        S13181=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                                  currsigs.addElement(valveOpen);
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
                  if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                    w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                    S12273=2;
                    S12324=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                      S12324=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S12319=0;
                      if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                        done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                        S12319=1;
                        if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                          ends[3]=2;
                          ;//sysj/fillerController.sysj line: 70, column: 5
                          S13181=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                    currsigs.addElement(valveOpen);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  switch(S12324){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                        S12324=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S12319){
                          case 0 : 
                            if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                              S12319=1;
                              if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj/fillerController.sysj line: 70, column: 5
                                S13181=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj/fillerController.sysj line: 70, column: 5
                              S13181=2;
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
                      S12324=1;
                      S12324=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                        S12324=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S12319=0;
                        if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                          done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                          S12319=1;
                          if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                            done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                            ends[3]=2;
                            ;//sysj/fillerController.sysj line: 70, column: 5
                            S13181=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S13181=2;
            S13181=0;
            if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 44, column: 20
              S13181=1;
              if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S13181=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S12273=0;
                S12257=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/fillerController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                  S12257=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S12252=0;
                  if(!start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj/fillerController.sysj line: 47, column: 5
                    S12252=1;
                    if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj/fillerController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
                      ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
                      S12273=1;
                      if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                        S12273=2;
                        S12324=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                          S12324=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S12319=0;
                          if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                            done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                            S12319=1;
                            if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj/fillerController.sysj line: 70, column: 5
                              S13181=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                          System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                          S12273=2;
                          S12324=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                            done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                            S12324=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S12319=0;
                            if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                              S12319=1;
                              if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj/fillerController.sysj line: 70, column: 5
                                S13181=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                          fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                          currsigs.addElement(fillTarget);
                          fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                          if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                            w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                            System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                            S12273=2;
                            S12324=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                              done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                              S12324=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S12319=0;
                              if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                                S12319=1;
                                if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                                  done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                                  ends[3]=2;
                                  ;//sysj/fillerController.sysj line: 70, column: 5
                                  S13181=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                            currsigs.addElement(valveOpen);
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

  public void thread17921(int [] tdone, int [] ends){
        switch(S12248){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/fillerController.sysj line: 31, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/fillerController.sysj line: 32, column: 8
            auto_1.setPresent();//sysj/fillerController.sysj line: 32, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/fillerController.sysj line: 33, column: 12
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

  public void thread17919(int [] tdone, int [] ends){
        S17913=1;
    S17865=0;
    if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 78, column: 20
      S17865=1;
      if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 79, column: 20
        S17865=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(valveOpenM.getprestatus()){//sysj/fillerController.sysj line: 81, column: 14
          valveOpen.setPresent();//sysj/fillerController.sysj line: 81, column: 27
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

  public void thread17918(int [] tdone, int [] ends){
        S17842=1;
    w_thread_3 = null;//sysj/fillerController.sysj line: 40, column: 3
    ml_thread_3 = 0;//sysj/fillerController.sysj line: 41, column: 3
    S13181=0;
    if(auto_1.getprestatus()){//sysj/fillerController.sysj line: 44, column: 20
      S13181=1;
      if(manual_1.getprestatus()){//sysj/fillerController.sysj line: 46, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S13181=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S12273=0;
        S12257=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/fillerController.sysj line: 47, column: 5
          start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
          S12257=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S12252=0;
          if(!start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
            start_in.setACK(true);//sysj/fillerController.sysj line: 47, column: 5
            S12252=1;
            if(start_in.isREQ()){//sysj/fillerController.sysj line: 47, column: 5
              start_in.setACK(false);//sysj/fillerController.sysj line: 47, column: 5
              ends[3]=2;
              ;//sysj/fillerController.sysj line: 47, column: 5
              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/fillerController.sysj line: 48, column: 5
              ml_thread_3 = (w_thread_3 == null) ? 0 : w_thread_3.nextVolumeMl();//sysj/fillerController.sysj line: 49, column: 5
              S12273=1;
              if(ml_thread_3 == 0){//sysj/fillerController.sysj line: 51, column: 8
                S12273=2;
                S12324=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                  done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                  S12324=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S12319=0;
                  if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                    done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                    S12319=1;
                    if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                      ends[3]=2;
                      ;//sysj/fillerController.sysj line: 70, column: 5
                      S13181=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                if(!w_thread_3.fits(ml_thread_3)){//sysj/fillerController.sysj line: 54, column: 13
                  System.out.println("[FILL] Refusing " + ml_thread_3 + "ml into " + w_thread_3 + " - would overflow.");//sysj/fillerController.sysj line: 56, column: 6
                  S12273=2;
                  S12324=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                    done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                    S12324=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S12319=0;
                    if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                      done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                      S12319=1;
                      if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                        done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                        ends[3]=2;
                        ;//sysj/fillerController.sysj line: 70, column: 5
                        S13181=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  System.out.println("[FILL] Liquid " + w_thread_3.nextLiquidName() + ", " + ml_thread_3 + "ml into " + w_thread_3 + ".");//sysj/fillerController.sysj line: 59, column: 6
                  fillTarget.setPresent();//sysj/fillerController.sysj line: 60, column: 6
                  currsigs.addElement(fillTarget);
                  fillTarget.setValue(ml_thread_3);//sysj/fillerController.sysj line: 60, column: 6
                  if(filled.getprestatus()){//sysj/fillerController.sysj line: 62, column: 22
                    w_thread_3.dispensed(ml_thread_3);//sysj/fillerController.sysj line: 66, column: 6
                    System.out.println("[FILL] " + w_thread_3 + " now at " + w_thread_3.filledMl() + "ml.");//sysj/fillerController.sysj line: 67, column: 6
                    S12273=2;
                    S12324=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/fillerController.sysj line: 70, column: 5
                      done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                      S12324=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S12319=0;
                      if(done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                        done_o.setVal(w_thread_3);//sysj/fillerController.sysj line: 70, column: 5
                        S12319=1;
                        if(!done_o.isACK()){//sysj/fillerController.sysj line: 70, column: 5
                          done_o.setREQ(false);//sysj/fillerController.sysj line: 70, column: 5
                          ends[3]=2;
                          ;//sysj/fillerController.sysj line: 70, column: 5
                          S13181=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    valveOpen.setPresent();//sysj/fillerController.sysj line: 63, column: 7
                    currsigs.addElement(valveOpen);
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

  public void thread17917(int [] tdone, int [] ends){
        S12248=1;
    if(mode.getprestatus()){//sysj/fillerController.sysj line: 31, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/fillerController.sysj line: 32, column: 8
        auto_1.setPresent();//sysj/fillerController.sysj line: 32, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/fillerController.sysj line: 33, column: 12
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
      switch(S17915){
        case 0 : 
          S17915=0;
          break RUN;
        
        case 1 : 
          S17915=2;
          S17915=2;
          auto_1.setClear();//sysj/fillerController.sysj line: 27, column: 2
          manual_1.setClear();//sysj/fillerController.sysj line: 27, column: 2
          thread17917(tdone,ends);
          thread17918(tdone,ends);
          thread17919(tdone,ends);
          int biggest17920 = 0;
          if(ends[2]>=biggest17920){
            biggest17920=ends[2];
          }
          if(ends[3]>=biggest17920){
            biggest17920=ends[3];
          }
          if(ends[4]>=biggest17920){
            biggest17920=ends[4];
          }
          if(biggest17920 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/fillerController.sysj line: 27, column: 2
          manual_1.setClear();//sysj/fillerController.sysj line: 27, column: 2
          thread17921(tdone,ends);
          thread17922(tdone,ends);
          thread17923(tdone,ends);
          int biggest17924 = 0;
          if(ends[2]>=biggest17924){
            biggest17924=ends[2];
          }
          if(ends[3]>=biggest17924){
            biggest17924=ends[3];
          }
          if(ends[4]>=biggest17924){
            biggest17924=ends[4];
          }
          if(biggest17924 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest17924 == 0){
            S17915=0;
            active[1]=0;
            ends[1]=0;
            S17915=0;
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
          filled.gethook();
          valveOpenM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      filled.setpreclear();
      valveOpenM.setpreclear();
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
      dummyint = filled.getStatus() ? filled.setprepresent() : filled.setpreclear();
      filled.setpreval(filled.getValue());
      filled.setClear();
      dummyint = valveOpenM.getStatus() ? valveOpenM.setprepresent() : valveOpenM.setpreclear();
      valveOpenM.setpreval(valveOpenM.getValue());
      valveOpenM.setClear();
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
