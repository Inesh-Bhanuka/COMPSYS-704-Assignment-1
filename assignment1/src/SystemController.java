import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SystemController extends ClockDomain{
  public SystemController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal modeBL = new Signal("modeBL", Signal.OUTPUT);
  public Signal modeF1 = new Signal("modeF1", Signal.OUTPUT);
  public Signal modeF2 = new Signal("modeF2", Signal.OUTPUT);
  public Signal modeLL = new Signal("modeLL", Signal.OUTPUT);
  public Signal modeCP = new Signal("modeCP", Signal.OUTPUT);
  public Signal enableBL = new Signal("enableBL", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  public Signal enableRT = new Signal("enableRT", Signal.OUTPUT);
  public Signal enableF1 = new Signal("enableF1", Signal.OUTPUT);
  public Signal enableF2 = new Signal("enableF2", Signal.OUTPUT);
  public Signal enableLL = new Signal("enableLL", Signal.OUTPUT);
  public Signal enableCP = new Signal("enableCP", Signal.OUTPUT);
  public input_Channel purchaseOrder_in = new input_Channel();
  public input_Channel loadAck_in = new input_Channel();
  public input_Channel bottleDone_in = new input_Channel();
  public output_Channel orderProgress_o = new output_Channel();
  public output_Channel loadOrder_o = new output_Channel();
  private Workpiece w_thread_4;//sysj/systemController.sysj line: 49, column: 3
  private Workpiece w_thread_6;//sysj/systemController.sysj line: 68, column: 3
  private int done_thread_6;//sysj/systemController.sysj line: 69, column: 3
  private int S72216 = 1;
  private int S70802 = 1;
  private int S70807 = 1;
  private int S71475 = 1;
  private int S70830 = 1;
  private int S70814 = 1;
  private int S70809 = 1;
  private int S70837 = 1;
  private int S70832 = 1;
  private int S71546 = 1;
  private int S71498 = 1;
  private int S71482 = 1;
  private int S71477 = 1;
  private int S72214 = 1;
  private int S71570 = 1;
  private int S71554 = 1;
  private int S71549 = 1;
  private int S71577 = 1;
  private int S71572 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread72228(int [] tdone, int [] ends){
        switch(S72214){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S71570){
          case 0 : 
            switch(S71554){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 71, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                  S71554=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S71549){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                        bottleDone_in.setACK(true);//sysj/systemController.sysj line: 71, column: 4
                        S71549=1;
                        if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                          bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                          ends[6]=2;
                          ;//sysj/systemController.sysj line: 71, column: 4
                          w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj/systemController.sysj line: 72, column: 4
                          done_thread_6 = done_thread_6 + 1;//sysj/systemController.sysj line: 73, column: 4
                          System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj/systemController.sysj line: 74, column: 4
                          S71570=1;
                          S71577=0;
                          if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                            orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                            S71577=1;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            S71572=0;
                            if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                              orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                              S71572=1;
                              if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                                orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                                ends[6]=2;
                                ;//sysj/systemController.sysj line: 75, column: 4
                                S71570=2;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                        bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                        ends[6]=2;
                        ;//sysj/systemController.sysj line: 71, column: 4
                        w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj/systemController.sysj line: 72, column: 4
                        done_thread_6 = done_thread_6 + 1;//sysj/systemController.sysj line: 73, column: 4
                        System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj/systemController.sysj line: 74, column: 4
                        S71570=1;
                        S71577=0;
                        if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                          orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                          S71577=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S71572=0;
                          if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                            orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                            S71572=1;
                            if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                              orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                              ends[6]=2;
                              ;//sysj/systemController.sysj line: 75, column: 4
                              S71570=2;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S71554=1;
                S71554=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 71, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                  S71554=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S71549=0;
                  if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                    bottleDone_in.setACK(true);//sysj/systemController.sysj line: 71, column: 4
                    S71549=1;
                    if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                      bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                      ends[6]=2;
                      ;//sysj/systemController.sysj line: 71, column: 4
                      w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj/systemController.sysj line: 72, column: 4
                      done_thread_6 = done_thread_6 + 1;//sysj/systemController.sysj line: 73, column: 4
                      System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj/systemController.sysj line: 74, column: 4
                      S71570=1;
                      S71577=0;
                      if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                        orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                        S71577=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S71572=0;
                        if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                          orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                          S71572=1;
                          if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                            orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                            ends[6]=2;
                            ;//sysj/systemController.sysj line: 75, column: 4
                            S71570=2;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            switch(S71577){
              case 0 : 
                if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                  orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                  S71577=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S71572){
                    case 0 : 
                      if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                        orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                        S71572=1;
                        if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                          orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                          ends[6]=2;
                          ;//sysj/systemController.sysj line: 75, column: 4
                          S71570=2;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                        orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                        ends[6]=2;
                        ;//sysj/systemController.sysj line: 75, column: 4
                        S71570=2;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S71577=1;
                S71577=0;
                if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                  orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                  S71577=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S71572=0;
                  if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                    orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                    S71572=1;
                    if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                      orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                      ends[6]=2;
                      ;//sysj/systemController.sysj line: 75, column: 4
                      S71570=2;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            S71570=2;
            S71570=0;
            S71554=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 71, column: 4
              bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
              S71554=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S71549=0;
              if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                bottleDone_in.setACK(true);//sysj/systemController.sysj line: 71, column: 4
                S71549=1;
                if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
                  bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
                  ends[6]=2;
                  ;//sysj/systemController.sysj line: 71, column: 4
                  w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj/systemController.sysj line: 72, column: 4
                  done_thread_6 = done_thread_6 + 1;//sysj/systemController.sysj line: 73, column: 4
                  System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj/systemController.sysj line: 74, column: 4
                  S71570=1;
                  S71577=0;
                  if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
                    orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                    S71577=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S71572=0;
                    if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                      orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
                      S71572=1;
                      if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                        orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                        ends[6]=2;
                        ;//sysj/systemController.sysj line: 75, column: 4
                        S71570=2;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
                else {
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread72227(int [] tdone, int [] ends){
        switch(S71546){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S71498){
          case 0 : 
            switch(S71482){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 61, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                  S71482=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S71477){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                        loadAck_in.setACK(true);//sysj/systemController.sysj line: 61, column: 4
                        S71477=1;
                        if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                          loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                          ends[5]=2;
                          ;//sysj/systemController.sysj line: 61, column: 4
                          System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj/systemController.sysj line: 62, column: 4
                          S71498=1;
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                      }
                      else {
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                        loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                        ends[5]=2;
                        ;//sysj/systemController.sysj line: 61, column: 4
                        System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj/systemController.sysj line: 62, column: 4
                        S71498=1;
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S71482=1;
                S71482=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 61, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                  S71482=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S71477=0;
                  if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                    loadAck_in.setACK(true);//sysj/systemController.sysj line: 61, column: 4
                    S71477=1;
                    if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                      loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                      ends[5]=2;
                      ;//sysj/systemController.sysj line: 61, column: 4
                      System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj/systemController.sysj line: 62, column: 4
                      S71498=1;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            S71498=1;
            S71498=0;
            S71482=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 61, column: 4
              loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
              S71482=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S71477=0;
              if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                loadAck_in.setACK(true);//sysj/systemController.sysj line: 61, column: 4
                S71477=1;
                if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
                  loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
                  ends[5]=2;
                  ;//sysj/systemController.sysj line: 61, column: 4
                  System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj/systemController.sysj line: 62, column: 4
                  S71498=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread72226(int [] tdone, int [] ends){
        switch(S71475){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S70830){
          case 0 : 
            switch(S70814){
              case 0 : 
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj/systemController.sysj line: 51, column: 4
                  purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                  S70814=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S70809){
                    case 0 : 
                      if(!purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                        purchaseOrder_in.setACK(true);//sysj/systemController.sysj line: 51, column: 4
                        S70809=1;
                        if(purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                          purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                          ends[4]=2;
                          ;//sysj/systemController.sysj line: 51, column: 4
                          w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj/systemController.sysj line: 52, column: 4
                          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj/systemController.sysj line: 53, column: 4
                          S70830=1;
                          S70837=0;
                          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                            loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                            S70837=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S70832=0;
                            if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                              loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                              S70832=1;
                              if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                                loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                                ends[4]=2;
                                ;//sysj/systemController.sysj line: 54, column: 4
                                S70830=2;
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
                      if(purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                        purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                        ends[4]=2;
                        ;//sysj/systemController.sysj line: 51, column: 4
                        w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj/systemController.sysj line: 52, column: 4
                        System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj/systemController.sysj line: 53, column: 4
                        S70830=1;
                        S70837=0;
                        if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                          loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                          S70837=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S70832=0;
                          if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                            loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                            S70832=1;
                            if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                              loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                              ends[4]=2;
                              ;//sysj/systemController.sysj line: 54, column: 4
                              S70830=2;
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
                S70814=1;
                S70814=0;
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj/systemController.sysj line: 51, column: 4
                  purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                  S70814=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S70809=0;
                  if(!purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                    purchaseOrder_in.setACK(true);//sysj/systemController.sysj line: 51, column: 4
                    S70809=1;
                    if(purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                      purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                      ends[4]=2;
                      ;//sysj/systemController.sysj line: 51, column: 4
                      w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj/systemController.sysj line: 52, column: 4
                      System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj/systemController.sysj line: 53, column: 4
                      S70830=1;
                      S70837=0;
                      if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                        loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                        S70837=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S70832=0;
                        if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                          loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                          S70832=1;
                          if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                            loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                            ends[4]=2;
                            ;//sysj/systemController.sysj line: 54, column: 4
                            S70830=2;
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
            switch(S70837){
              case 0 : 
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                  loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                  S70837=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S70832){
                    case 0 : 
                      if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                        loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                        S70832=1;
                        if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                          loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                          ends[4]=2;
                          ;//sysj/systemController.sysj line: 54, column: 4
                          S70830=2;
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
                      if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                        loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                        ends[4]=2;
                        ;//sysj/systemController.sysj line: 54, column: 4
                        S70830=2;
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
                S70837=1;
                S70837=0;
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                  loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                  S70837=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S70832=0;
                  if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                    loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                    S70832=1;
                    if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                      loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                      ends[4]=2;
                      ;//sysj/systemController.sysj line: 54, column: 4
                      S70830=2;
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
          
          case 2 : 
            S70830=2;
            S70830=0;
            S70814=0;
            if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj/systemController.sysj line: 51, column: 4
              purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
              S70814=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S70809=0;
              if(!purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                purchaseOrder_in.setACK(true);//sysj/systemController.sysj line: 51, column: 4
                S70809=1;
                if(purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
                  purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
                  ends[4]=2;
                  ;//sysj/systemController.sysj line: 51, column: 4
                  w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj/systemController.sysj line: 52, column: 4
                  System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj/systemController.sysj line: 53, column: 4
                  S70830=1;
                  S70837=0;
                  if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
                    loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                    S70837=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S70832=0;
                    if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                      loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
                      S70832=1;
                      if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                        loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                        ends[4]=2;
                        ;//sysj/systemController.sysj line: 54, column: 4
                        S70830=2;
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

  public void thread72225(int [] tdone, int [] ends){
        switch(S70807){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj/systemController.sysj line: 42, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj/systemController.sysj line: 42, column: 19
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj/systemController.sysj line: 42, column: 34
        currsigs.addElement(enableRT);
        enableF1.setPresent();//sysj/systemController.sysj line: 43, column: 4
        currsigs.addElement(enableF1);
        enableF2.setPresent();//sysj/systemController.sysj line: 43, column: 19
        currsigs.addElement(enableF2);
        enableLL.setPresent();//sysj/systemController.sysj line: 43, column: 34
        currsigs.addElement(enableLL);
        enableCP.setPresent();//sysj/systemController.sysj line: 43, column: 49
        currsigs.addElement(enableCP);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread72224(int [] tdone, int [] ends){
        switch(S70802){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        modeBL.setPresent();//sysj/systemController.sysj line: 34, column: 4
        currsigs.addElement(modeBL);
        modeBL.setValue(0);//sysj/systemController.sysj line: 34, column: 4
        modeF1.setPresent();//sysj/systemController.sysj line: 34, column: 20
        currsigs.addElement(modeF1);
        modeF1.setValue(0);//sysj/systemController.sysj line: 34, column: 20
        modeF2.setPresent();//sysj/systemController.sysj line: 34, column: 36
        currsigs.addElement(modeF2);
        modeF2.setValue(0);//sysj/systemController.sysj line: 34, column: 36
        modeLL.setPresent();//sysj/systemController.sysj line: 35, column: 4
        currsigs.addElement(modeLL);
        modeLL.setValue(0);//sysj/systemController.sysj line: 35, column: 4
        modeCP.setPresent();//sysj/systemController.sysj line: 35, column: 20
        currsigs.addElement(modeCP);
        modeCP.setValue(0);//sysj/systemController.sysj line: 35, column: 20
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread72222(int [] tdone, int [] ends){
        S72214=1;
    w_thread_6 = null;//sysj/systemController.sysj line: 68, column: 3
    done_thread_6 = 0;//sysj/systemController.sysj line: 69, column: 3
    S71570=0;
    S71554=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj/systemController.sysj line: 71, column: 4
      bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
      S71554=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S71549=0;
      if(!bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
        bottleDone_in.setACK(true);//sysj/systemController.sysj line: 71, column: 4
        S71549=1;
        if(bottleDone_in.isREQ()){//sysj/systemController.sysj line: 71, column: 4
          bottleDone_in.setACK(false);//sysj/systemController.sysj line: 71, column: 4
          ends[6]=2;
          ;//sysj/systemController.sysj line: 71, column: 4
          w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj/systemController.sysj line: 72, column: 4
          done_thread_6 = done_thread_6 + 1;//sysj/systemController.sysj line: 73, column: 4
          System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj/systemController.sysj line: 74, column: 4
          S71570=1;
          S71577=0;
          if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj/systemController.sysj line: 75, column: 4
            orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
            S71577=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S71572=0;
            if(orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
              orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj/systemController.sysj line: 75, column: 4
              S71572=1;
              if(!orderProgress_o.isACK()){//sysj/systemController.sysj line: 75, column: 4
                orderProgress_o.setREQ(false);//sysj/systemController.sysj line: 75, column: 4
                ends[6]=2;
                ;//sysj/systemController.sysj line: 75, column: 4
                S71570=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
  }

  public void thread72221(int [] tdone, int [] ends){
        S71546=1;
    S71498=0;
    S71482=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj/systemController.sysj line: 61, column: 4
      loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
      S71482=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S71477=0;
      if(!loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
        loadAck_in.setACK(true);//sysj/systemController.sysj line: 61, column: 4
        S71477=1;
        if(loadAck_in.isREQ()){//sysj/systemController.sysj line: 61, column: 4
          loadAck_in.setACK(false);//sysj/systemController.sysj line: 61, column: 4
          ends[5]=2;
          ;//sysj/systemController.sysj line: 61, column: 4
          System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj/systemController.sysj line: 62, column: 4
          S71498=1;
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
    }
  }

  public void thread72220(int [] tdone, int [] ends){
        S71475=1;
    w_thread_4 = null;//sysj/systemController.sysj line: 49, column: 3
    S70830=0;
    S70814=0;
    if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj/systemController.sysj line: 51, column: 4
      purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
      S70814=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S70809=0;
      if(!purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
        purchaseOrder_in.setACK(true);//sysj/systemController.sysj line: 51, column: 4
        S70809=1;
        if(purchaseOrder_in.isREQ()){//sysj/systemController.sysj line: 51, column: 4
          purchaseOrder_in.setACK(false);//sysj/systemController.sysj line: 51, column: 4
          ends[4]=2;
          ;//sysj/systemController.sysj line: 51, column: 4
          w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj/systemController.sysj line: 52, column: 4
          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj/systemController.sysj line: 53, column: 4
          S70830=1;
          S70837=0;
          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj/systemController.sysj line: 54, column: 4
            loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
            S70837=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            S70832=0;
            if(loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
              loadOrder_o.setVal(w_thread_4);//sysj/systemController.sysj line: 54, column: 4
              S70832=1;
              if(!loadOrder_o.isACK()){//sysj/systemController.sysj line: 54, column: 4
                loadOrder_o.setREQ(false);//sysj/systemController.sysj line: 54, column: 4
                ends[4]=2;
                ;//sysj/systemController.sysj line: 54, column: 4
                S70830=2;
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

  public void thread72219(int [] tdone, int [] ends){
        S70807=1;
    enableBL.setPresent();//sysj/systemController.sysj line: 42, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj/systemController.sysj line: 42, column: 19
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj/systemController.sysj line: 42, column: 34
    currsigs.addElement(enableRT);
    enableF1.setPresent();//sysj/systemController.sysj line: 43, column: 4
    currsigs.addElement(enableF1);
    enableF2.setPresent();//sysj/systemController.sysj line: 43, column: 19
    currsigs.addElement(enableF2);
    enableLL.setPresent();//sysj/systemController.sysj line: 43, column: 34
    currsigs.addElement(enableLL);
    enableCP.setPresent();//sysj/systemController.sysj line: 43, column: 49
    currsigs.addElement(enableCP);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread72218(int [] tdone, int [] ends){
        S70802=1;
    modeBL.setPresent();//sysj/systemController.sysj line: 34, column: 4
    currsigs.addElement(modeBL);
    modeBL.setValue(0);//sysj/systemController.sysj line: 34, column: 4
    modeF1.setPresent();//sysj/systemController.sysj line: 34, column: 20
    currsigs.addElement(modeF1);
    modeF1.setValue(0);//sysj/systemController.sysj line: 34, column: 20
    modeF2.setPresent();//sysj/systemController.sysj line: 34, column: 36
    currsigs.addElement(modeF2);
    modeF2.setValue(0);//sysj/systemController.sysj line: 34, column: 36
    modeLL.setPresent();//sysj/systemController.sysj line: 35, column: 4
    currsigs.addElement(modeLL);
    modeLL.setValue(0);//sysj/systemController.sysj line: 35, column: 4
    modeCP.setPresent();//sysj/systemController.sysj line: 35, column: 20
    currsigs.addElement(modeCP);
    modeCP.setValue(0);//sysj/systemController.sysj line: 35, column: 20
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S72216){
        case 0 : 
          S72216=0;
          break RUN;
        
        case 1 : 
          S72216=2;
          S72216=2;
          thread72218(tdone,ends);
          thread72219(tdone,ends);
          thread72220(tdone,ends);
          thread72221(tdone,ends);
          thread72222(tdone,ends);
          int biggest72223 = 0;
          if(ends[2]>=biggest72223){
            biggest72223=ends[2];
          }
          if(ends[3]>=biggest72223){
            biggest72223=ends[3];
          }
          if(ends[4]>=biggest72223){
            biggest72223=ends[4];
          }
          if(ends[5]>=biggest72223){
            biggest72223=ends[5];
          }
          if(ends[6]>=biggest72223){
            biggest72223=ends[6];
          }
          if(biggest72223 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread72224(tdone,ends);
          thread72225(tdone,ends);
          thread72226(tdone,ends);
          thread72227(tdone,ends);
          thread72228(tdone,ends);
          int biggest72229 = 0;
          if(ends[2]>=biggest72229){
            biggest72229=ends[2];
          }
          if(ends[3]>=biggest72229){
            biggest72229=ends[3];
          }
          if(ends[4]>=biggest72229){
            biggest72229=ends[4];
          }
          if(ends[5]>=biggest72229){
            biggest72229=ends[5];
          }
          if(ends[6]>=biggest72229){
            biggest72229=ends[6];
          }
          if(biggest72229 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest72229 == 0){
            S72216=0;
            active[1]=0;
            ends[1]=0;
            S72216=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
          purchaseOrder_in.gethook();
          loadAck_in.gethook();
          bottleDone_in.gethook();
          orderProgress_o.gethook();
          loadOrder_o.gethook();
          df = true;
        }
        runClockDomain();
      }
      modeBL.setpreclear();
      modeF1.setpreclear();
      modeF2.setpreclear();
      modeLL.setpreclear();
      modeCP.setpreclear();
      enableBL.setpreclear();
      enableCV.setpreclear();
      enableRT.setpreclear();
      enableF1.setpreclear();
      enableF2.setpreclear();
      enableLL.setpreclear();
      enableCP.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      modeBL.sethook();
      modeBL.setClear();
      modeF1.sethook();
      modeF1.setClear();
      modeF2.sethook();
      modeF2.setClear();
      modeLL.sethook();
      modeLL.setClear();
      modeCP.sethook();
      modeCP.setClear();
      enableBL.sethook();
      enableBL.setClear();
      enableCV.sethook();
      enableCV.setClear();
      enableRT.sethook();
      enableRT.setClear();
      enableF1.sethook();
      enableF1.setClear();
      enableF2.sethook();
      enableF2.setClear();
      enableLL.sethook();
      enableLL.setClear();
      enableCP.sethook();
      enableCP.setClear();
      purchaseOrder_in.sethook();
      loadAck_in.sethook();
      bottleDone_in.sethook();
      orderProgress_o.sethook();
      loadOrder_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        purchaseOrder_in.gethook();
        loadAck_in.gethook();
        bottleDone_in.gethook();
        orderProgress_o.gethook();
        loadOrder_o.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
