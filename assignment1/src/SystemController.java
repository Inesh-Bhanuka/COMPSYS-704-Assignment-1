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
  public Signal recyclingStatus = new Signal("recyclingStatus", Signal.INPUT);
  public Signal modeBL = new Signal("modeBL", Signal.OUTPUT);
  public Signal modeF1 = new Signal("modeF1", Signal.OUTPUT);
  public Signal modeF2 = new Signal("modeF2", Signal.OUTPUT);
  public Signal modeLL = new Signal("modeLL", Signal.OUTPUT);
  public Signal modeCP = new Signal("modeCP", Signal.OUTPUT);
  public Signal modeSP = new Signal("modeSP", Signal.OUTPUT);
  public Signal modeRC = new Signal("modeRC", Signal.OUTPUT);
  public Signal modeLR = new Signal("modeLR", Signal.OUTPUT);
  public Signal modeLD = new Signal("modeLD", Signal.OUTPUT);
  public Signal modeBR = new Signal("modeBR", Signal.OUTPUT);
  public Signal enableBL = new Signal("enableBL", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  public Signal enableRT = new Signal("enableRT", Signal.OUTPUT);
  public Signal enableF1 = new Signal("enableF1", Signal.OUTPUT);
  public Signal enableF2 = new Signal("enableF2", Signal.OUTPUT);
  public Signal enableLL = new Signal("enableLL", Signal.OUTPUT);
  public Signal enableCP = new Signal("enableCP", Signal.OUTPUT);
  public Signal enableSP = new Signal("enableSP", Signal.OUTPUT);
  public Signal enableRC = new Signal("enableRC", Signal.OUTPUT);
  public Signal enableLR = new Signal("enableLR", Signal.OUTPUT);
  public Signal enableLD = new Signal("enableLD", Signal.OUTPUT);
  public Signal enableBR = new Signal("enableBR", Signal.OUTPUT);
  public input_Channel purchaseOrder_in = new input_Channel();
  public input_Channel loadAck_in = new input_Channel();
  public input_Channel bottleDone_in = new input_Channel();
  public input_Channel bottleRecycled_in = new input_Channel();
  public output_Channel orderProgress_o = new output_Channel();
  public output_Channel orderRejected_o = new output_Channel();
  public output_Channel loadOrder_o = new output_Channel();
  public output_Channel bottleRejected_o = new output_Channel();
  private Workpiece w_thread_4;//sysj\systemController.sysj line: 76, column: 3
  private Workpiece w_thread_6;//sysj\systemController.sysj line: 103, column: 3
  private int done_thread_6;//sysj\systemController.sysj line: 104, column: 3
  private Workpiece w_thread_7;//sysj\systemController.sysj line: 131, column: 3
  private int recovered_thread_7;//sysj\systemController.sysj line: 132, column: 3
  private int last_thread_8;//sysj\systemController.sysj line: 147, column: 3
  private int v_thread_8;//sysj\systemController.sysj line: 148, column: 3
  private int S175403 = 1;
  private int S170241 = 1;
  private int S170246 = 1;
  private int S170914 = 1;
  private int S170269 = 1;
  private int S170253 = 1;
  private int S170248 = 1;
  private int S170276 = 1;
  private int S170271 = 1;
  private int S170985 = 1;
  private int S170937 = 1;
  private int S170921 = 1;
  private int S170916 = 1;
  private int S174713 = 1;
  private int S171009 = 1;
  private int S170993 = 1;
  private int S170988 = 1;
  private int S171016 = 1;
  private int S171011 = 1;
  private int S171201 = 1;
  private int S171196 = 1;
  private int S175381 = 1;
  private int S174737 = 1;
  private int S174721 = 1;
  private int S174716 = 1;
  private int S174744 = 1;
  private int S174739 = 1;
  private int S175401 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread175419(int [] tdone, int [] ends){
        switch(S175401){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 150, column: 12
          v_thread_8 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 151, column: 5
          if(v_thread_8 != last_thread_8) {//sysj\systemController.sysj line: 152, column: 18
            if(v_thread_8 == 0) {//sysj\systemController.sysj line: 153, column: 16
              System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 153, column: 18
            }
            if(v_thread_8 == 1) {//sysj\systemController.sysj line: 154, column: 16
              System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 154, column: 18
            }
            if(v_thread_8 == 2) {//sysj\systemController.sysj line: 155, column: 16
              System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 155, column: 18
            }
            if(v_thread_8 == 3) {//sysj\systemController.sysj line: 156, column: 16
              System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 156, column: 18
            }
            last_thread_8 = v_thread_8;//sysj\systemController.sysj line: 157, column: 6
          }
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread175418(int [] tdone, int [] ends){
        switch(S175381){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S174737){
          case 0 : 
            switch(S174721){
              case 0 : 
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 134, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                  S174721=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S174716){
                    case 0 : 
                      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 134, column: 4
                        S174716=1;
                        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 134, column: 4
                          w_thread_7 = (Workpiece)(bottleRecycled_in.getVal() == null ? null : ((Workpiece)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 135, column: 4
                          recovered_thread_7 = recovered_thread_7 + 1;//sysj\systemController.sysj line: 136, column: 4
                          System.out.println("[SC] " + w_thread_7 + " recovered by the Recycling Station at " + w_thread_7.filledMl() + "ml, sealed=" + w_thread_7.isSealed() + ". " + recovered_thread_7 + " recycled.");//sysj\systemController.sysj line: 137, column: 4
                          S174737=1;
                          S174744=0;
                          if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                            S174744=1;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            S174739=0;
                            if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                              orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                              S174739=1;
                              if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                                orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                                ends[7]=2;
                                ;//sysj\systemController.sysj line: 139, column: 4
                                S174737=2;
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                        bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 134, column: 4
                        w_thread_7 = (Workpiece)(bottleRecycled_in.getVal() == null ? null : ((Workpiece)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 135, column: 4
                        recovered_thread_7 = recovered_thread_7 + 1;//sysj\systemController.sysj line: 136, column: 4
                        System.out.println("[SC] " + w_thread_7 + " recovered by the Recycling Station at " + w_thread_7.filledMl() + "ml, sealed=" + w_thread_7.isSealed() + ". " + recovered_thread_7 + " recycled.");//sysj\systemController.sysj line: 137, column: 4
                        S174737=1;
                        S174744=0;
                        if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                          orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                          S174744=1;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          S174739=0;
                          if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                            orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                            S174739=1;
                            if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                              orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 139, column: 4
                              S174737=2;
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S174721=1;
                S174721=0;
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 134, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                  S174721=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S174716=0;
                  if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                    bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 134, column: 4
                    S174716=1;
                    if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 134, column: 4
                      w_thread_7 = (Workpiece)(bottleRecycled_in.getVal() == null ? null : ((Workpiece)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 135, column: 4
                      recovered_thread_7 = recovered_thread_7 + 1;//sysj\systemController.sysj line: 136, column: 4
                      System.out.println("[SC] " + w_thread_7 + " recovered by the Recycling Station at " + w_thread_7.filledMl() + "ml, sealed=" + w_thread_7.isSealed() + ". " + recovered_thread_7 + " recycled.");//sysj\systemController.sysj line: 137, column: 4
                      S174737=1;
                      S174744=0;
                      if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                        S174744=1;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        S174739=0;
                        if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                          orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                          S174739=1;
                          if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                            ends[7]=2;
                            ;//sysj\systemController.sysj line: 139, column: 4
                            S174737=2;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            switch(S174744){
              case 0 : 
                if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                  orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                  S174744=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S174739){
                    case 0 : 
                      if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                        orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                        S174739=1;
                        if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                          orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 139, column: 4
                          S174737=2;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 139, column: 4
                        S174737=2;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S174744=1;
                S174744=0;
                if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                  orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                  S174744=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S174739=0;
                  if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                    orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                    S174739=1;
                    if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                      orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 139, column: 4
                      S174737=2;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            S174737=2;
            S174737=0;
            S174721=0;
            if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 134, column: 4
              bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
              S174721=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S174716=0;
              if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 134, column: 4
                S174716=1;
                if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 134, column: 4
                  w_thread_7 = (Workpiece)(bottleRecycled_in.getVal() == null ? null : ((Workpiece)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 135, column: 4
                  recovered_thread_7 = recovered_thread_7 + 1;//sysj\systemController.sysj line: 136, column: 4
                  System.out.println("[SC] " + w_thread_7 + " recovered by the Recycling Station at " + w_thread_7.filledMl() + "ml, sealed=" + w_thread_7.isSealed() + ". " + recovered_thread_7 + " recycled.");//sysj\systemController.sysj line: 137, column: 4
                  S174737=1;
                  S174744=0;
                  if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                    orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                    S174744=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S174739=0;
                    if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                      orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
                      S174739=1;
                      if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 139, column: 4
                        S174737=2;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread175417(int [] tdone, int [] ends){
        switch(S174713){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S171009){
          case 0 : 
            switch(S170993){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 106, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                  S170993=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S170988){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 106, column: 4
                        S170988=1;
                        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 106, column: 4
                          w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj\systemController.sysj line: 107, column: 4
                          S171009=1;
                          if(w_thread_6.isRejected()){//sysj\systemController.sysj line: 109, column: 4
                            System.out.println("[SC] " + w_thread_6 + " failed its quality check (" + w_thread_6.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 110, column: 5
                            S171016=0;
                            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                              S171016=1;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              S171011=0;
                              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                                bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                                S171011=1;
                                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                                  ends[6]=2;
                                  ;//sysj\systemController.sysj line: 112, column: 5
                                  S171009=2;
                                  if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                                    done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                                    System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                                    S171201=0;
                                    if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                      S171201=1;
                                      active[6]=1;
                                      ends[6]=1;
                                      tdone[6]=1;
                                    }
                                    else {
                                      S171196=0;
                                      if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                        orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                        S171196=1;
                                        if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                          ends[6]=2;
                                          ;//sysj\systemController.sysj line: 119, column: 5
                                          S171009=3;
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
                                    S171009=3;
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
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                          }
                          else {
                            S171009=2;
                            if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                              done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                              System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                              S171201=0;
                              if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                S171201=1;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                S171196=0;
                                if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                  orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                  S171196=1;
                                  if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                    orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                    ends[6]=2;
                                    ;//sysj\systemController.sysj line: 119, column: 5
                                    S171009=3;
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
                              S171009=3;
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
                      if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                        bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 106, column: 4
                        w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj\systemController.sysj line: 107, column: 4
                        S171009=1;
                        if(w_thread_6.isRejected()){//sysj\systemController.sysj line: 109, column: 4
                          System.out.println("[SC] " + w_thread_6 + " failed its quality check (" + w_thread_6.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 110, column: 5
                          S171016=0;
                          if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                            bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                            S171016=1;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            S171011=0;
                            if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                              bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                              S171011=1;
                              if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                                bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                                ends[6]=2;
                                ;//sysj\systemController.sysj line: 112, column: 5
                                S171009=2;
                                if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                                  done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                                  System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                                  S171201=0;
                                  if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                                    orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                    S171201=1;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    S171196=0;
                                    if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                      orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                      S171196=1;
                                      if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                        orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                        ends[6]=2;
                                        ;//sysj\systemController.sysj line: 119, column: 5
                                        S171009=3;
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
                                  S171009=3;
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
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                        }
                        else {
                          S171009=2;
                          if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                            done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                            System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                            S171201=0;
                            if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                              S171201=1;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              S171196=0;
                              if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                S171196=1;
                                if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                  ends[6]=2;
                                  ;//sysj\systemController.sysj line: 119, column: 5
                                  S171009=3;
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
                            S171009=3;
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
                S170993=1;
                S170993=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 106, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                  S170993=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S170988=0;
                  if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                    bottleDone_in.setACK(true);//sysj\systemController.sysj line: 106, column: 4
                    S170988=1;
                    if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 106, column: 4
                      w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj\systemController.sysj line: 107, column: 4
                      S171009=1;
                      if(w_thread_6.isRejected()){//sysj\systemController.sysj line: 109, column: 4
                        System.out.println("[SC] " + w_thread_6 + " failed its quality check (" + w_thread_6.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 110, column: 5
                        S171016=0;
                        if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                          S171016=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S171011=0;
                          if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                            bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                            S171011=1;
                            if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                              ends[6]=2;
                              ;//sysj\systemController.sysj line: 112, column: 5
                              S171009=2;
                              if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                                done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                                System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                                S171201=0;
                                if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                  S171201=1;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  S171196=0;
                                  if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                    orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                    S171196=1;
                                    if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                      ends[6]=2;
                                      ;//sysj\systemController.sysj line: 119, column: 5
                                      S171009=3;
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
                                S171009=3;
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
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        S171009=2;
                        if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                          done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                          System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                          S171201=0;
                          if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                            orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                            S171201=1;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            S171196=0;
                            if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                              S171196=1;
                              if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                ends[6]=2;
                                ;//sysj\systemController.sysj line: 119, column: 5
                                S171009=3;
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
                          S171009=3;
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
            switch(S171016){
              case 0 : 
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                  S171016=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S171011){
                    case 0 : 
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                        bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                        S171011=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 112, column: 5
                          S171009=2;
                          if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                            done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                            System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                            S171201=0;
                            if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                              S171201=1;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              S171196=0;
                              if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                S171196=1;
                                if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                  ends[6]=2;
                                  ;//sysj\systemController.sysj line: 119, column: 5
                                  S171009=3;
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
                            S171009=3;
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
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                        bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 112, column: 5
                        S171009=2;
                        if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                          done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                          System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                          S171201=0;
                          if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                            orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                            S171201=1;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            S171196=0;
                            if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                              S171196=1;
                              if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                ends[6]=2;
                                ;//sysj\systemController.sysj line: 119, column: 5
                                S171009=3;
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
                          S171009=3;
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
                    
                  }
                }
                break;
              
              case 1 : 
                S171016=1;
                S171016=0;
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                  S171016=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S171011=0;
                  if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                    bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                    S171011=1;
                    if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 112, column: 5
                      S171009=2;
                      if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                        done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                        System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                        S171201=0;
                        if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                          S171201=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S171196=0;
                          if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                            orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                            S171196=1;
                            if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                              ends[6]=2;
                              ;//sysj\systemController.sysj line: 119, column: 5
                              S171009=3;
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
                        S171009=3;
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
            switch(S171201){
              case 0 : 
                if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                  S171201=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S171196){
                    case 0 : 
                      if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                        orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                        S171196=1;
                        if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 119, column: 5
                          S171009=3;
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
                      if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                        orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 119, column: 5
                        S171009=3;
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
                S171201=1;
                S171201=0;
                if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                  S171201=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S171196=0;
                  if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                    orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                    S171196=1;
                    if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 119, column: 5
                      S171009=3;
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
          
          case 3 : 
            S171009=3;
            S171009=0;
            S170993=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 106, column: 4
              bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
              S170993=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S170988=0;
              if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                bottleDone_in.setACK(true);//sysj\systemController.sysj line: 106, column: 4
                S170988=1;
                if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
                  ends[6]=2;
                  ;//sysj\systemController.sysj line: 106, column: 4
                  w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj\systemController.sysj line: 107, column: 4
                  S171009=1;
                  if(w_thread_6.isRejected()){//sysj\systemController.sysj line: 109, column: 4
                    System.out.println("[SC] " + w_thread_6 + " failed its quality check (" + w_thread_6.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 110, column: 5
                    S171016=0;
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                      S171016=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S171011=0;
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                        bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                        S171011=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 112, column: 5
                          S171009=2;
                          if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                            done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                            System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                            S171201=0;
                            if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                              S171201=1;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              S171196=0;
                              if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                                S171196=1;
                                if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                                  ends[6]=2;
                                  ;//sysj\systemController.sysj line: 119, column: 5
                                  S171009=3;
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
                            S171009=3;
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
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    S171009=2;
                    if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                      done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                      System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                      S171201=0;
                      if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                        orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                        S171201=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S171196=0;
                        if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                          orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                          S171196=1;
                          if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                            orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                            ends[6]=2;
                            ;//sysj\systemController.sysj line: 119, column: 5
                            S171009=3;
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
                      S171009=3;
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

  public void thread175416(int [] tdone, int [] ends){
        switch(S170985){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S170937){
          case 0 : 
            switch(S170921){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 88, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                  S170921=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S170916){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                        loadAck_in.setACK(true);//sysj\systemController.sysj line: 88, column: 4
                        S170916=1;
                        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                          loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                          ends[5]=2;
                          ;//sysj\systemController.sysj line: 88, column: 4
                          System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 89, column: 4
                          S170937=1;
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
                      if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                        loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                        ends[5]=2;
                        ;//sysj\systemController.sysj line: 88, column: 4
                        System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 89, column: 4
                        S170937=1;
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
                S170921=1;
                S170921=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 88, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                  S170921=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S170916=0;
                  if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                    loadAck_in.setACK(true);//sysj\systemController.sysj line: 88, column: 4
                    S170916=1;
                    if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                      loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                      ends[5]=2;
                      ;//sysj\systemController.sysj line: 88, column: 4
                      System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 89, column: 4
                      S170937=1;
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
            S170937=1;
            S170937=0;
            S170921=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 88, column: 4
              loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
              S170921=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S170916=0;
              if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                loadAck_in.setACK(true);//sysj\systemController.sysj line: 88, column: 4
                S170916=1;
                if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
                  ends[5]=2;
                  ;//sysj\systemController.sysj line: 88, column: 4
                  System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 89, column: 4
                  S170937=1;
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

  public void thread175415(int [] tdone, int [] ends){
        switch(S170914){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S170269){
          case 0 : 
            switch(S170253){
              case 0 : 
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 78, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                  S170253=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S170248){
                    case 0 : 
                      if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                        purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 78, column: 4
                        S170248=1;
                        if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                          purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                          ends[4]=2;
                          ;//sysj\systemController.sysj line: 78, column: 4
                          w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 79, column: 4
                          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 80, column: 4
                          S170269=1;
                          S170276=0;
                          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                            S170276=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S170271=0;
                            if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                              loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                              S170271=1;
                              if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                                ends[4]=2;
                                ;//sysj\systemController.sysj line: 81, column: 4
                                S170269=2;
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
                      if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                        purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 78, column: 4
                        w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 79, column: 4
                        System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 80, column: 4
                        S170269=1;
                        S170276=0;
                        if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                          S170276=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S170271=0;
                          if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                            loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                            S170271=1;
                            if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                              loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                              ends[4]=2;
                              ;//sysj\systemController.sysj line: 81, column: 4
                              S170269=2;
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
                S170253=1;
                S170253=0;
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 78, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                  S170253=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S170248=0;
                  if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                    purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 78, column: 4
                    S170248=1;
                    if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                      purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                      ends[4]=2;
                      ;//sysj\systemController.sysj line: 78, column: 4
                      w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 79, column: 4
                      System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 80, column: 4
                      S170269=1;
                      S170276=0;
                      if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                        S170276=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S170271=0;
                        if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                          loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                          S170271=1;
                          if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                            ends[4]=2;
                            ;//sysj\systemController.sysj line: 81, column: 4
                            S170269=2;
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
            switch(S170276){
              case 0 : 
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                  S170276=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S170271){
                    case 0 : 
                      if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                        loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                        S170271=1;
                        if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                          ends[4]=2;
                          ;//sysj\systemController.sysj line: 81, column: 4
                          S170269=2;
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
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 81, column: 4
                        S170269=2;
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
                S170276=1;
                S170276=0;
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                  S170276=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S170271=0;
                  if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                    loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                    S170271=1;
                    if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                      loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                      ends[4]=2;
                      ;//sysj\systemController.sysj line: 81, column: 4
                      S170269=2;
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
            S170269=2;
            S170269=0;
            S170253=0;
            if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 78, column: 4
              purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
              S170253=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S170248=0;
              if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 78, column: 4
                S170248=1;
                if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 78, column: 4
                  w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 79, column: 4
                  System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 80, column: 4
                  S170269=1;
                  S170276=0;
                  if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
                    loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                    S170276=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S170271=0;
                    if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                      loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
                      S170271=1;
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 81, column: 4
                        S170269=2;
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

  public void thread175414(int [] tdone, int [] ends){
        switch(S170246){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj\systemController.sysj line: 67, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 67, column: 19
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 67, column: 34
        currsigs.addElement(enableRT);
        enableF1.setPresent();//sysj\systemController.sysj line: 68, column: 4
        currsigs.addElement(enableF1);
        enableF2.setPresent();//sysj\systemController.sysj line: 68, column: 19
        currsigs.addElement(enableF2);
        enableLL.setPresent();//sysj\systemController.sysj line: 68, column: 34
        currsigs.addElement(enableLL);
        enableCP.setPresent();//sysj\systemController.sysj line: 68, column: 49
        currsigs.addElement(enableCP);
        enableSP.setPresent();//sysj\systemController.sysj line: 69, column: 4
        currsigs.addElement(enableSP);
        enableRC.setPresent();//sysj\systemController.sysj line: 69, column: 19
        currsigs.addElement(enableRC);
        enableLR.setPresent();//sysj\systemController.sysj line: 69, column: 34
        currsigs.addElement(enableLR);
        enableLD.setPresent();//sysj\systemController.sysj line: 70, column: 4
        currsigs.addElement(enableLD);
        enableBR.setPresent();//sysj\systemController.sysj line: 70, column: 19
        currsigs.addElement(enableBR);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread175413(int [] tdone, int [] ends){
        switch(S170241){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        modeBL.setPresent();//sysj\systemController.sysj line: 57, column: 4
        currsigs.addElement(modeBL);
        modeBL.setValue(0);//sysj\systemController.sysj line: 57, column: 4
        modeF1.setPresent();//sysj\systemController.sysj line: 57, column: 20
        currsigs.addElement(modeF1);
        modeF1.setValue(0);//sysj\systemController.sysj line: 57, column: 20
        modeF2.setPresent();//sysj\systemController.sysj line: 57, column: 36
        currsigs.addElement(modeF2);
        modeF2.setValue(0);//sysj\systemController.sysj line: 57, column: 36
        modeLL.setPresent();//sysj\systemController.sysj line: 58, column: 4
        currsigs.addElement(modeLL);
        modeLL.setValue(0);//sysj\systemController.sysj line: 58, column: 4
        modeCP.setPresent();//sysj\systemController.sysj line: 58, column: 20
        currsigs.addElement(modeCP);
        modeCP.setValue(0);//sysj\systemController.sysj line: 58, column: 20
        modeSP.setPresent();//sysj\systemController.sysj line: 59, column: 4
        currsigs.addElement(modeSP);
        modeSP.setValue(0);//sysj\systemController.sysj line: 59, column: 4
        modeRC.setPresent();//sysj\systemController.sysj line: 59, column: 20
        currsigs.addElement(modeRC);
        modeRC.setValue(0);//sysj\systemController.sysj line: 59, column: 20
        modeLR.setPresent();//sysj\systemController.sysj line: 59, column: 36
        currsigs.addElement(modeLR);
        modeLR.setValue(0);//sysj\systemController.sysj line: 59, column: 36
        modeLD.setPresent();//sysj\systemController.sysj line: 60, column: 4
        currsigs.addElement(modeLD);
        modeLD.setValue(0);//sysj\systemController.sysj line: 60, column: 4
        modeBR.setPresent();//sysj\systemController.sysj line: 60, column: 20
        currsigs.addElement(modeBR);
        modeBR.setValue(0);//sysj\systemController.sysj line: 60, column: 20
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread175411(int [] tdone, int [] ends){
        S175401=1;
    last_thread_8 = -1;//sysj\systemController.sysj line: 147, column: 3
    v_thread_8 = 0;//sysj\systemController.sysj line: 148, column: 3
    if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 150, column: 12
      v_thread_8 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 151, column: 5
      if(v_thread_8 != last_thread_8) {//sysj\systemController.sysj line: 152, column: 18
        if(v_thread_8 == 0) {//sysj\systemController.sysj line: 153, column: 16
          System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 153, column: 18
        }
        if(v_thread_8 == 1) {//sysj\systemController.sysj line: 154, column: 16
          System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 154, column: 18
        }
        if(v_thread_8 == 2) {//sysj\systemController.sysj line: 155, column: 16
          System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 155, column: 18
        }
        if(v_thread_8 == 3) {//sysj\systemController.sysj line: 156, column: 16
          System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 156, column: 18
        }
        last_thread_8 = v_thread_8;//sysj\systemController.sysj line: 157, column: 6
      }
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread175410(int [] tdone, int [] ends){
        S175381=1;
    w_thread_7 = null;//sysj\systemController.sysj line: 131, column: 3
    recovered_thread_7 = 0;//sysj\systemController.sysj line: 132, column: 3
    S174737=0;
    S174721=0;
    if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 134, column: 4
      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
      S174721=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S174716=0;
      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 134, column: 4
        S174716=1;
        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 134, column: 4
          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 134, column: 4
          ends[7]=2;
          ;//sysj\systemController.sysj line: 134, column: 4
          w_thread_7 = (Workpiece)(bottleRecycled_in.getVal() == null ? null : ((Workpiece)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 135, column: 4
          recovered_thread_7 = recovered_thread_7 + 1;//sysj\systemController.sysj line: 136, column: 4
          System.out.println("[SC] " + w_thread_7 + " recovered by the Recycling Station at " + w_thread_7.filledMl() + "ml, sealed=" + w_thread_7.isSealed() + ". " + recovered_thread_7 + " recycled.");//sysj\systemController.sysj line: 137, column: 4
          S174737=1;
          S174744=0;
          if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
            S174744=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            S174739=0;
            if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
              orderRejected_o.setVal(new Integer(w_thread_7.id));//sysj\systemController.sysj line: 139, column: 4
              S174739=1;
              if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 139, column: 4
                orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 139, column: 4
                ends[7]=2;
                ;//sysj\systemController.sysj line: 139, column: 4
                S174737=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
      }
      else {
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
    }
  }

  public void thread175409(int [] tdone, int [] ends){
        S174713=1;
    w_thread_6 = null;//sysj\systemController.sysj line: 103, column: 3
    done_thread_6 = 0;//sysj\systemController.sysj line: 104, column: 3
    S171009=0;
    S170993=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 106, column: 4
      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
      S170993=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S170988=0;
      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 106, column: 4
        S170988=1;
        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 106, column: 4
          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 106, column: 4
          ends[6]=2;
          ;//sysj\systemController.sysj line: 106, column: 4
          w_thread_6 = (Workpiece)(bottleDone_in.getVal() == null ? null : ((Workpiece)bottleDone_in.getVal()));//sysj\systemController.sysj line: 107, column: 4
          S171009=1;
          if(w_thread_6.isRejected()){//sysj\systemController.sysj line: 109, column: 4
            System.out.println("[SC] " + w_thread_6 + " failed its quality check (" + w_thread_6.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 110, column: 5
            S171016=0;
            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 112, column: 5
              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
              S171016=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S171011=0;
              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                bottleRejected_o.setVal(w_thread_6);//sysj\systemController.sysj line: 112, column: 5
                S171011=1;
                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 112, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 112, column: 5
                  ends[6]=2;
                  ;//sysj\systemController.sysj line: 112, column: 5
                  S171009=2;
                  if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
                    done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
                    System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
                    S171201=0;
                    if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                      S171201=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S171196=0;
                      if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                        orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                        S171196=1;
                        if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 119, column: 5
                          S171009=3;
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
                    S171009=3;
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
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
          }
          else {
            S171009=2;
            if(!w_thread_6.isRejected()){//sysj\systemController.sysj line: 115, column: 7
              done_thread_6 = done_thread_6 + 1;//sysj\systemController.sysj line: 116, column: 5
              System.out.println("[SC] " + w_thread_6 + " finished at " + w_thread_6.filledMl() + "ml, sealed=" + w_thread_6.isSealed() + ". " + done_thread_6 + " complete.");//sysj\systemController.sysj line: 117, column: 5
              S171201=0;
              if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 5
                orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                S171201=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S171196=0;
                if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                  orderProgress_o.setVal(new Integer(w_thread_6.id));//sysj\systemController.sysj line: 119, column: 5
                  S171196=1;
                  if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 119, column: 5
                    orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 119, column: 5
                    ends[6]=2;
                    ;//sysj\systemController.sysj line: 119, column: 5
                    S171009=3;
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
              S171009=3;
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

  public void thread175408(int [] tdone, int [] ends){
        S170985=1;
    S170937=0;
    S170921=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 88, column: 4
      loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
      S170921=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S170916=0;
      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
        loadAck_in.setACK(true);//sysj\systemController.sysj line: 88, column: 4
        S170916=1;
        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 88, column: 4
          loadAck_in.setACK(false);//sysj\systemController.sysj line: 88, column: 4
          ends[5]=2;
          ;//sysj\systemController.sysj line: 88, column: 4
          System.out.println("[SC] " + (Workpiece)(loadAck_in.getVal() == null ? null : ((Workpiece)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 89, column: 4
          S170937=1;
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

  public void thread175407(int [] tdone, int [] ends){
        S170914=1;
    w_thread_4 = null;//sysj\systemController.sysj line: 76, column: 3
    S170269=0;
    S170253=0;
    if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 78, column: 4
      purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
      S170253=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S170248=0;
      if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
        purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 78, column: 4
        S170248=1;
        if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 78, column: 4
          purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 78, column: 4
          ends[4]=2;
          ;//sysj\systemController.sysj line: 78, column: 4
          w_thread_4 = (Workpiece)(purchaseOrder_in.getVal() == null ? null : ((Workpiece)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 79, column: 4
          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 80, column: 4
          S170269=1;
          S170276=0;
          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 81, column: 4
            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
            S170276=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            S170271=0;
            if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
              loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 81, column: 4
              S170271=1;
              if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 81, column: 4
                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 81, column: 4
                ends[4]=2;
                ;//sysj\systemController.sysj line: 81, column: 4
                S170269=2;
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

  public void thread175406(int [] tdone, int [] ends){
        S170246=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 67, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 67, column: 19
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 67, column: 34
    currsigs.addElement(enableRT);
    enableF1.setPresent();//sysj\systemController.sysj line: 68, column: 4
    currsigs.addElement(enableF1);
    enableF2.setPresent();//sysj\systemController.sysj line: 68, column: 19
    currsigs.addElement(enableF2);
    enableLL.setPresent();//sysj\systemController.sysj line: 68, column: 34
    currsigs.addElement(enableLL);
    enableCP.setPresent();//sysj\systemController.sysj line: 68, column: 49
    currsigs.addElement(enableCP);
    enableSP.setPresent();//sysj\systemController.sysj line: 69, column: 4
    currsigs.addElement(enableSP);
    enableRC.setPresent();//sysj\systemController.sysj line: 69, column: 19
    currsigs.addElement(enableRC);
    enableLR.setPresent();//sysj\systemController.sysj line: 69, column: 34
    currsigs.addElement(enableLR);
    enableLD.setPresent();//sysj\systemController.sysj line: 70, column: 4
    currsigs.addElement(enableLD);
    enableBR.setPresent();//sysj\systemController.sysj line: 70, column: 19
    currsigs.addElement(enableBR);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread175405(int [] tdone, int [] ends){
        S170241=1;
    modeBL.setPresent();//sysj\systemController.sysj line: 57, column: 4
    currsigs.addElement(modeBL);
    modeBL.setValue(0);//sysj\systemController.sysj line: 57, column: 4
    modeF1.setPresent();//sysj\systemController.sysj line: 57, column: 20
    currsigs.addElement(modeF1);
    modeF1.setValue(0);//sysj\systemController.sysj line: 57, column: 20
    modeF2.setPresent();//sysj\systemController.sysj line: 57, column: 36
    currsigs.addElement(modeF2);
    modeF2.setValue(0);//sysj\systemController.sysj line: 57, column: 36
    modeLL.setPresent();//sysj\systemController.sysj line: 58, column: 4
    currsigs.addElement(modeLL);
    modeLL.setValue(0);//sysj\systemController.sysj line: 58, column: 4
    modeCP.setPresent();//sysj\systemController.sysj line: 58, column: 20
    currsigs.addElement(modeCP);
    modeCP.setValue(0);//sysj\systemController.sysj line: 58, column: 20
    modeSP.setPresent();//sysj\systemController.sysj line: 59, column: 4
    currsigs.addElement(modeSP);
    modeSP.setValue(0);//sysj\systemController.sysj line: 59, column: 4
    modeRC.setPresent();//sysj\systemController.sysj line: 59, column: 20
    currsigs.addElement(modeRC);
    modeRC.setValue(0);//sysj\systemController.sysj line: 59, column: 20
    modeLR.setPresent();//sysj\systemController.sysj line: 59, column: 36
    currsigs.addElement(modeLR);
    modeLR.setValue(0);//sysj\systemController.sysj line: 59, column: 36
    modeLD.setPresent();//sysj\systemController.sysj line: 60, column: 4
    currsigs.addElement(modeLD);
    modeLD.setValue(0);//sysj\systemController.sysj line: 60, column: 4
    modeBR.setPresent();//sysj\systemController.sysj line: 60, column: 20
    currsigs.addElement(modeBR);
    modeBR.setValue(0);//sysj\systemController.sysj line: 60, column: 20
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
      switch(S175403){
        case 0 : 
          S175403=0;
          break RUN;
        
        case 1 : 
          S175403=2;
          S175403=2;
          thread175405(tdone,ends);
          thread175406(tdone,ends);
          thread175407(tdone,ends);
          thread175408(tdone,ends);
          thread175409(tdone,ends);
          thread175410(tdone,ends);
          thread175411(tdone,ends);
          int biggest175412 = 0;
          if(ends[2]>=biggest175412){
            biggest175412=ends[2];
          }
          if(ends[3]>=biggest175412){
            biggest175412=ends[3];
          }
          if(ends[4]>=biggest175412){
            biggest175412=ends[4];
          }
          if(ends[5]>=biggest175412){
            biggest175412=ends[5];
          }
          if(ends[6]>=biggest175412){
            biggest175412=ends[6];
          }
          if(ends[7]>=biggest175412){
            biggest175412=ends[7];
          }
          if(ends[8]>=biggest175412){
            biggest175412=ends[8];
          }
          if(biggest175412 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread175413(tdone,ends);
          thread175414(tdone,ends);
          thread175415(tdone,ends);
          thread175416(tdone,ends);
          thread175417(tdone,ends);
          thread175418(tdone,ends);
          thread175419(tdone,ends);
          int biggest175420 = 0;
          if(ends[2]>=biggest175420){
            biggest175420=ends[2];
          }
          if(ends[3]>=biggest175420){
            biggest175420=ends[3];
          }
          if(ends[4]>=biggest175420){
            biggest175420=ends[4];
          }
          if(ends[5]>=biggest175420){
            biggest175420=ends[5];
          }
          if(ends[6]>=biggest175420){
            biggest175420=ends[6];
          }
          if(ends[7]>=biggest175420){
            biggest175420=ends[7];
          }
          if(ends[8]>=biggest175420){
            biggest175420=ends[8];
          }
          if(biggest175420 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest175420 == 0){
            S175403=0;
            active[1]=0;
            ends[1]=0;
            S175403=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          bottleRecycled_in.gethook();
          orderProgress_o.gethook();
          orderRejected_o.gethook();
          loadOrder_o.gethook();
          bottleRejected_o.gethook();
          recyclingStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      recyclingStatus.setpreclear();
      modeBL.setpreclear();
      modeF1.setpreclear();
      modeF2.setpreclear();
      modeLL.setpreclear();
      modeCP.setpreclear();
      modeSP.setpreclear();
      modeRC.setpreclear();
      modeLR.setpreclear();
      modeLD.setpreclear();
      modeBR.setpreclear();
      enableBL.setpreclear();
      enableCV.setpreclear();
      enableRT.setpreclear();
      enableF1.setpreclear();
      enableF2.setpreclear();
      enableLL.setpreclear();
      enableCP.setpreclear();
      enableSP.setpreclear();
      enableRC.setpreclear();
      enableLR.setpreclear();
      enableLD.setpreclear();
      enableBR.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = recyclingStatus.getStatus() ? recyclingStatus.setprepresent() : recyclingStatus.setpreclear();
      recyclingStatus.setpreval(recyclingStatus.getValue());
      recyclingStatus.setClear();
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
      modeSP.sethook();
      modeSP.setClear();
      modeRC.sethook();
      modeRC.setClear();
      modeLR.sethook();
      modeLR.setClear();
      modeLD.sethook();
      modeLD.setClear();
      modeBR.sethook();
      modeBR.setClear();
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
      enableSP.sethook();
      enableSP.setClear();
      enableRC.sethook();
      enableRC.setClear();
      enableLR.sethook();
      enableLR.setClear();
      enableLD.sethook();
      enableLD.setClear();
      enableBR.sethook();
      enableBR.setClear();
      purchaseOrder_in.sethook();
      loadAck_in.sethook();
      bottleDone_in.sethook();
      bottleRecycled_in.sethook();
      orderProgress_o.sethook();
      orderRejected_o.sethook();
      loadOrder_o.sethook();
      bottleRejected_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        purchaseOrder_in.gethook();
        loadAck_in.gethook();
        bottleDone_in.gethook();
        bottleRecycled_in.gethook();
        orderProgress_o.gethook();
        orderRejected_o.gethook();
        loadOrder_o.gethook();
        bottleRejected_o.gethook();
        recyclingStatus.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
