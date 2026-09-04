import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BottleLoaderController extends ClockDomain{
  public BottleLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal bottleAtSource = new Signal("bottleAtSource", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal supplyEmpty = new Signal("supplyEmpty", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal release = new Signal("release", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public input_Channel loadOrder_in = new input_Channel();
  public output_Channel loadAck_o = new output_Channel();
  public output_Channel bottleHandoff_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private Workpiece w_thread_3;//sysj/bottleLoaderController.sysj line: 55, column: 3
  private boolean reported_thread_5;//sysj/bottleLoaderController.sysj line: 121, column: 3
  private int S4685 = 1;
  private int S12 = 1;
  private int S4382 = 1;
  private int S740 = 1;
  private int S36 = 1;
  private int S20 = 1;
  private int S15 = 1;
  private int S91 = 1;
  private int S86 = 1;
  private int S151 = 1;
  private int S146 = 1;
  private int S4669 = 1;
  private int S4477 = 1;
  private int S4683 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4695(int [] tdone, int [] ends){
        switch(S4683){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(supplyEmpty.getprestatus()){//sysj/bottleLoaderController.sysj line: 123, column: 12
          if(!reported_thread_5) {//sysj/bottleLoaderController.sysj line: 124, column: 18
            System.out.println("[BL] Bottle supply is empty.");//sysj/bottleLoaderController.sysj line: 125, column: 6
            reported_thread_5 = true;//sysj/bottleLoaderController.sysj line: 126, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          reported_thread_5 = false;//sysj/bottleLoaderController.sysj line: 130, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread4694(int [] tdone, int [] ends){
        switch(S4669){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4477){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 107, column: 20
              S4477=1;
              if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 108, column: 20
                S4477=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj/bottleLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                  if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 108, column: 20
              S4477=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(vacOnM.getprestatus()){//sysj/bottleLoaderController.sysj line: 110, column: 14
                vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 110, column: 23
                currsigs.addElement(vacOn);
                if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                  armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                    currsigs.addElement(armDest);
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
                  if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                    currsigs.addElement(armDest);
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
                if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                  armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                    currsigs.addElement(armDest);
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
                  if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                    currsigs.addElement(armDest);
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
            break;
          
          case 2 : 
            S4477=2;
            S4477=0;
            if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 107, column: 20
              S4477=1;
              if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 108, column: 20
                S4477=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj/bottleLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                  if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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
                    if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
                      currsigs.addElement(armDest);
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

  public void thread4693(int [] tdone, int [] ends){
        switch(S4382){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S740){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 58, column: 20
              S740=1;
              if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 60, column: 20
                loadOrder_in.setPreempted();
                bottleHandoff_o.setPreempted();
                loadAck_o.setPreempted();
                S740=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S36=0;
                S20=0;
                if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                  loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                  S20=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S15=0;
                  if(!loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                    loadOrder_in.setACK(true);//sysj/bottleLoaderController.sysj line: 62, column: 5
                    S15=1;
                    if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                      loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                      ends[3]=2;
                      ;//sysj/bottleLoaderController.sysj line: 62, column: 5
                      w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
                      System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
                      if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                        S36=1;
                        armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                        S36=1;
                        armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
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
            if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 60, column: 20
              loadOrder_in.setPreempted();
              bottleHandoff_o.setPreempted();
              loadAck_o.setPreempted();
              S740=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S36){
                case 0 : 
                  switch(S20){
                    case 0 : 
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                        loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                        S20=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S15){
                          case 0 : 
                            if(!loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                              loadOrder_in.setACK(true);//sysj/bottleLoaderController.sysj line: 62, column: 5
                              S15=1;
                              if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                                loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                                ends[3]=2;
                                ;//sysj/bottleLoaderController.sysj line: 62, column: 5
                                w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
                                System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
                                if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                                  S36=1;
                                  armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                                  S36=1;
                                  armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
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
                            if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                              loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                              ends[3]=2;
                              ;//sysj/bottleLoaderController.sysj line: 62, column: 5
                              w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
                              System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
                              if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                                S36=1;
                                armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                                currsigs.addElement(armSource);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                                S36=1;
                                armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                                currsigs.addElement(armSource);
                                active[3]=1;
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
                      S20=1;
                      S20=0;
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                        loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                        S20=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S15=0;
                        if(!loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                          loadOrder_in.setACK(true);//sysj/bottleLoaderController.sysj line: 62, column: 5
                          S15=1;
                          if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                            loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                            ends[3]=2;
                            ;//sysj/bottleLoaderController.sysj line: 62, column: 5
                            w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
                            System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
                            if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                              S36=1;
                              armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                              currsigs.addElement(armSource);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                              S36=1;
                              armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                              currsigs.addElement(armSource);
                              active[3]=1;
                              ends[3]=1;
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
                  if(armAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 74, column: 11
                    S36=2;
                    vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 80, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                    currsigs.addElement(armSource);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 79, column: 11
                    System.out.println("[BL] " + w_thread_3 + " gripped.");//sysj/bottleLoaderController.sysj line: 82, column: 5
                    S36=3;
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 86, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 80, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(armAtDest.getprestatus()){//sysj/bottleLoaderController.sysj line: 85, column: 11
                    System.out.println("[BL] Offering " + w_thread_3 + " to the conveyor.");//sysj/bottleLoaderController.sysj line: 90, column: 5
                    S36=4;
                    S91=0;
                    if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                      bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                      S91=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S86=0;
                      if(bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                        bottleHandoff_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 91, column: 5
                        S86=1;
                        if(!bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                          bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                          ends[3]=2;
                          ;//sysj/bottleLoaderController.sysj line: 91, column: 5
                          S36=5;
                          if(!WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 95, column: 21
                            S36=6;
                            S151=0;
                            if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                              loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                              S151=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S146=0;
                              if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                S146=1;
                                if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  ends[3]=2;
                                  ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  S740=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            release.setPresent();//sysj/bottleLoaderController.sysj line: 96, column: 6
                            currsigs.addElement(release);
                            active[3]=1;
                            ends[3]=1;
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
                  else {
                    armDest.setPresent();//sysj/bottleLoaderController.sysj line: 86, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  switch(S91){
                    case 0 : 
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                        bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                        S91=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S86){
                          case 0 : 
                            if(bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                              bottleHandoff_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 91, column: 5
                              S86=1;
                              if(!bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                                bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                                ends[3]=2;
                                ;//sysj/bottleLoaderController.sysj line: 91, column: 5
                                S36=5;
                                if(!WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 95, column: 21
                                  S36=6;
                                  S151=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    S151=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S146=0;
                                    if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                      S146=1;
                                      if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                        loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                        ends[3]=2;
                                        ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                                        S740=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  release.setPresent();//sysj/bottleLoaderController.sysj line: 96, column: 6
                                  currsigs.addElement(release);
                                  active[3]=1;
                                  ends[3]=1;
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
                            if(!bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                              bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                              ends[3]=2;
                              ;//sysj/bottleLoaderController.sysj line: 91, column: 5
                              S36=5;
                              if(!WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 95, column: 21
                                S36=6;
                                S151=0;
                                if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  S151=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S146=0;
                                  if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    S146=1;
                                    if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                      loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                      ends[3]=2;
                                      ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                                      S740=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                release.setPresent();//sysj/bottleLoaderController.sysj line: 96, column: 6
                                currsigs.addElement(release);
                                active[3]=1;
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
                      S91=1;
                      S91=0;
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                        bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                        S91=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86=0;
                        if(bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                          bottleHandoff_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 91, column: 5
                          S86=1;
                          if(!bottleHandoff_o.isACK()){//sysj/bottleLoaderController.sysj line: 91, column: 5
                            bottleHandoff_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 91, column: 5
                            ends[3]=2;
                            ;//sysj/bottleLoaderController.sysj line: 91, column: 5
                            S36=5;
                            if(!WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 95, column: 21
                              S36=6;
                              S151=0;
                              if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                S151=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S146=0;
                                if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                  S146=1;
                                  if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    ends[3]=2;
                                    ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                                    S740=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              release.setPresent();//sysj/bottleLoaderController.sysj line: 96, column: 6
                              currsigs.addElement(release);
                              active[3]=1;
                              ends[3]=1;
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
                
                case 5 : 
                  if(!WPgripped.getprestatus()){//sysj/bottleLoaderController.sysj line: 95, column: 21
                    S36=6;
                    S151=0;
                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                      loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                      S151=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S146=0;
                      if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                        loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                        S146=1;
                        if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                          loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                          ends[3]=2;
                          ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                          S740=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    release.setPresent();//sysj/bottleLoaderController.sysj line: 96, column: 6
                    currsigs.addElement(release);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  switch(S151){
                    case 0 : 
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                        loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                        S151=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S146){
                          case 0 : 
                            if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                              loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                              S146=1;
                              if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                                loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                                ends[3]=2;
                                ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                                S740=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                              loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                              ends[3]=2;
                              ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                              S740=2;
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
                      S151=1;
                      S151=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                        loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                        S151=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S146=0;
                        if(loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj/bottleLoaderController.sysj line: 99, column: 5
                          S146=1;
                          if(!loadAck_o.isACK()){//sysj/bottleLoaderController.sysj line: 99, column: 5
                            loadAck_o.setREQ(false);//sysj/bottleLoaderController.sysj line: 99, column: 5
                            ends[3]=2;
                            ;//sysj/bottleLoaderController.sysj line: 99, column: 5
                            S740=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                
                case 7 : 
                  S740=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S740=2;
            S740=0;
            if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 58, column: 20
              S740=1;
              if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 60, column: 20
                loadOrder_in.setPreempted();
                bottleHandoff_o.setPreempted();
                loadAck_o.setPreempted();
                S740=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S36=0;
                S20=0;
                if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                  loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                  S20=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S15=0;
                  if(!loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                    loadOrder_in.setACK(true);//sysj/bottleLoaderController.sysj line: 62, column: 5
                    S15=1;
                    if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
                      loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
                      ends[3]=2;
                      ;//sysj/bottleLoaderController.sysj line: 62, column: 5
                      w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
                      System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
                      if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                        S36=1;
                        armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                        S36=1;
                        armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
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

  public void thread4692(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/bottleLoaderController.sysj line: 42, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/bottleLoaderController.sysj line: 43, column: 8
            auto_1.setPresent();//sysj/bottleLoaderController.sysj line: 44, column: 6
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/bottleLoaderController.sysj line: 47, column: 6
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

  public void thread4690(int [] tdone, int [] ends){
        S4683=1;
    reported_thread_5 = false;//sysj/bottleLoaderController.sysj line: 121, column: 3
    if(supplyEmpty.getprestatus()){//sysj/bottleLoaderController.sysj line: 123, column: 12
      if(!reported_thread_5) {//sysj/bottleLoaderController.sysj line: 124, column: 18
        System.out.println("[BL] Bottle supply is empty.");//sysj/bottleLoaderController.sysj line: 125, column: 6
        reported_thread_5 = true;//sysj/bottleLoaderController.sysj line: 126, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      reported_thread_5 = false;//sysj/bottleLoaderController.sysj line: 130, column: 5
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread4689(int [] tdone, int [] ends){
        S4669=1;
    S4477=0;
    if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 107, column: 20
      S4477=1;
      if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 108, column: 20
        S4477=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(vacOnM.getprestatus()){//sysj/bottleLoaderController.sysj line: 110, column: 14
          vacOn.setPresent();//sysj/bottleLoaderController.sysj line: 110, column: 23
          currsigs.addElement(vacOn);
          if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
            armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
              armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
              currsigs.addElement(armDest);
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
            if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
              armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
              currsigs.addElement(armDest);
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
          if(armSourceM.getprestatus()){//sysj/bottleLoaderController.sysj line: 111, column: 14
            armSource.setPresent();//sysj/bottleLoaderController.sysj line: 111, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
              armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
              currsigs.addElement(armDest);
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
            if(armDestM.getprestatus()){//sysj/bottleLoaderController.sysj line: 112, column: 14
              armDest.setPresent();//sysj/bottleLoaderController.sysj line: 112, column: 25
              currsigs.addElement(armDest);
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
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread4688(int [] tdone, int [] ends){
        S4382=1;
    w_thread_3 = null;//sysj/bottleLoaderController.sysj line: 55, column: 3
    S740=0;
    if(auto_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 58, column: 20
      S740=1;
      if(manual_1.getprestatus()){//sysj/bottleLoaderController.sysj line: 60, column: 20
        loadOrder_in.setPreempted();
        bottleHandoff_o.setPreempted();
        loadAck_o.setPreempted();
        S740=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S36=0;
        S20=0;
        if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj/bottleLoaderController.sysj line: 62, column: 5
          loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
          S20=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S15=0;
          if(!loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
            loadOrder_in.setACK(true);//sysj/bottleLoaderController.sysj line: 62, column: 5
            S15=1;
            if(loadOrder_in.isREQ()){//sysj/bottleLoaderController.sysj line: 62, column: 5
              loadOrder_in.setACK(false);//sysj/bottleLoaderController.sysj line: 62, column: 5
              ends[3]=2;
              ;//sysj/bottleLoaderController.sysj line: 62, column: 5
              w_thread_3 = (Workpiece)(loadOrder_in.getVal() == null ? null : ((Workpiece)loadOrder_in.getVal()));//sysj/bottleLoaderController.sysj line: 63, column: 5
              System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj/bottleLoaderController.sysj line: 64, column: 5
              if(bottleAtSource.getprestatus()){//sysj/bottleLoaderController.sysj line: 66, column: 13
                S36=1;
                armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                currsigs.addElement(armSource);
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                System.out.println("[BL] Warning: no bottle at source.");//sysj/bottleLoaderController.sysj line: 70, column: 6
                S36=1;
                armSource.setPresent();//sysj/bottleLoaderController.sysj line: 75, column: 6
                currsigs.addElement(armSource);
                active[3]=1;
                ends[3]=1;
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

  public void thread4687(int [] tdone, int [] ends){
        S12=1;
    if(mode.getprestatus()){//sysj/bottleLoaderController.sysj line: 42, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/bottleLoaderController.sysj line: 43, column: 8
        auto_1.setPresent();//sysj/bottleLoaderController.sysj line: 44, column: 6
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/bottleLoaderController.sysj line: 47, column: 6
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
      switch(S4685){
        case 0 : 
          S4685=0;
          break RUN;
        
        case 1 : 
          S4685=2;
          S4685=2;
          auto_1.setClear();//sysj/bottleLoaderController.sysj line: 38, column: 2
          manual_1.setClear();//sysj/bottleLoaderController.sysj line: 38, column: 2
          thread4687(tdone,ends);
          thread4688(tdone,ends);
          thread4689(tdone,ends);
          thread4690(tdone,ends);
          int biggest4691 = 0;
          if(ends[2]>=biggest4691){
            biggest4691=ends[2];
          }
          if(ends[3]>=biggest4691){
            biggest4691=ends[3];
          }
          if(ends[4]>=biggest4691){
            biggest4691=ends[4];
          }
          if(ends[5]>=biggest4691){
            biggest4691=ends[5];
          }
          if(biggest4691 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/bottleLoaderController.sysj line: 38, column: 2
          manual_1.setClear();//sysj/bottleLoaderController.sysj line: 38, column: 2
          thread4692(tdone,ends);
          thread4693(tdone,ends);
          thread4694(tdone,ends);
          thread4695(tdone,ends);
          int biggest4696 = 0;
          if(ends[2]>=biggest4696){
            biggest4696=ends[2];
          }
          if(ends[3]>=biggest4696){
            biggest4696=ends[3];
          }
          if(ends[4]>=biggest4696){
            biggest4696=ends[4];
          }
          if(ends[5]>=biggest4696){
            biggest4696=ends[5];
          }
          if(biggest4696 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4696 == 0){
            S4685=0;
            active[1]=0;
            ends[1]=0;
            S4685=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          loadOrder_in.gethook();
          loadAck_o.gethook();
          bottleHandoff_o.gethook();
          mode.gethook();
          bottleAtSource.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          supplyEmpty.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtSource.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      supplyEmpty.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      vacOn.setpreclear();
      release.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
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
      dummyint = bottleAtSource.getStatus() ? bottleAtSource.setprepresent() : bottleAtSource.setpreclear();
      bottleAtSource.setpreval(bottleAtSource.getValue());
      bottleAtSource.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = supplyEmpty.getStatus() ? supplyEmpty.setprepresent() : supplyEmpty.setpreclear();
      supplyEmpty.setpreval(supplyEmpty.getValue());
      supplyEmpty.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      vacOn.sethook();
      vacOn.setClear();
      release.sethook();
      release.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      auto_1.setClear();
      manual_1.setClear();
      loadOrder_in.sethook();
      loadAck_o.sethook();
      bottleHandoff_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        loadOrder_in.gethook();
        loadAck_o.gethook();
        bottleHandoff_o.gethook();
        mode.gethook();
        bottleAtSource.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        supplyEmpty.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
