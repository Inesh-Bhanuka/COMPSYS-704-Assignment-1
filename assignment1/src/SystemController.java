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
  public Signal twinBL = new Signal("twinBL", Signal.INPUT);
  public Signal twinCV = new Signal("twinCV", Signal.INPUT);
  public Signal twinRT = new Signal("twinRT", Signal.INPUT);
  public Signal twinF1 = new Signal("twinF1", Signal.INPUT);
  public Signal twinF2 = new Signal("twinF2", Signal.INPUT);
  public Signal twinLL = new Signal("twinLL", Signal.INPUT);
  public Signal twinCP = new Signal("twinCP", Signal.INPUT);
  public Signal twinLB = new Signal("twinLB", Signal.INPUT);
  public Signal labellerStatus = new Signal("labellerStatus", Signal.INPUT);
  public Signal recyclingStatus = new Signal("recyclingStatus", Signal.INPUT);
  public Signal modeBL = new Signal("modeBL", Signal.OUTPUT);
  public Signal modeF1 = new Signal("modeF1", Signal.OUTPUT);
  public Signal modeF2 = new Signal("modeF2", Signal.OUTPUT);
  public Signal modeLL = new Signal("modeLL", Signal.OUTPUT);
  public Signal modeCP = new Signal("modeCP", Signal.OUTPUT);
  public Signal modeLB = new Signal("modeLB", Signal.OUTPUT);
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
  public Signal enableLB = new Signal("enableLB", Signal.OUTPUT);
  public Signal enableSP = new Signal("enableSP", Signal.OUTPUT);
  public Signal enableRC = new Signal("enableRC", Signal.OUTPUT);
  public Signal enableLR = new Signal("enableLR", Signal.OUTPUT);
  public Signal enableLD = new Signal("enableLD", Signal.OUTPUT);
  public Signal enableBR = new Signal("enableBR", Signal.OUTPUT);
  public input_Channel purchaseOrder_in = new input_Channel();
  public input_Channel loadAck_in = new input_Channel();
  public input_Channel bottleDone_in = new input_Channel();
  public input_Channel labelDone_in = new input_Channel();
  public input_Channel bottleRecycled_in = new input_Channel();
  public output_Channel orderProgress_o = new output_Channel();
  public output_Channel orderRejected_o = new output_Channel();
  public output_Channel loadOrder_o = new output_Channel();
  public output_Channel labelBottle_o = new output_Channel();
  public output_Channel bottleRejected_o = new output_Channel();
  private WorkpieceTwin w_thread_4;//sysj\systemController.sysj line: 92, column: 3
  private WorkpieceTwin w_thread_6;//sysj\systemController.sysj line: 117, column: 3
  private WorkpieceTwin w_thread_7;//sysj\systemController.sysj line: 137, column: 3
  private int done_thread_7;//sysj\systemController.sysj line: 138, column: 3
  private ABSTwin plant_thread_8;//sysj\systemController.sysj line: 172, column: 3
  private TwinPublisher out_thread_8;//sysj\systemController.sysj line: 173, column: 3
  private WorkpieceTwin w_thread_9;//sysj\systemController.sysj line: 201, column: 3
  private int recovered_thread_9;//sysj\systemController.sysj line: 202, column: 3
  private int last_thread_10;//sysj\systemController.sysj line: 217, column: 3
  private int v_thread_10;//sysj\systemController.sysj line: 218, column: 3
  private int S214327 = 1;
  private int S208315 = 1;
  private int S208320 = 1;
  private int S208988 = 1;
  private int S208343 = 1;
  private int S208327 = 1;
  private int S208322 = 1;
  private int S208350 = 1;
  private int S208345 = 1;
  private int S209059 = 1;
  private int S209011 = 1;
  private int S208995 = 1;
  private int S208990 = 1;
  private int S209727 = 1;
  private int S209082 = 1;
  private int S209066 = 1;
  private int S209061 = 1;
  private int S209089 = 1;
  private int S209084 = 1;
  private int S212051 = 1;
  private int S209751 = 1;
  private int S209735 = 1;
  private int S209730 = 1;
  private int S209842 = 1;
  private int S209758 = 1;
  private int S209753 = 1;
  private int S209804 = 1;
  private int S209799 = 1;
  private int S213637 = 1;
  private int S212055 = 1;
  private int S214305 = 1;
  private int S213661 = 1;
  private int S213645 = 1;
  private int S213640 = 1;
  private int S213668 = 1;
  private int S213663 = 1;
  private int S214325 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread214347(int [] tdone, int [] ends){
        switch(S214325){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 220, column: 12
          v_thread_10 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 221, column: 5
          if(v_thread_10 != last_thread_10) {//sysj\systemController.sysj line: 222, column: 18
            if(v_thread_10 == 0) {//sysj\systemController.sysj line: 223, column: 16
              System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 223, column: 18
            }
            if(v_thread_10 == 1) {//sysj\systemController.sysj line: 224, column: 16
              System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 224, column: 18
            }
            if(v_thread_10 == 2) {//sysj\systemController.sysj line: 225, column: 16
              System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 225, column: 18
            }
            if(v_thread_10 == 3) {//sysj\systemController.sysj line: 226, column: 16
              System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 226, column: 18
            }
            last_thread_10 = v_thread_10;//sysj\systemController.sysj line: 227, column: 6
          }
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread214346(int [] tdone, int [] ends){
        switch(S214305){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S213661){
          case 0 : 
            switch(S213645){
              case 0 : 
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 204, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                  S213645=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  switch(S213640){
                    case 0 : 
                      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 204, column: 4
                        S213640=1;
                        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                          ends[9]=2;
                          ;//sysj\systemController.sysj line: 204, column: 4
                          w_thread_9 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 205, column: 4
                          recovered_thread_9 = recovered_thread_9 + 1;//sysj\systemController.sysj line: 206, column: 4
                          System.out.println("[SC] " + w_thread_9 + " recovered by the Recycling Station at " + w_thread_9.filledMl() + "ml, sealed=" + w_thread_9.isSealed() + ". " + recovered_thread_9 + " recycled.");//sysj\systemController.sysj line: 207, column: 4
                          S213661=1;
                          S213668=0;
                          if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                            S213668=1;
                            active[9]=1;
                            ends[9]=1;
                            tdone[9]=1;
                          }
                          else {
                            S213663=0;
                            if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                              orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                              S213663=1;
                              if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                                orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                                ends[9]=2;
                                ;//sysj\systemController.sysj line: 209, column: 4
                                S213661=2;
                                active[9]=1;
                                ends[9]=1;
                                tdone[9]=1;
                              }
                              else {
                                active[9]=1;
                                ends[9]=1;
                                tdone[9]=1;
                              }
                            }
                            else {
                              active[9]=1;
                              ends[9]=1;
                              tdone[9]=1;
                            }
                          }
                        }
                        else {
                          active[9]=1;
                          ends[9]=1;
                          tdone[9]=1;
                        }
                      }
                      else {
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                        bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                        ends[9]=2;
                        ;//sysj\systemController.sysj line: 204, column: 4
                        w_thread_9 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 205, column: 4
                        recovered_thread_9 = recovered_thread_9 + 1;//sysj\systemController.sysj line: 206, column: 4
                        System.out.println("[SC] " + w_thread_9 + " recovered by the Recycling Station at " + w_thread_9.filledMl() + "ml, sealed=" + w_thread_9.isSealed() + ". " + recovered_thread_9 + " recycled.");//sysj\systemController.sysj line: 207, column: 4
                        S213661=1;
                        S213668=0;
                        if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                          orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                          S213668=1;
                          active[9]=1;
                          ends[9]=1;
                          tdone[9]=1;
                        }
                        else {
                          S213663=0;
                          if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                            orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                            S213663=1;
                            if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                              orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                              ends[9]=2;
                              ;//sysj\systemController.sysj line: 209, column: 4
                              S213661=2;
                              active[9]=1;
                              ends[9]=1;
                              tdone[9]=1;
                            }
                            else {
                              active[9]=1;
                              ends[9]=1;
                              tdone[9]=1;
                            }
                          }
                          else {
                            active[9]=1;
                            ends[9]=1;
                            tdone[9]=1;
                          }
                        }
                      }
                      else {
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S213645=1;
                S213645=0;
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 204, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                  S213645=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  S213640=0;
                  if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                    bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 204, column: 4
                    S213640=1;
                    if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                      ends[9]=2;
                      ;//sysj\systemController.sysj line: 204, column: 4
                      w_thread_9 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 205, column: 4
                      recovered_thread_9 = recovered_thread_9 + 1;//sysj\systemController.sysj line: 206, column: 4
                      System.out.println("[SC] " + w_thread_9 + " recovered by the Recycling Station at " + w_thread_9.filledMl() + "ml, sealed=" + w_thread_9.isSealed() + ". " + recovered_thread_9 + " recycled.");//sysj\systemController.sysj line: 207, column: 4
                      S213661=1;
                      S213668=0;
                      if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                        S213668=1;
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        S213663=0;
                        if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                          orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                          S213663=1;
                          if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                            ends[9]=2;
                            ;//sysj\systemController.sysj line: 209, column: 4
                            S213661=2;
                            active[9]=1;
                            ends[9]=1;
                            tdone[9]=1;
                          }
                          else {
                            active[9]=1;
                            ends[9]=1;
                            tdone[9]=1;
                          }
                        }
                        else {
                          active[9]=1;
                          ends[9]=1;
                          tdone[9]=1;
                        }
                      }
                    }
                    else {
                      active[9]=1;
                      ends[9]=1;
                      tdone[9]=1;
                    }
                  }
                  else {
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            switch(S213668){
              case 0 : 
                if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                  orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                  S213668=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  switch(S213663){
                    case 0 : 
                      if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                        orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                        S213663=1;
                        if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                          orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                          ends[9]=2;
                          ;//sysj\systemController.sysj line: 209, column: 4
                          S213661=2;
                          active[9]=1;
                          ends[9]=1;
                          tdone[9]=1;
                        }
                        else {
                          active[9]=1;
                          ends[9]=1;
                          tdone[9]=1;
                        }
                      }
                      else {
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                        ends[9]=2;
                        ;//sysj\systemController.sysj line: 209, column: 4
                        S213661=2;
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S213668=1;
                S213668=0;
                if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                  orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                  S213668=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  S213663=0;
                  if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                    orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                    S213663=1;
                    if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                      orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                      ends[9]=2;
                      ;//sysj\systemController.sysj line: 209, column: 4
                      S213661=2;
                      active[9]=1;
                      ends[9]=1;
                      tdone[9]=1;
                    }
                    else {
                      active[9]=1;
                      ends[9]=1;
                      tdone[9]=1;
                    }
                  }
                  else {
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            S213661=2;
            S213661=0;
            S213645=0;
            if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 204, column: 4
              bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
              S213645=1;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S213640=0;
              if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 204, column: 4
                S213640=1;
                if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
                  ends[9]=2;
                  ;//sysj\systemController.sysj line: 204, column: 4
                  w_thread_9 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 205, column: 4
                  recovered_thread_9 = recovered_thread_9 + 1;//sysj\systemController.sysj line: 206, column: 4
                  System.out.println("[SC] " + w_thread_9 + " recovered by the Recycling Station at " + w_thread_9.filledMl() + "ml, sealed=" + w_thread_9.isSealed() + ". " + recovered_thread_9 + " recycled.");//sysj\systemController.sysj line: 207, column: 4
                  S213661=1;
                  S213668=0;
                  if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
                    orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                    S213668=1;
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    S213663=0;
                    if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                      orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
                      S213663=1;
                      if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                        orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                        ends[9]=2;
                        ;//sysj\systemController.sysj line: 209, column: 4
                        S213661=2;
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      active[9]=1;
                      ends[9]=1;
                      tdone[9]=1;
                    }
                  }
                }
                else {
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
              }
              else {
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread214345(int [] tdone, int [] ends){
        switch(S213637){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S212055){
          case 0 : 
            PlantClock.advance();//sysj\systemController.sysj line: 176, column: 4
            S212055=0;
            if(twinBL.getprestatus()){//sysj\systemController.sysj line: 178, column: 12
              plant_thread_8.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 178, column: 21
              if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
                plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
                plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          
          case 1 : 
            S212055=1;
            PlantClock.advance();//sysj\systemController.sysj line: 176, column: 4
            S212055=0;
            if(twinBL.getprestatus()){//sysj\systemController.sysj line: 178, column: 12
              plant_thread_8.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 178, column: 21
              if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
                plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
                plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
                  plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
                    plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
                      plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                        plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                          plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                            plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                            plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                            TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                            out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                            S212055=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread214344(int [] tdone, int [] ends){
        switch(S212051){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S209751){
          case 0 : 
            switch(S209735){
              case 0 : 
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 140, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                  S209735=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S209730){
                    case 0 : 
                      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                        labelDone_in.setACK(true);//sysj\systemController.sysj line: 140, column: 4
                        S209730=1;
                        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                          labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 140, column: 4
                          w_thread_7 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 141, column: 4
                          S209751=1;
                          if(w_thread_7.isRejected()){//sysj\systemController.sysj line: 143, column: 4
                            S209842=0;
                            System.out.println("[SC] " + w_thread_7 + " refused a label (" + w_thread_7.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 144, column: 5
                            S209758=0;
                            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                              S209758=1;
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              S209753=0;
                              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                                bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                                S209753=1;
                                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                                  ends[7]=2;
                                  ;//sysj\systemController.sysj line: 146, column: 5
                                  S209751=2;
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
                            S209842=1;
                            w_thread_7.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 151, column: 5
                            w_thread_7.seal();//sysj\systemController.sysj line: 152, column: 5
                            BatchStore.shared().store(w_thread_7);//sysj\systemController.sysj line: 153, column: 5
                            done_thread_7 = done_thread_7 + 1;//sysj\systemController.sysj line: 154, column: 5
                            System.out.println("[SC] " + w_thread_7 + " labelled " + w_thread_7.serial + " and stored in batch " + w_thread_7.batchId + " (" + BatchStore.shared().held(w_thread_7.batchId) + " on the shelf). " + done_thread_7 + " complete.");//sysj\systemController.sysj line: 155, column: 5
                            OrderBook.purchaseOrder().refresh();//sysj\systemController.sysj line: 158, column: 5
                            S209804=0;
                            if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                              S209804=1;
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              S209799=0;
                              if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                                orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                                S209799=1;
                                if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                                  ends[7]=2;
                                  ;//sysj\systemController.sysj line: 159, column: 5
                                  S209751=2;
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
                      if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                        labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 140, column: 4
                        w_thread_7 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 141, column: 4
                        S209751=1;
                        if(w_thread_7.isRejected()){//sysj\systemController.sysj line: 143, column: 4
                          S209842=0;
                          System.out.println("[SC] " + w_thread_7 + " refused a label (" + w_thread_7.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 144, column: 5
                          S209758=0;
                          if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                            bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                            S209758=1;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            S209753=0;
                            if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                              bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                              S209753=1;
                              if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                                bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                                ends[7]=2;
                                ;//sysj\systemController.sysj line: 146, column: 5
                                S209751=2;
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
                          S209842=1;
                          w_thread_7.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 151, column: 5
                          w_thread_7.seal();//sysj\systemController.sysj line: 152, column: 5
                          BatchStore.shared().store(w_thread_7);//sysj\systemController.sysj line: 153, column: 5
                          done_thread_7 = done_thread_7 + 1;//sysj\systemController.sysj line: 154, column: 5
                          System.out.println("[SC] " + w_thread_7 + " labelled " + w_thread_7.serial + " and stored in batch " + w_thread_7.batchId + " (" + BatchStore.shared().held(w_thread_7.batchId) + " on the shelf). " + done_thread_7 + " complete.");//sysj\systemController.sysj line: 155, column: 5
                          OrderBook.purchaseOrder().refresh();//sysj\systemController.sysj line: 158, column: 5
                          S209804=0;
                          if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                            orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                            S209804=1;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            S209799=0;
                            if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                              orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                              S209799=1;
                              if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                                orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                                ends[7]=2;
                                ;//sysj\systemController.sysj line: 159, column: 5
                                S209751=2;
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
                S209735=1;
                S209735=0;
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 140, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                  S209735=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S209730=0;
                  if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                    labelDone_in.setACK(true);//sysj\systemController.sysj line: 140, column: 4
                    S209730=1;
                    if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                      labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 140, column: 4
                      w_thread_7 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 141, column: 4
                      S209751=1;
                      if(w_thread_7.isRejected()){//sysj\systemController.sysj line: 143, column: 4
                        S209842=0;
                        System.out.println("[SC] " + w_thread_7 + " refused a label (" + w_thread_7.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 144, column: 5
                        S209758=0;
                        if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                          S209758=1;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          S209753=0;
                          if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                            bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                            S209753=1;
                            if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 146, column: 5
                              S209751=2;
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
                        S209842=1;
                        w_thread_7.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 151, column: 5
                        w_thread_7.seal();//sysj\systemController.sysj line: 152, column: 5
                        BatchStore.shared().store(w_thread_7);//sysj\systemController.sysj line: 153, column: 5
                        done_thread_7 = done_thread_7 + 1;//sysj\systemController.sysj line: 154, column: 5
                        System.out.println("[SC] " + w_thread_7 + " labelled " + w_thread_7.serial + " and stored in batch " + w_thread_7.batchId + " (" + BatchStore.shared().held(w_thread_7.batchId) + " on the shelf). " + done_thread_7 + " complete.");//sysj\systemController.sysj line: 155, column: 5
                        OrderBook.purchaseOrder().refresh();//sysj\systemController.sysj line: 158, column: 5
                        S209804=0;
                        if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                          S209804=1;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          S209799=0;
                          if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                            orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                            S209799=1;
                            if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 159, column: 5
                              S209751=2;
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
            switch(S209842){
              case 0 : 
                switch(S209758){
                  case 0 : 
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                      S209758=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      switch(S209753){
                        case 0 : 
                          if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                            bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                            S209753=1;
                            if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 146, column: 5
                              S209751=2;
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
                          if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                            bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                            ends[7]=2;
                            ;//sysj\systemController.sysj line: 146, column: 5
                            S209751=2;
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
                    S209758=1;
                    S209758=0;
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                      S209758=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S209753=0;
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                        bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                        S209753=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 146, column: 5
                          S209751=2;
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
              
              case 1 : 
                switch(S209804){
                  case 0 : 
                    if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                      S209804=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      switch(S209799){
                        case 0 : 
                          if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                            orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                            S209799=1;
                            if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 159, column: 5
                              S209751=2;
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
                          if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                            orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                            ends[7]=2;
                            ;//sysj\systemController.sysj line: 159, column: 5
                            S209751=2;
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
                    S209804=1;
                    S209804=0;
                    if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                      S209804=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S209799=0;
                      if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                        orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                        S209799=1;
                        if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 159, column: 5
                          S209751=2;
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
              
            }
            break;
          
          case 2 : 
            S209751=2;
            S209751=0;
            S209735=0;
            if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 140, column: 4
              labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
              S209735=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S209730=0;
              if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                labelDone_in.setACK(true);//sysj\systemController.sysj line: 140, column: 4
                S209730=1;
                if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 140, column: 4
                  w_thread_7 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 141, column: 4
                  S209751=1;
                  if(w_thread_7.isRejected()){//sysj\systemController.sysj line: 143, column: 4
                    S209842=0;
                    System.out.println("[SC] " + w_thread_7 + " refused a label (" + w_thread_7.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 144, column: 5
                    S209758=0;
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                      S209758=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S209753=0;
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                        bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                        S209753=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 146, column: 5
                          S209751=2;
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
                    S209842=1;
                    w_thread_7.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 151, column: 5
                    w_thread_7.seal();//sysj\systemController.sysj line: 152, column: 5
                    BatchStore.shared().store(w_thread_7);//sysj\systemController.sysj line: 153, column: 5
                    done_thread_7 = done_thread_7 + 1;//sysj\systemController.sysj line: 154, column: 5
                    System.out.println("[SC] " + w_thread_7 + " labelled " + w_thread_7.serial + " and stored in batch " + w_thread_7.batchId + " (" + BatchStore.shared().held(w_thread_7.batchId) + " on the shelf). " + done_thread_7 + " complete.");//sysj\systemController.sysj line: 155, column: 5
                    OrderBook.purchaseOrder().refresh();//sysj\systemController.sysj line: 158, column: 5
                    S209804=0;
                    if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
                      orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                      S209804=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S209799=0;
                      if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                        orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                        S209799=1;
                        if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                          orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 159, column: 5
                          S209751=2;
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

  public void thread214343(int [] tdone, int [] ends){
        switch(S209727){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S209082){
          case 0 : 
            switch(S209066){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                  S209066=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S209061){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 119, column: 4
                        S209061=1;
                        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 119, column: 4
                          w_thread_6 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 120, column: 4
                          S209082=1;
                          S209089=0;
                          if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                            S209089=1;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            S209084=0;
                            if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                              labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                              S209084=1;
                              if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                                ends[6]=2;
                                ;//sysj\systemController.sysj line: 126, column: 4
                                S209082=2;
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
                      if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                        bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 119, column: 4
                        w_thread_6 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 120, column: 4
                        S209082=1;
                        S209089=0;
                        if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                          S209089=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S209084=0;
                          if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                            labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                            S209084=1;
                            if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                              labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                              ends[6]=2;
                              ;//sysj\systemController.sysj line: 126, column: 4
                              S209082=2;
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
                S209066=1;
                S209066=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                  S209066=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S209061=0;
                  if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                    bottleDone_in.setACK(true);//sysj\systemController.sysj line: 119, column: 4
                    S209061=1;
                    if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 119, column: 4
                      w_thread_6 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 120, column: 4
                      S209082=1;
                      S209089=0;
                      if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                        S209089=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S209084=0;
                        if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                          labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                          S209084=1;
                          if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                            ends[6]=2;
                            ;//sysj\systemController.sysj line: 126, column: 4
                            S209082=2;
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
            switch(S209089){
              case 0 : 
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                  S209089=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S209084){
                    case 0 : 
                      if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                        labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                        S209084=1;
                        if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 126, column: 4
                          S209082=2;
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
                      if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 126, column: 4
                        S209082=2;
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
                S209089=1;
                S209089=0;
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                  S209089=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S209084=0;
                  if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                    labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                    S209084=1;
                    if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                      labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 126, column: 4
                      S209082=2;
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
            S209082=2;
            S209082=0;
            S209066=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 4
              bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
              S209066=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S209061=0;
              if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                bottleDone_in.setACK(true);//sysj\systemController.sysj line: 119, column: 4
                S209061=1;
                if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
                  ends[6]=2;
                  ;//sysj\systemController.sysj line: 119, column: 4
                  w_thread_6 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 120, column: 4
                  S209082=1;
                  S209089=0;
                  if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
                    labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                    S209089=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S209084=0;
                    if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                      labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
                      S209084=1;
                      if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 126, column: 4
                        S209082=2;
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

  public void thread214342(int [] tdone, int [] ends){
        switch(S209059){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S209011){
          case 0 : 
            switch(S208995){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 105, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                  S208995=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S208990){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                        loadAck_in.setACK(true);//sysj\systemController.sysj line: 105, column: 4
                        S208990=1;
                        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                          loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                          ends[5]=2;
                          ;//sysj\systemController.sysj line: 105, column: 4
                          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 106, column: 4
                          S209011=1;
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
                      if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                        loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                        ends[5]=2;
                        ;//sysj\systemController.sysj line: 105, column: 4
                        System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 106, column: 4
                        S209011=1;
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
                S208995=1;
                S208995=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 105, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                  S208995=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S208990=0;
                  if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                    loadAck_in.setACK(true);//sysj\systemController.sysj line: 105, column: 4
                    S208990=1;
                    if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                      loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                      ends[5]=2;
                      ;//sysj\systemController.sysj line: 105, column: 4
                      System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 106, column: 4
                      S209011=1;
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
            S209011=1;
            S209011=0;
            S208995=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 105, column: 4
              loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
              S208995=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S208990=0;
              if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                loadAck_in.setACK(true);//sysj\systemController.sysj line: 105, column: 4
                S208990=1;
                if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
                  ends[5]=2;
                  ;//sysj\systemController.sysj line: 105, column: 4
                  System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 106, column: 4
                  S209011=1;
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

  public void thread214341(int [] tdone, int [] ends){
        switch(S208988){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S208343){
          case 0 : 
            switch(S208327){
              case 0 : 
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 94, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                  S208327=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S208322){
                    case 0 : 
                      if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                        purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 94, column: 4
                        S208322=1;
                        if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                          purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                          ends[4]=2;
                          ;//sysj\systemController.sysj line: 94, column: 4
                          w_thread_4 = (WorkpieceTwin)(purchaseOrder_in.getVal() == null ? null : ((WorkpieceTwin)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 95, column: 4
                          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 96, column: 4
                          TwinRegistry.shared().admit(w_thread_4);//sysj\systemController.sysj line: 97, column: 4
                          S208343=1;
                          S208350=0;
                          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                            S208350=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S208345=0;
                            if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                              loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                              S208345=1;
                              if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                                ends[4]=2;
                                ;//sysj\systemController.sysj line: 98, column: 4
                                S208343=2;
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
                      if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                        purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 94, column: 4
                        w_thread_4 = (WorkpieceTwin)(purchaseOrder_in.getVal() == null ? null : ((WorkpieceTwin)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 95, column: 4
                        System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 96, column: 4
                        TwinRegistry.shared().admit(w_thread_4);//sysj\systemController.sysj line: 97, column: 4
                        S208343=1;
                        S208350=0;
                        if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                          S208350=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S208345=0;
                          if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                            loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                            S208345=1;
                            if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                              loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                              ends[4]=2;
                              ;//sysj\systemController.sysj line: 98, column: 4
                              S208343=2;
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
                S208327=1;
                S208327=0;
                if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 94, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                  S208327=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S208322=0;
                  if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                    purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 94, column: 4
                    S208322=1;
                    if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                      purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                      ends[4]=2;
                      ;//sysj\systemController.sysj line: 94, column: 4
                      w_thread_4 = (WorkpieceTwin)(purchaseOrder_in.getVal() == null ? null : ((WorkpieceTwin)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 95, column: 4
                      System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 96, column: 4
                      TwinRegistry.shared().admit(w_thread_4);//sysj\systemController.sysj line: 97, column: 4
                      S208343=1;
                      S208350=0;
                      if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                        S208350=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S208345=0;
                        if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                          loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                          S208345=1;
                          if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                            ends[4]=2;
                            ;//sysj\systemController.sysj line: 98, column: 4
                            S208343=2;
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
            switch(S208350){
              case 0 : 
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                  S208350=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S208345){
                    case 0 : 
                      if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                        loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                        S208345=1;
                        if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                          ends[4]=2;
                          ;//sysj\systemController.sysj line: 98, column: 4
                          S208343=2;
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
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 98, column: 4
                        S208343=2;
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
                S208350=1;
                S208350=0;
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                  S208350=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S208345=0;
                  if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                    loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                    S208345=1;
                    if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                      loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                      ends[4]=2;
                      ;//sysj\systemController.sysj line: 98, column: 4
                      S208343=2;
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
            S208343=2;
            S208343=0;
            S208327=0;
            if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 94, column: 4
              purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
              S208327=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S208322=0;
              if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 94, column: 4
                S208322=1;
                if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
                  purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 94, column: 4
                  w_thread_4 = (WorkpieceTwin)(purchaseOrder_in.getVal() == null ? null : ((WorkpieceTwin)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 95, column: 4
                  System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 96, column: 4
                  TwinRegistry.shared().admit(w_thread_4);//sysj\systemController.sysj line: 97, column: 4
                  S208343=1;
                  S208350=0;
                  if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
                    loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                    S208350=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S208345=0;
                    if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                      loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
                      S208345=1;
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                        ends[4]=2;
                        ;//sysj\systemController.sysj line: 98, column: 4
                        S208343=2;
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

  public void thread214340(int [] tdone, int [] ends){
        switch(S208320){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj\systemController.sysj line: 83, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 83, column: 19
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 83, column: 34
        currsigs.addElement(enableRT);
        enableF1.setPresent();//sysj\systemController.sysj line: 84, column: 4
        currsigs.addElement(enableF1);
        enableF2.setPresent();//sysj\systemController.sysj line: 84, column: 19
        currsigs.addElement(enableF2);
        enableLL.setPresent();//sysj\systemController.sysj line: 84, column: 34
        currsigs.addElement(enableLL);
        enableCP.setPresent();//sysj\systemController.sysj line: 84, column: 49
        currsigs.addElement(enableCP);
        enableLB.setPresent();//sysj\systemController.sysj line: 84, column: 64
        currsigs.addElement(enableLB);
        enableSP.setPresent();//sysj\systemController.sysj line: 85, column: 4
        currsigs.addElement(enableSP);
        enableRC.setPresent();//sysj\systemController.sysj line: 85, column: 19
        currsigs.addElement(enableRC);
        enableLR.setPresent();//sysj\systemController.sysj line: 85, column: 34
        currsigs.addElement(enableLR);
        enableLD.setPresent();//sysj\systemController.sysj line: 86, column: 4
        currsigs.addElement(enableLD);
        enableBR.setPresent();//sysj\systemController.sysj line: 86, column: 19
        currsigs.addElement(enableBR);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread214339(int [] tdone, int [] ends){
        switch(S208315){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        modeBL.setPresent();//sysj\systemController.sysj line: 73, column: 4
        currsigs.addElement(modeBL);
        modeBL.setValue(0);//sysj\systemController.sysj line: 73, column: 4
        modeF1.setPresent();//sysj\systemController.sysj line: 73, column: 20
        currsigs.addElement(modeF1);
        modeF1.setValue(0);//sysj\systemController.sysj line: 73, column: 20
        modeF2.setPresent();//sysj\systemController.sysj line: 73, column: 36
        currsigs.addElement(modeF2);
        modeF2.setValue(0);//sysj\systemController.sysj line: 73, column: 36
        modeLL.setPresent();//sysj\systemController.sysj line: 74, column: 4
        currsigs.addElement(modeLL);
        modeLL.setValue(0);//sysj\systemController.sysj line: 74, column: 4
        modeCP.setPresent();//sysj\systemController.sysj line: 74, column: 20
        currsigs.addElement(modeCP);
        modeCP.setValue(0);//sysj\systemController.sysj line: 74, column: 20
        modeLB.setPresent();//sysj\systemController.sysj line: 74, column: 36
        currsigs.addElement(modeLB);
        modeLB.setValue(0);//sysj\systemController.sysj line: 74, column: 36
        modeSP.setPresent();//sysj\systemController.sysj line: 75, column: 4
        currsigs.addElement(modeSP);
        modeSP.setValue(0);//sysj\systemController.sysj line: 75, column: 4
        modeRC.setPresent();//sysj\systemController.sysj line: 75, column: 20
        currsigs.addElement(modeRC);
        modeRC.setValue(0);//sysj\systemController.sysj line: 75, column: 20
        modeLR.setPresent();//sysj\systemController.sysj line: 75, column: 36
        currsigs.addElement(modeLR);
        modeLR.setValue(0);//sysj\systemController.sysj line: 75, column: 36
        modeLD.setPresent();//sysj\systemController.sysj line: 76, column: 4
        currsigs.addElement(modeLD);
        modeLD.setValue(0);//sysj\systemController.sysj line: 76, column: 4
        modeBR.setPresent();//sysj\systemController.sysj line: 76, column: 20
        currsigs.addElement(modeBR);
        modeBR.setValue(0);//sysj\systemController.sysj line: 76, column: 20
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread214337(int [] tdone, int [] ends){
        S214325=1;
    last_thread_10 = -1;//sysj\systemController.sysj line: 217, column: 3
    v_thread_10 = 0;//sysj\systemController.sysj line: 218, column: 3
    if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 220, column: 12
      v_thread_10 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 221, column: 5
      if(v_thread_10 != last_thread_10) {//sysj\systemController.sysj line: 222, column: 18
        if(v_thread_10 == 0) {//sysj\systemController.sysj line: 223, column: 16
          System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 223, column: 18
        }
        if(v_thread_10 == 1) {//sysj\systemController.sysj line: 224, column: 16
          System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 224, column: 18
        }
        if(v_thread_10 == 2) {//sysj\systemController.sysj line: 225, column: 16
          System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 225, column: 18
        }
        if(v_thread_10 == 3) {//sysj\systemController.sysj line: 226, column: 16
          System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 226, column: 18
        }
        last_thread_10 = v_thread_10;//sysj\systemController.sysj line: 227, column: 6
      }
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread214336(int [] tdone, int [] ends){
        S214305=1;
    w_thread_9 = null;//sysj\systemController.sysj line: 201, column: 3
    recovered_thread_9 = 0;//sysj\systemController.sysj line: 202, column: 3
    S213661=0;
    S213645=0;
    if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 204, column: 4
      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
      S213645=1;
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      S213640=0;
      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 204, column: 4
        S213640=1;
        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 204, column: 4
          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 204, column: 4
          ends[9]=2;
          ;//sysj\systemController.sysj line: 204, column: 4
          w_thread_9 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 205, column: 4
          recovered_thread_9 = recovered_thread_9 + 1;//sysj\systemController.sysj line: 206, column: 4
          System.out.println("[SC] " + w_thread_9 + " recovered by the Recycling Station at " + w_thread_9.filledMl() + "ml, sealed=" + w_thread_9.isSealed() + ". " + recovered_thread_9 + " recycled.");//sysj\systemController.sysj line: 207, column: 4
          S213661=1;
          S213668=0;
          if(!orderRejected_o.isPartnerPresent() || orderRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 209, column: 4
            orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
            S213668=1;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
          }
          else {
            S213663=0;
            if(orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
              orderRejected_o.setVal(new Integer((int)w_thread_9.id));//sysj\systemController.sysj line: 209, column: 4
              S213663=1;
              if(!orderRejected_o.isACK()){//sysj\systemController.sysj line: 209, column: 4
                orderRejected_o.setREQ(false);//sysj\systemController.sysj line: 209, column: 4
                ends[9]=2;
                ;//sysj\systemController.sysj line: 209, column: 4
                S213661=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
          }
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
      else {
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
    }
  }

  public void thread214335(int [] tdone, int [] ends){
        S213637=1;
    plant_thread_8 = new ABSTwin();//sysj\systemController.sysj line: 172, column: 3
    out_thread_8 = TwinPublisher.shared();//sysj\systemController.sysj line: 173, column: 3
    PlantClock.advance();//sysj\systemController.sysj line: 176, column: 4
    S212055=0;
    if(twinBL.getprestatus()){//sysj\systemController.sysj line: 178, column: 12
      plant_thread_8.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 178, column: 21
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
        plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
          plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
      }
      else {
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
          plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
      }
    }
    else {
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 179, column: 12
        plant_thread_8.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 179, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
          plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
      }
      else {
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 180, column: 12
          plant_thread_8.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 180, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 181, column: 12
            plant_thread_8.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 181, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 182, column: 12
              plant_thread_8.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 182, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 183, column: 12
                plant_thread_8.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 183, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 184, column: 12
                  plant_thread_8.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 184, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 185, column: 12
                    plant_thread_8.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 185, column: 21
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                  else {
                    plant_thread_8.setTick(PlantClock.now());//sysj\systemController.sysj line: 187, column: 4
                    plant_thread_8.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 188, column: 4
                    TwinRegistry.shared().fill(plant_thread_8);//sysj\systemController.sysj line: 189, column: 4
                    out_thread_8.publish(plant_thread_8, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 190, column: 4
                    S212055=1;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public void thread214334(int [] tdone, int [] ends){
        S212051=1;
    w_thread_7 = null;//sysj\systemController.sysj line: 137, column: 3
    done_thread_7 = 0;//sysj\systemController.sysj line: 138, column: 3
    S209751=0;
    S209735=0;
    if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 140, column: 4
      labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
      S209735=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S209730=0;
      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
        labelDone_in.setACK(true);//sysj\systemController.sysj line: 140, column: 4
        S209730=1;
        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 140, column: 4
          labelDone_in.setACK(false);//sysj\systemController.sysj line: 140, column: 4
          ends[7]=2;
          ;//sysj\systemController.sysj line: 140, column: 4
          w_thread_7 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 141, column: 4
          S209751=1;
          if(w_thread_7.isRejected()){//sysj\systemController.sysj line: 143, column: 4
            S209842=0;
            System.out.println("[SC] " + w_thread_7 + " refused a label (" + w_thread_7.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 144, column: 5
            S209758=0;
            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 146, column: 5
              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
              S209758=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S209753=0;
              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                bottleRejected_o.setVal(w_thread_7);//sysj\systemController.sysj line: 146, column: 5
                S209753=1;
                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 146, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 146, column: 5
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 146, column: 5
                  S209751=2;
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
            S209842=1;
            w_thread_7.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 151, column: 5
            w_thread_7.seal();//sysj\systemController.sysj line: 152, column: 5
            BatchStore.shared().store(w_thread_7);//sysj\systemController.sysj line: 153, column: 5
            done_thread_7 = done_thread_7 + 1;//sysj\systemController.sysj line: 154, column: 5
            System.out.println("[SC] " + w_thread_7 + " labelled " + w_thread_7.serial + " and stored in batch " + w_thread_7.batchId + " (" + BatchStore.shared().held(w_thread_7.batchId) + " on the shelf). " + done_thread_7 + " complete.");//sysj\systemController.sysj line: 155, column: 5
            OrderBook.purchaseOrder().refresh();//sysj\systemController.sysj line: 158, column: 5
            S209804=0;
            if(!orderProgress_o.isPartnerPresent() || orderProgress_o.isPartnerPreempted()){//sysj\systemController.sysj line: 159, column: 5
              orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
              S209804=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S209799=0;
              if(orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                orderProgress_o.setVal(new Integer((int)w_thread_7.id));//sysj\systemController.sysj line: 159, column: 5
                S209799=1;
                if(!orderProgress_o.isACK()){//sysj\systemController.sysj line: 159, column: 5
                  orderProgress_o.setREQ(false);//sysj\systemController.sysj line: 159, column: 5
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 159, column: 5
                  S209751=2;
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

  public void thread214333(int [] tdone, int [] ends){
        S209727=1;
    w_thread_6 = null;//sysj\systemController.sysj line: 117, column: 3
    S209082=0;
    S209066=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 119, column: 4
      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
      S209066=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S209061=0;
      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 119, column: 4
        S209061=1;
        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 119, column: 4
          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 119, column: 4
          ends[6]=2;
          ;//sysj\systemController.sysj line: 119, column: 4
          w_thread_6 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 120, column: 4
          S209082=1;
          S209089=0;
          if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 126, column: 4
            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
            S209089=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S209084=0;
            if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
              labelBottle_o.setVal(w_thread_6);//sysj\systemController.sysj line: 126, column: 4
              S209084=1;
              if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 126, column: 4
                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 126, column: 4
                ends[6]=2;
                ;//sysj\systemController.sysj line: 126, column: 4
                S209082=2;
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

  public void thread214332(int [] tdone, int [] ends){
        S209059=1;
    S209011=0;
    S208995=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 105, column: 4
      loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
      S208995=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S208990=0;
      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
        loadAck_in.setACK(true);//sysj\systemController.sysj line: 105, column: 4
        S208990=1;
        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 105, column: 4
          loadAck_in.setACK(false);//sysj\systemController.sysj line: 105, column: 4
          ends[5]=2;
          ;//sysj\systemController.sysj line: 105, column: 4
          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 106, column: 4
          S209011=1;
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

  public void thread214331(int [] tdone, int [] ends){
        S208988=1;
    w_thread_4 = null;//sysj\systemController.sysj line: 92, column: 3
    S208343=0;
    S208327=0;
    if(!purchaseOrder_in.isPartnerPresent() || purchaseOrder_in.isPartnerPreempted()){//sysj\systemController.sysj line: 94, column: 4
      purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
      S208327=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S208322=0;
      if(!purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
        purchaseOrder_in.setACK(true);//sysj\systemController.sysj line: 94, column: 4
        S208322=1;
        if(purchaseOrder_in.isREQ()){//sysj\systemController.sysj line: 94, column: 4
          purchaseOrder_in.setACK(false);//sysj\systemController.sysj line: 94, column: 4
          ends[4]=2;
          ;//sysj\systemController.sysj line: 94, column: 4
          w_thread_4 = (WorkpieceTwin)(purchaseOrder_in.getVal() == null ? null : ((WorkpieceTwin)purchaseOrder_in.getVal()));//sysj\systemController.sysj line: 95, column: 4
          System.out.println("[SC] Loading " + w_thread_4 + ".");//sysj\systemController.sysj line: 96, column: 4
          TwinRegistry.shared().admit(w_thread_4);//sysj\systemController.sysj line: 97, column: 4
          S208343=1;
          S208350=0;
          if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 98, column: 4
            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
            S208350=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            S208345=0;
            if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
              loadOrder_o.setVal(w_thread_4);//sysj\systemController.sysj line: 98, column: 4
              S208345=1;
              if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 98, column: 4
                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 98, column: 4
                ends[4]=2;
                ;//sysj\systemController.sysj line: 98, column: 4
                S208343=2;
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

  public void thread214330(int [] tdone, int [] ends){
        S208320=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 83, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 83, column: 19
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 83, column: 34
    currsigs.addElement(enableRT);
    enableF1.setPresent();//sysj\systemController.sysj line: 84, column: 4
    currsigs.addElement(enableF1);
    enableF2.setPresent();//sysj\systemController.sysj line: 84, column: 19
    currsigs.addElement(enableF2);
    enableLL.setPresent();//sysj\systemController.sysj line: 84, column: 34
    currsigs.addElement(enableLL);
    enableCP.setPresent();//sysj\systemController.sysj line: 84, column: 49
    currsigs.addElement(enableCP);
    enableLB.setPresent();//sysj\systemController.sysj line: 84, column: 64
    currsigs.addElement(enableLB);
    enableSP.setPresent();//sysj\systemController.sysj line: 85, column: 4
    currsigs.addElement(enableSP);
    enableRC.setPresent();//sysj\systemController.sysj line: 85, column: 19
    currsigs.addElement(enableRC);
    enableLR.setPresent();//sysj\systemController.sysj line: 85, column: 34
    currsigs.addElement(enableLR);
    enableLD.setPresent();//sysj\systemController.sysj line: 86, column: 4
    currsigs.addElement(enableLD);
    enableBR.setPresent();//sysj\systemController.sysj line: 86, column: 19
    currsigs.addElement(enableBR);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread214329(int [] tdone, int [] ends){
        S208315=1;
    modeBL.setPresent();//sysj\systemController.sysj line: 73, column: 4
    currsigs.addElement(modeBL);
    modeBL.setValue(0);//sysj\systemController.sysj line: 73, column: 4
    modeF1.setPresent();//sysj\systemController.sysj line: 73, column: 20
    currsigs.addElement(modeF1);
    modeF1.setValue(0);//sysj\systemController.sysj line: 73, column: 20
    modeF2.setPresent();//sysj\systemController.sysj line: 73, column: 36
    currsigs.addElement(modeF2);
    modeF2.setValue(0);//sysj\systemController.sysj line: 73, column: 36
    modeLL.setPresent();//sysj\systemController.sysj line: 74, column: 4
    currsigs.addElement(modeLL);
    modeLL.setValue(0);//sysj\systemController.sysj line: 74, column: 4
    modeCP.setPresent();//sysj\systemController.sysj line: 74, column: 20
    currsigs.addElement(modeCP);
    modeCP.setValue(0);//sysj\systemController.sysj line: 74, column: 20
    modeLB.setPresent();//sysj\systemController.sysj line: 74, column: 36
    currsigs.addElement(modeLB);
    modeLB.setValue(0);//sysj\systemController.sysj line: 74, column: 36
    modeSP.setPresent();//sysj\systemController.sysj line: 75, column: 4
    currsigs.addElement(modeSP);
    modeSP.setValue(0);//sysj\systemController.sysj line: 75, column: 4
    modeRC.setPresent();//sysj\systemController.sysj line: 75, column: 20
    currsigs.addElement(modeRC);
    modeRC.setValue(0);//sysj\systemController.sysj line: 75, column: 20
    modeLR.setPresent();//sysj\systemController.sysj line: 75, column: 36
    currsigs.addElement(modeLR);
    modeLR.setValue(0);//sysj\systemController.sysj line: 75, column: 36
    modeLD.setPresent();//sysj\systemController.sysj line: 76, column: 4
    currsigs.addElement(modeLD);
    modeLD.setValue(0);//sysj\systemController.sysj line: 76, column: 4
    modeBR.setPresent();//sysj\systemController.sysj line: 76, column: 20
    currsigs.addElement(modeBR);
    modeBR.setValue(0);//sysj\systemController.sysj line: 76, column: 20
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
      switch(S214327){
        case 0 : 
          S214327=0;
          break RUN;
        
        case 1 : 
          S214327=2;
          S214327=2;
          thread214329(tdone,ends);
          thread214330(tdone,ends);
          thread214331(tdone,ends);
          thread214332(tdone,ends);
          thread214333(tdone,ends);
          thread214334(tdone,ends);
          thread214335(tdone,ends);
          thread214336(tdone,ends);
          thread214337(tdone,ends);
          int biggest214338 = 0;
          if(ends[2]>=biggest214338){
            biggest214338=ends[2];
          }
          if(ends[3]>=biggest214338){
            biggest214338=ends[3];
          }
          if(ends[4]>=biggest214338){
            biggest214338=ends[4];
          }
          if(ends[5]>=biggest214338){
            biggest214338=ends[5];
          }
          if(ends[6]>=biggest214338){
            biggest214338=ends[6];
          }
          if(ends[7]>=biggest214338){
            biggest214338=ends[7];
          }
          if(ends[8]>=biggest214338){
            biggest214338=ends[8];
          }
          if(ends[9]>=biggest214338){
            biggest214338=ends[9];
          }
          if(ends[10]>=biggest214338){
            biggest214338=ends[10];
          }
          if(biggest214338 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread214339(tdone,ends);
          thread214340(tdone,ends);
          thread214341(tdone,ends);
          thread214342(tdone,ends);
          thread214343(tdone,ends);
          thread214344(tdone,ends);
          thread214345(tdone,ends);
          thread214346(tdone,ends);
          thread214347(tdone,ends);
          int biggest214348 = 0;
          if(ends[2]>=biggest214348){
            biggest214348=ends[2];
          }
          if(ends[3]>=biggest214348){
            biggest214348=ends[3];
          }
          if(ends[4]>=biggest214348){
            biggest214348=ends[4];
          }
          if(ends[5]>=biggest214348){
            biggest214348=ends[5];
          }
          if(ends[6]>=biggest214348){
            biggest214348=ends[6];
          }
          if(ends[7]>=biggest214348){
            biggest214348=ends[7];
          }
          if(ends[8]>=biggest214348){
            biggest214348=ends[8];
          }
          if(ends[9]>=biggest214348){
            biggest214348=ends[9];
          }
          if(ends[10]>=biggest214348){
            biggest214348=ends[10];
          }
          if(biggest214348 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest214348 == 0){
            S214327=0;
            active[1]=0;
            ends[1]=0;
            S214327=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          labelDone_in.gethook();
          bottleRecycled_in.gethook();
          orderProgress_o.gethook();
          orderRejected_o.gethook();
          loadOrder_o.gethook();
          labelBottle_o.gethook();
          bottleRejected_o.gethook();
          twinBL.gethook();
          twinCV.gethook();
          twinRT.gethook();
          twinF1.gethook();
          twinF2.gethook();
          twinLL.gethook();
          twinCP.gethook();
          twinLB.gethook();
          labellerStatus.gethook();
          recyclingStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      twinBL.setpreclear();
      twinCV.setpreclear();
      twinRT.setpreclear();
      twinF1.setpreclear();
      twinF2.setpreclear();
      twinLL.setpreclear();
      twinCP.setpreclear();
      twinLB.setpreclear();
      labellerStatus.setpreclear();
      recyclingStatus.setpreclear();
      modeBL.setpreclear();
      modeF1.setpreclear();
      modeF2.setpreclear();
      modeLL.setpreclear();
      modeCP.setpreclear();
      modeLB.setpreclear();
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
      enableLB.setpreclear();
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
      dummyint = twinBL.getStatus() ? twinBL.setprepresent() : twinBL.setpreclear();
      twinBL.setpreval(twinBL.getValue());
      twinBL.setClear();
      dummyint = twinCV.getStatus() ? twinCV.setprepresent() : twinCV.setpreclear();
      twinCV.setpreval(twinCV.getValue());
      twinCV.setClear();
      dummyint = twinRT.getStatus() ? twinRT.setprepresent() : twinRT.setpreclear();
      twinRT.setpreval(twinRT.getValue());
      twinRT.setClear();
      dummyint = twinF1.getStatus() ? twinF1.setprepresent() : twinF1.setpreclear();
      twinF1.setpreval(twinF1.getValue());
      twinF1.setClear();
      dummyint = twinF2.getStatus() ? twinF2.setprepresent() : twinF2.setpreclear();
      twinF2.setpreval(twinF2.getValue());
      twinF2.setClear();
      dummyint = twinLL.getStatus() ? twinLL.setprepresent() : twinLL.setpreclear();
      twinLL.setpreval(twinLL.getValue());
      twinLL.setClear();
      dummyint = twinCP.getStatus() ? twinCP.setprepresent() : twinCP.setpreclear();
      twinCP.setpreval(twinCP.getValue());
      twinCP.setClear();
      dummyint = twinLB.getStatus() ? twinLB.setprepresent() : twinLB.setpreclear();
      twinLB.setpreval(twinLB.getValue());
      twinLB.setClear();
      dummyint = labellerStatus.getStatus() ? labellerStatus.setprepresent() : labellerStatus.setpreclear();
      labellerStatus.setpreval(labellerStatus.getValue());
      labellerStatus.setClear();
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
      modeLB.sethook();
      modeLB.setClear();
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
      enableLB.sethook();
      enableLB.setClear();
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
      labelDone_in.sethook();
      bottleRecycled_in.sethook();
      orderProgress_o.sethook();
      orderRejected_o.sethook();
      loadOrder_o.sethook();
      labelBottle_o.sethook();
      bottleRejected_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        purchaseOrder_in.gethook();
        loadAck_in.gethook();
        bottleDone_in.gethook();
        labelDone_in.gethook();
        bottleRecycled_in.gethook();
        orderProgress_o.gethook();
        orderRejected_o.gethook();
        loadOrder_o.gethook();
        labelBottle_o.gethook();
        bottleRejected_o.gethook();
        twinBL.gethook();
        twinCV.gethook();
        twinRT.gethook();
        twinF1.gethook();
        twinF2.gethook();
        twinLL.gethook();
        twinCP.gethook();
        twinLB.gethook();
        labellerStatus.gethook();
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
