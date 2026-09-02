import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class StationStubs extends ClockDomain{
  public StationStubs(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public input_Channel startFiller1_in = new input_Channel();
  public input_Channel startFiller2_in = new input_Channel();
  public input_Channel startLid_in = new input_Channel();
  public input_Channel startCapper_in = new input_Channel();
  public output_Channel doneFiller1_o = new output_Channel();
  public output_Channel doneFiller2_o = new output_Channel();
  public output_Channel doneLid_o = new output_Channel();
  public output_Channel doneCapper_o = new output_Channel();
  private int FILL_thread_2;//sysj/stationStubs.sysj line: 27, column: 3
  private int b_thread_2;//sysj/stationStubs.sysj line: 28, column: 3
  private int t_thread_2;//sysj/stationStubs.sysj line: 29, column: 3
  private int FILL_thread_3;//sysj/stationStubs.sysj line: 45, column: 3
  private int b_thread_3;//sysj/stationStubs.sysj line: 46, column: 3
  private int t_thread_3;//sysj/stationStubs.sysj line: 47, column: 3
  private int LID_thread_4;//sysj/stationStubs.sysj line: 63, column: 3
  private int b_thread_4;//sysj/stationStubs.sysj line: 64, column: 3
  private int t_thread_4;//sysj/stationStubs.sysj line: 65, column: 3
  private int CAP_thread_5;//sysj/stationStubs.sysj line: 79, column: 3
  private int b_thread_5;//sysj/stationStubs.sysj line: 80, column: 3
  private int t_thread_5;//sysj/stationStubs.sysj line: 81, column: 3
  private int S13310 = 1;
  private int S10404 = 1;
  private int S9460 = 1;
  private int S9444 = 1;
  private int S9439 = 1;
  private int S9495 = 1;
  private int S9490 = 1;
  private int S11372 = 1;
  private int S10428 = 1;
  private int S10412 = 1;
  private int S10407 = 1;
  private int S10463 = 1;
  private int S10458 = 1;
  private int S12340 = 1;
  private int S11396 = 1;
  private int S11380 = 1;
  private int S11375 = 1;
  private int S11431 = 1;
  private int S11426 = 1;
  private int S13308 = 1;
  private int S12364 = 1;
  private int S12348 = 1;
  private int S12343 = 1;
  private int S12399 = 1;
  private int S12394 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread13320(int [] tdone, int [] ends){
        switch(S13308){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S12364){
          case 0 : 
            switch(S12348){
              case 0 : 
                if(!startCapper_in.isPartnerPresent() || startCapper_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 83, column: 4
                  startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                  S12348=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S12343){
                    case 0 : 
                      if(!startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                        startCapper_in.setACK(true);//sysj/stationStubs.sysj line: 83, column: 4
                        S12343=1;
                        if(startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                          startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                          ends[5]=2;
                          ;//sysj/stationStubs.sysj line: 83, column: 4
                          b_thread_5 = ((Integer)(startCapper_in.getVal() == null ? null : ((Integer)startCapper_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 84, column: 4
                          if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 85, column: 14
                            System.out.println("[ST] Capper: screwing cap on bottle " + b_thread_5 + ".");//sysj/stationStubs.sysj line: 85, column: 16
                          }
                          t_thread_5 = (b_thread_5 == 0) ? 0 : CAP_thread_5;//sysj/stationStubs.sysj line: 86, column: 4
                          S12364=1;
                          if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
                            t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            ends[5]=2;
                            ;//sysj/stationStubs.sysj line: 87, column: 4
                            if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
                              System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
                            }
                            S12364=2;
                            S12399=0;
                            if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                              doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                              S12399=1;
                              active[5]=1;
                              ends[5]=1;
                              tdone[5]=1;
                            }
                            else {
                              S12394=0;
                              if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                                doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                                S12394=1;
                                if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                                  doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                                  ends[5]=2;
                                  ;//sysj/stationStubs.sysj line: 89, column: 4
                                  S12364=3;
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
                      if(startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                        startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                        ends[5]=2;
                        ;//sysj/stationStubs.sysj line: 83, column: 4
                        b_thread_5 = ((Integer)(startCapper_in.getVal() == null ? null : ((Integer)startCapper_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 84, column: 4
                        if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 85, column: 14
                          System.out.println("[ST] Capper: screwing cap on bottle " + b_thread_5 + ".");//sysj/stationStubs.sysj line: 85, column: 16
                        }
                        t_thread_5 = (b_thread_5 == 0) ? 0 : CAP_thread_5;//sysj/stationStubs.sysj line: 86, column: 4
                        S12364=1;
                        if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
                          t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          ends[5]=2;
                          ;//sysj/stationStubs.sysj line: 87, column: 4
                          if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
                            System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
                          }
                          S12364=2;
                          S12399=0;
                          if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                            doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                            S12399=1;
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            S12394=0;
                            if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                              doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                              S12394=1;
                              if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                                doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                                ends[5]=2;
                                ;//sysj/stationStubs.sysj line: 89, column: 4
                                S12364=3;
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
                S12348=1;
                S12348=0;
                if(!startCapper_in.isPartnerPresent() || startCapper_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 83, column: 4
                  startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                  S12348=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S12343=0;
                  if(!startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                    startCapper_in.setACK(true);//sysj/stationStubs.sysj line: 83, column: 4
                    S12343=1;
                    if(startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                      startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                      ends[5]=2;
                      ;//sysj/stationStubs.sysj line: 83, column: 4
                      b_thread_5 = ((Integer)(startCapper_in.getVal() == null ? null : ((Integer)startCapper_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 84, column: 4
                      if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 85, column: 14
                        System.out.println("[ST] Capper: screwing cap on bottle " + b_thread_5 + ".");//sysj/stationStubs.sysj line: 85, column: 16
                      }
                      t_thread_5 = (b_thread_5 == 0) ? 0 : CAP_thread_5;//sysj/stationStubs.sysj line: 86, column: 4
                      S12364=1;
                      if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
                        t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        ends[5]=2;
                        ;//sysj/stationStubs.sysj line: 87, column: 4
                        if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
                          System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
                        }
                        S12364=2;
                        S12399=0;
                        if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                          doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                          S12399=1;
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          S12394=0;
                          if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                            doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                            S12394=1;
                            if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                              doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                              ends[5]=2;
                              ;//sysj/stationStubs.sysj line: 89, column: 4
                              S12364=3;
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
            if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
              t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              ends[5]=2;
              ;//sysj/stationStubs.sysj line: 87, column: 4
              if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
                System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
              }
              S12364=2;
              S12399=0;
              if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                S12399=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S12394=0;
                if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                  doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                  S12394=1;
                  if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                    doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                    ends[5]=2;
                    ;//sysj/stationStubs.sysj line: 89, column: 4
                    S12364=3;
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
            break;
          
          case 2 : 
            switch(S12399){
              case 0 : 
                if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                  doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                  S12399=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S12394){
                    case 0 : 
                      if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                        doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                        S12394=1;
                        if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                          doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                          ends[5]=2;
                          ;//sysj/stationStubs.sysj line: 89, column: 4
                          S12364=3;
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
                      if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                        doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                        ends[5]=2;
                        ;//sysj/stationStubs.sysj line: 89, column: 4
                        S12364=3;
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
                S12399=1;
                S12399=0;
                if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                  doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                  S12399=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S12394=0;
                  if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                    doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                    S12394=1;
                    if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                      doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                      ends[5]=2;
                      ;//sysj/stationStubs.sysj line: 89, column: 4
                      S12364=3;
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
          
          case 3 : 
            S12364=3;
            S12364=0;
            S12348=0;
            if(!startCapper_in.isPartnerPresent() || startCapper_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 83, column: 4
              startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
              S12348=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S12343=0;
              if(!startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                startCapper_in.setACK(true);//sysj/stationStubs.sysj line: 83, column: 4
                S12343=1;
                if(startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
                  startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
                  ends[5]=2;
                  ;//sysj/stationStubs.sysj line: 83, column: 4
                  b_thread_5 = ((Integer)(startCapper_in.getVal() == null ? null : ((Integer)startCapper_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 84, column: 4
                  if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 85, column: 14
                    System.out.println("[ST] Capper: screwing cap on bottle " + b_thread_5 + ".");//sysj/stationStubs.sysj line: 85, column: 16
                  }
                  t_thread_5 = (b_thread_5 == 0) ? 0 : CAP_thread_5;//sysj/stationStubs.sysj line: 86, column: 4
                  S12364=1;
                  if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
                    t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    ends[5]=2;
                    ;//sysj/stationStubs.sysj line: 87, column: 4
                    if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
                      System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
                    }
                    S12364=2;
                    S12399=0;
                    if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
                      doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                      S12399=1;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      S12394=0;
                      if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                        doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                        S12394=1;
                        if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                          doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                          ends[5]=2;
                          ;//sysj/stationStubs.sysj line: 89, column: 4
                          S12364=3;
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

  public void thread13319(int [] tdone, int [] ends){
        switch(S12340){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S11396){
          case 0 : 
            switch(S11380){
              case 0 : 
                if(!startLid_in.isPartnerPresent() || startLid_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 67, column: 4
                  startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                  S11380=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S11375){
                    case 0 : 
                      if(!startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                        startLid_in.setACK(true);//sysj/stationStubs.sysj line: 67, column: 4
                        S11375=1;
                        if(startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                          startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                          ends[4]=2;
                          ;//sysj/stationStubs.sysj line: 67, column: 4
                          b_thread_4 = ((Integer)(startLid_in.getVal() == null ? null : ((Integer)startLid_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 68, column: 4
                          if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 69, column: 14
                            System.out.println("[ST] Lid loader: placing lid on bottle " + b_thread_4 + ".");//sysj/stationStubs.sysj line: 69, column: 16
                          }
                          t_thread_4 = (b_thread_4 == 0) ? 0 : LID_thread_4;//sysj/stationStubs.sysj line: 70, column: 4
                          S11396=1;
                          if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
                            t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            ends[4]=2;
                            ;//sysj/stationStubs.sysj line: 71, column: 4
                            if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
                              System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
                            }
                            S11396=2;
                            S11431=0;
                            if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                              doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                              S11431=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S11426=0;
                              if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                                doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                                S11426=1;
                                if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                                  doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                                  ends[4]=2;
                                  ;//sysj/stationStubs.sysj line: 73, column: 4
                                  S11396=3;
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
                      if(startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                        startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                        ends[4]=2;
                        ;//sysj/stationStubs.sysj line: 67, column: 4
                        b_thread_4 = ((Integer)(startLid_in.getVal() == null ? null : ((Integer)startLid_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 68, column: 4
                        if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 69, column: 14
                          System.out.println("[ST] Lid loader: placing lid on bottle " + b_thread_4 + ".");//sysj/stationStubs.sysj line: 69, column: 16
                        }
                        t_thread_4 = (b_thread_4 == 0) ? 0 : LID_thread_4;//sysj/stationStubs.sysj line: 70, column: 4
                        S11396=1;
                        if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
                          t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          ends[4]=2;
                          ;//sysj/stationStubs.sysj line: 71, column: 4
                          if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
                            System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
                          }
                          S11396=2;
                          S11431=0;
                          if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                            doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                            S11431=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S11426=0;
                            if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                              doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                              S11426=1;
                              if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                                doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                                ends[4]=2;
                                ;//sysj/stationStubs.sysj line: 73, column: 4
                                S11396=3;
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
                S11380=1;
                S11380=0;
                if(!startLid_in.isPartnerPresent() || startLid_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 67, column: 4
                  startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                  S11380=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S11375=0;
                  if(!startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                    startLid_in.setACK(true);//sysj/stationStubs.sysj line: 67, column: 4
                    S11375=1;
                    if(startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                      startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                      ends[4]=2;
                      ;//sysj/stationStubs.sysj line: 67, column: 4
                      b_thread_4 = ((Integer)(startLid_in.getVal() == null ? null : ((Integer)startLid_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 68, column: 4
                      if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 69, column: 14
                        System.out.println("[ST] Lid loader: placing lid on bottle " + b_thread_4 + ".");//sysj/stationStubs.sysj line: 69, column: 16
                      }
                      t_thread_4 = (b_thread_4 == 0) ? 0 : LID_thread_4;//sysj/stationStubs.sysj line: 70, column: 4
                      S11396=1;
                      if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
                        t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        ends[4]=2;
                        ;//sysj/stationStubs.sysj line: 71, column: 4
                        if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
                          System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
                        }
                        S11396=2;
                        S11431=0;
                        if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                          doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                          S11431=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S11426=0;
                          if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                            doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                            S11426=1;
                            if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                              doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                              ends[4]=2;
                              ;//sysj/stationStubs.sysj line: 73, column: 4
                              S11396=3;
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
            if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
              t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj/stationStubs.sysj line: 71, column: 4
              if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
                System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
              }
              S11396=2;
              S11431=0;
              if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                S11431=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S11426=0;
                if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                  doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                  S11426=1;
                  if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                    doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                    ends[4]=2;
                    ;//sysj/stationStubs.sysj line: 73, column: 4
                    S11396=3;
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
            break;
          
          case 2 : 
            switch(S11431){
              case 0 : 
                if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                  doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                  S11431=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S11426){
                    case 0 : 
                      if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                        doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                        S11426=1;
                        if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                          doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                          ends[4]=2;
                          ;//sysj/stationStubs.sysj line: 73, column: 4
                          S11396=3;
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
                      if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                        doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                        ends[4]=2;
                        ;//sysj/stationStubs.sysj line: 73, column: 4
                        S11396=3;
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
                S11431=1;
                S11431=0;
                if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                  doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                  S11431=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S11426=0;
                  if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                    doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                    S11426=1;
                    if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                      doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                      ends[4]=2;
                      ;//sysj/stationStubs.sysj line: 73, column: 4
                      S11396=3;
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
          
          case 3 : 
            S11396=3;
            S11396=0;
            S11380=0;
            if(!startLid_in.isPartnerPresent() || startLid_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 67, column: 4
              startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
              S11380=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S11375=0;
              if(!startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                startLid_in.setACK(true);//sysj/stationStubs.sysj line: 67, column: 4
                S11375=1;
                if(startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
                  startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
                  ends[4]=2;
                  ;//sysj/stationStubs.sysj line: 67, column: 4
                  b_thread_4 = ((Integer)(startLid_in.getVal() == null ? null : ((Integer)startLid_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 68, column: 4
                  if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 69, column: 14
                    System.out.println("[ST] Lid loader: placing lid on bottle " + b_thread_4 + ".");//sysj/stationStubs.sysj line: 69, column: 16
                  }
                  t_thread_4 = (b_thread_4 == 0) ? 0 : LID_thread_4;//sysj/stationStubs.sysj line: 70, column: 4
                  S11396=1;
                  if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
                    t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    ends[4]=2;
                    ;//sysj/stationStubs.sysj line: 71, column: 4
                    if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
                      System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
                    }
                    S11396=2;
                    S11431=0;
                    if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
                      doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                      S11431=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S11426=0;
                      if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                        doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                        S11426=1;
                        if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                          doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                          ends[4]=2;
                          ;//sysj/stationStubs.sysj line: 73, column: 4
                          S11396=3;
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

  public void thread13318(int [] tdone, int [] ends){
        switch(S11372){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S10428){
          case 0 : 
            switch(S10412){
              case 0 : 
                if(!startFiller2_in.isPartnerPresent() || startFiller2_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 49, column: 4
                  startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                  S10412=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S10407){
                    case 0 : 
                      if(!startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                        startFiller2_in.setACK(true);//sysj/stationStubs.sysj line: 49, column: 4
                        S10407=1;
                        if(startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                          startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                          ends[3]=2;
                          ;//sysj/stationStubs.sysj line: 49, column: 4
                          b_thread_3 = ((Integer)(startFiller2_in.getVal() == null ? null : ((Integer)startFiller2_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 50, column: 4
                          if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 51, column: 14
                            System.out.println("[ST] Filler 2: dispensing into bottle " + b_thread_3 + ".");//sysj/stationStubs.sysj line: 51, column: 16
                          }
                          t_thread_3 = (b_thread_3 == 0) ? 0 : FILL_thread_3;//sysj/stationStubs.sysj line: 54, column: 4
                          S10428=1;
                          if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
                            t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            ends[3]=2;
                            ;//sysj/stationStubs.sysj line: 55, column: 4
                            if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
                              System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
                            }
                            S10428=2;
                            S10463=0;
                            if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                              doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                              S10463=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S10458=0;
                              if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                                doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                                S10458=1;
                                if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                                  doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                                  ends[3]=2;
                                  ;//sysj/stationStubs.sysj line: 57, column: 4
                                  S10428=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                      if(startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                        startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                        ends[3]=2;
                        ;//sysj/stationStubs.sysj line: 49, column: 4
                        b_thread_3 = ((Integer)(startFiller2_in.getVal() == null ? null : ((Integer)startFiller2_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 50, column: 4
                        if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 51, column: 14
                          System.out.println("[ST] Filler 2: dispensing into bottle " + b_thread_3 + ".");//sysj/stationStubs.sysj line: 51, column: 16
                        }
                        t_thread_3 = (b_thread_3 == 0) ? 0 : FILL_thread_3;//sysj/stationStubs.sysj line: 54, column: 4
                        S10428=1;
                        if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
                          t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj/stationStubs.sysj line: 55, column: 4
                          if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
                            System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
                          }
                          S10428=2;
                          S10463=0;
                          if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                            doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                            S10463=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S10458=0;
                            if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                              doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                              S10458=1;
                              if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                                doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                                ends[3]=2;
                                ;//sysj/stationStubs.sysj line: 57, column: 4
                                S10428=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                S10412=1;
                S10412=0;
                if(!startFiller2_in.isPartnerPresent() || startFiller2_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 49, column: 4
                  startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                  S10412=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S10407=0;
                  if(!startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                    startFiller2_in.setACK(true);//sysj/stationStubs.sysj line: 49, column: 4
                    S10407=1;
                    if(startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                      startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                      ends[3]=2;
                      ;//sysj/stationStubs.sysj line: 49, column: 4
                      b_thread_3 = ((Integer)(startFiller2_in.getVal() == null ? null : ((Integer)startFiller2_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 50, column: 4
                      if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 51, column: 14
                        System.out.println("[ST] Filler 2: dispensing into bottle " + b_thread_3 + ".");//sysj/stationStubs.sysj line: 51, column: 16
                      }
                      t_thread_3 = (b_thread_3 == 0) ? 0 : FILL_thread_3;//sysj/stationStubs.sysj line: 54, column: 4
                      S10428=1;
                      if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
                        t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj/stationStubs.sysj line: 55, column: 4
                        if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
                          System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
                        }
                        S10428=2;
                        S10463=0;
                        if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                          doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                          S10463=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S10458=0;
                          if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                            doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                            S10458=1;
                            if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                              doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                              ends[3]=2;
                              ;//sysj/stationStubs.sysj line: 57, column: 4
                              S10428=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
            if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
              t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj/stationStubs.sysj line: 55, column: 4
              if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
                System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
              }
              S10428=2;
              S10463=0;
              if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                S10463=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S10458=0;
                if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                  doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                  S10458=1;
                  if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                    doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                    ends[3]=2;
                    ;//sysj/stationStubs.sysj line: 57, column: 4
                    S10428=3;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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
          
          case 2 : 
            switch(S10463){
              case 0 : 
                if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                  doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                  S10463=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S10458){
                    case 0 : 
                      if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                        doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                        S10458=1;
                        if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                          doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                          ends[3]=2;
                          ;//sysj/stationStubs.sysj line: 57, column: 4
                          S10428=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                      if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                        doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                        ends[3]=2;
                        ;//sysj/stationStubs.sysj line: 57, column: 4
                        S10428=3;
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
                S10463=1;
                S10463=0;
                if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                  doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                  S10463=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S10458=0;
                  if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                    doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                    S10458=1;
                    if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                      doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                      ends[3]=2;
                      ;//sysj/stationStubs.sysj line: 57, column: 4
                      S10428=3;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S10428=3;
            S10428=0;
            S10412=0;
            if(!startFiller2_in.isPartnerPresent() || startFiller2_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 49, column: 4
              startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
              S10412=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S10407=0;
              if(!startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                startFiller2_in.setACK(true);//sysj/stationStubs.sysj line: 49, column: 4
                S10407=1;
                if(startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
                  startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
                  ends[3]=2;
                  ;//sysj/stationStubs.sysj line: 49, column: 4
                  b_thread_3 = ((Integer)(startFiller2_in.getVal() == null ? null : ((Integer)startFiller2_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 50, column: 4
                  if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 51, column: 14
                    System.out.println("[ST] Filler 2: dispensing into bottle " + b_thread_3 + ".");//sysj/stationStubs.sysj line: 51, column: 16
                  }
                  t_thread_3 = (b_thread_3 == 0) ? 0 : FILL_thread_3;//sysj/stationStubs.sysj line: 54, column: 4
                  S10428=1;
                  if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
                    t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    ends[3]=2;
                    ;//sysj/stationStubs.sysj line: 55, column: 4
                    if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
                      System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
                    }
                    S10428=2;
                    S10463=0;
                    if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
                      doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                      S10463=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S10458=0;
                      if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                        doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                        S10458=1;
                        if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                          doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                          ends[3]=2;
                          ;//sysj/stationStubs.sysj line: 57, column: 4
                          S10428=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
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
      
    }
  }

  public void thread13317(int [] tdone, int [] ends){
        switch(S10404){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S9460){
          case 0 : 
            switch(S9444){
              case 0 : 
                if(!startFiller1_in.isPartnerPresent() || startFiller1_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 31, column: 4
                  startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                  S9444=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S9439){
                    case 0 : 
                      if(!startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                        startFiller1_in.setACK(true);//sysj/stationStubs.sysj line: 31, column: 4
                        S9439=1;
                        if(startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                          startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                          ends[2]=2;
                          ;//sysj/stationStubs.sysj line: 31, column: 4
                          b_thread_2 = ((Integer)(startFiller1_in.getVal() == null ? null : ((Integer)startFiller1_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 32, column: 4
                          if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 33, column: 14
                            System.out.println("[ST] Filler 1: dispensing into bottle " + b_thread_2 + ".");//sysj/stationStubs.sysj line: 33, column: 16
                          }
                          t_thread_2 = (b_thread_2 == 0) ? 0 : FILL_thread_2;//sysj/stationStubs.sysj line: 36, column: 4
                          S9460=1;
                          if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
                            t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj/stationStubs.sysj line: 37, column: 4
                            if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
                              System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
                            }
                            S9460=2;
                            S9495=0;
                            if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                              doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                              S9495=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S9490=0;
                              if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                                doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                                S9490=1;
                                if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                                  doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                                  ends[2]=2;
                                  ;//sysj/stationStubs.sysj line: 39, column: 4
                                  S9460=3;
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
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                        }
                        else {
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
                    
                    case 1 : 
                      if(startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                        startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                        ends[2]=2;
                        ;//sysj/stationStubs.sysj line: 31, column: 4
                        b_thread_2 = ((Integer)(startFiller1_in.getVal() == null ? null : ((Integer)startFiller1_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 32, column: 4
                        if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 33, column: 14
                          System.out.println("[ST] Filler 1: dispensing into bottle " + b_thread_2 + ".");//sysj/stationStubs.sysj line: 33, column: 16
                        }
                        t_thread_2 = (b_thread_2 == 0) ? 0 : FILL_thread_2;//sysj/stationStubs.sysj line: 36, column: 4
                        S9460=1;
                        if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
                          t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          ends[2]=2;
                          ;//sysj/stationStubs.sysj line: 37, column: 4
                          if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
                            System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
                          }
                          S9460=2;
                          S9495=0;
                          if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                            doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                            S9495=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S9490=0;
                            if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                              doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                              S9490=1;
                              if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                                doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                                ends[2]=2;
                                ;//sysj/stationStubs.sysj line: 39, column: 4
                                S9460=3;
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
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
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
                break;
              
              case 1 : 
                S9444=1;
                S9444=0;
                if(!startFiller1_in.isPartnerPresent() || startFiller1_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 31, column: 4
                  startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                  S9444=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S9439=0;
                  if(!startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                    startFiller1_in.setACK(true);//sysj/stationStubs.sysj line: 31, column: 4
                    S9439=1;
                    if(startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                      startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                      ends[2]=2;
                      ;//sysj/stationStubs.sysj line: 31, column: 4
                      b_thread_2 = ((Integer)(startFiller1_in.getVal() == null ? null : ((Integer)startFiller1_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 32, column: 4
                      if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 33, column: 14
                        System.out.println("[ST] Filler 1: dispensing into bottle " + b_thread_2 + ".");//sysj/stationStubs.sysj line: 33, column: 16
                      }
                      t_thread_2 = (b_thread_2 == 0) ? 0 : FILL_thread_2;//sysj/stationStubs.sysj line: 36, column: 4
                      S9460=1;
                      if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
                        t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        ends[2]=2;
                        ;//sysj/stationStubs.sysj line: 37, column: 4
                        if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
                          System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
                        }
                        S9460=2;
                        S9495=0;
                        if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                          doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                          S9495=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S9490=0;
                          if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                            doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                            S9490=1;
                            if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                              doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                              ends[2]=2;
                              ;//sysj/stationStubs.sysj line: 39, column: 4
                              S9460=3;
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
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                    }
                    else {
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
                break;
              
            }
            break;
          
          case 1 : 
            if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
              t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj/stationStubs.sysj line: 37, column: 4
              if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
                System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
              }
              S9460=2;
              S9495=0;
              if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                S9495=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S9490=0;
                if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                  doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                  S9490=1;
                  if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                    doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                    ends[2]=2;
                    ;//sysj/stationStubs.sysj line: 39, column: 4
                    S9460=3;
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
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
            }
            break;
          
          case 2 : 
            switch(S9495){
              case 0 : 
                if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                  doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                  S9495=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S9490){
                    case 0 : 
                      if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                        doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                        S9490=1;
                        if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                          doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                          ends[2]=2;
                          ;//sysj/stationStubs.sysj line: 39, column: 4
                          S9460=3;
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
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                        doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                        ends[2]=2;
                        ;//sysj/stationStubs.sysj line: 39, column: 4
                        S9460=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S9495=1;
                S9495=0;
                if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                  doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                  S9495=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S9490=0;
                  if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                    doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                    S9490=1;
                    if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                      doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                      ends[2]=2;
                      ;//sysj/stationStubs.sysj line: 39, column: 4
                      S9460=3;
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
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 3 : 
            S9460=3;
            S9460=0;
            S9444=0;
            if(!startFiller1_in.isPartnerPresent() || startFiller1_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 31, column: 4
              startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
              S9444=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S9439=0;
              if(!startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                startFiller1_in.setACK(true);//sysj/stationStubs.sysj line: 31, column: 4
                S9439=1;
                if(startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
                  startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
                  ends[2]=2;
                  ;//sysj/stationStubs.sysj line: 31, column: 4
                  b_thread_2 = ((Integer)(startFiller1_in.getVal() == null ? null : ((Integer)startFiller1_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 32, column: 4
                  if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 33, column: 14
                    System.out.println("[ST] Filler 1: dispensing into bottle " + b_thread_2 + ".");//sysj/stationStubs.sysj line: 33, column: 16
                  }
                  t_thread_2 = (b_thread_2 == 0) ? 0 : FILL_thread_2;//sysj/stationStubs.sysj line: 36, column: 4
                  S9460=1;
                  if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
                    t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/stationStubs.sysj line: 37, column: 4
                    if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
                      System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
                    }
                    S9460=2;
                    S9495=0;
                    if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
                      doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                      S9495=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S9490=0;
                      if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                        doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                        S9490=1;
                        if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                          doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                          ends[2]=2;
                          ;//sysj/stationStubs.sysj line: 39, column: 4
                          S9460=3;
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
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
                else {
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
            break;
          
        }
        break;
      
    }
  }

  public void thread13315(int [] tdone, int [] ends){
        S13308=1;
    CAP_thread_5 = 12;//sysj/stationStubs.sysj line: 79, column: 3
    b_thread_5 = 0;//sysj/stationStubs.sysj line: 80, column: 3
    t_thread_5 = 0;//sysj/stationStubs.sysj line: 81, column: 3
    S12364=0;
    S12348=0;
    if(!startCapper_in.isPartnerPresent() || startCapper_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 83, column: 4
      startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
      S12348=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S12343=0;
      if(!startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
        startCapper_in.setACK(true);//sysj/stationStubs.sysj line: 83, column: 4
        S12343=1;
        if(startCapper_in.isREQ()){//sysj/stationStubs.sysj line: 83, column: 4
          startCapper_in.setACK(false);//sysj/stationStubs.sysj line: 83, column: 4
          ends[5]=2;
          ;//sysj/stationStubs.sysj line: 83, column: 4
          b_thread_5 = ((Integer)(startCapper_in.getVal() == null ? null : ((Integer)startCapper_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 84, column: 4
          if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 85, column: 14
            System.out.println("[ST] Capper: screwing cap on bottle " + b_thread_5 + ".");//sysj/stationStubs.sysj line: 85, column: 16
          }
          t_thread_5 = (b_thread_5 == 0) ? 0 : CAP_thread_5;//sysj/stationStubs.sysj line: 86, column: 4
          S12364=1;
          if(t_thread_5 > 0){//sysj/stationStubs.sysj line: 87, column: 10
            t_thread_5 = t_thread_5 - 1;//sysj/stationStubs.sysj line: 87, column: 18
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            ends[5]=2;
            ;//sysj/stationStubs.sysj line: 87, column: 4
            if(b_thread_5 != 0) {//sysj/stationStubs.sysj line: 88, column: 14
              System.out.println("[ST] Capper: bottle " + b_thread_5 + " complete.");//sysj/stationStubs.sysj line: 88, column: 16
            }
            S12364=2;
            S12399=0;
            if(!doneCapper_o.isPartnerPresent() || doneCapper_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 89, column: 4
              doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
              S12399=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S12394=0;
              if(doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                doneCapper_o.setVal(b_thread_5);//sysj/stationStubs.sysj line: 89, column: 4
                S12394=1;
                if(!doneCapper_o.isACK()){//sysj/stationStubs.sysj line: 89, column: 4
                  doneCapper_o.setREQ(false);//sysj/stationStubs.sysj line: 89, column: 4
                  ends[5]=2;
                  ;//sysj/stationStubs.sysj line: 89, column: 4
                  S12364=3;
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

  public void thread13314(int [] tdone, int [] ends){
        S12340=1;
    LID_thread_4 = 4;//sysj/stationStubs.sysj line: 63, column: 3
    b_thread_4 = 0;//sysj/stationStubs.sysj line: 64, column: 3
    t_thread_4 = 0;//sysj/stationStubs.sysj line: 65, column: 3
    S11396=0;
    S11380=0;
    if(!startLid_in.isPartnerPresent() || startLid_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 67, column: 4
      startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
      S11380=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S11375=0;
      if(!startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
        startLid_in.setACK(true);//sysj/stationStubs.sysj line: 67, column: 4
        S11375=1;
        if(startLid_in.isREQ()){//sysj/stationStubs.sysj line: 67, column: 4
          startLid_in.setACK(false);//sysj/stationStubs.sysj line: 67, column: 4
          ends[4]=2;
          ;//sysj/stationStubs.sysj line: 67, column: 4
          b_thread_4 = ((Integer)(startLid_in.getVal() == null ? null : ((Integer)startLid_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 68, column: 4
          if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 69, column: 14
            System.out.println("[ST] Lid loader: placing lid on bottle " + b_thread_4 + ".");//sysj/stationStubs.sysj line: 69, column: 16
          }
          t_thread_4 = (b_thread_4 == 0) ? 0 : LID_thread_4;//sysj/stationStubs.sysj line: 70, column: 4
          S11396=1;
          if(t_thread_4 > 0){//sysj/stationStubs.sysj line: 71, column: 10
            t_thread_4 = t_thread_4 - 1;//sysj/stationStubs.sysj line: 71, column: 18
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            ends[4]=2;
            ;//sysj/stationStubs.sysj line: 71, column: 4
            if(b_thread_4 != 0) {//sysj/stationStubs.sysj line: 72, column: 14
              System.out.println("[ST] Lid loader: bottle " + b_thread_4 + " complete.");//sysj/stationStubs.sysj line: 72, column: 16
            }
            S11396=2;
            S11431=0;
            if(!doneLid_o.isPartnerPresent() || doneLid_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 73, column: 4
              doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
              S11431=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S11426=0;
              if(doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                doneLid_o.setVal(b_thread_4);//sysj/stationStubs.sysj line: 73, column: 4
                S11426=1;
                if(!doneLid_o.isACK()){//sysj/stationStubs.sysj line: 73, column: 4
                  doneLid_o.setREQ(false);//sysj/stationStubs.sysj line: 73, column: 4
                  ends[4]=2;
                  ;//sysj/stationStubs.sysj line: 73, column: 4
                  S11396=3;
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

  public void thread13313(int [] tdone, int [] ends){
        S11372=1;
    FILL_thread_3 = 8;//sysj/stationStubs.sysj line: 45, column: 3
    b_thread_3 = 0;//sysj/stationStubs.sysj line: 46, column: 3
    t_thread_3 = 0;//sysj/stationStubs.sysj line: 47, column: 3
    S10428=0;
    S10412=0;
    if(!startFiller2_in.isPartnerPresent() || startFiller2_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 49, column: 4
      startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
      S10412=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S10407=0;
      if(!startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
        startFiller2_in.setACK(true);//sysj/stationStubs.sysj line: 49, column: 4
        S10407=1;
        if(startFiller2_in.isREQ()){//sysj/stationStubs.sysj line: 49, column: 4
          startFiller2_in.setACK(false);//sysj/stationStubs.sysj line: 49, column: 4
          ends[3]=2;
          ;//sysj/stationStubs.sysj line: 49, column: 4
          b_thread_3 = ((Integer)(startFiller2_in.getVal() == null ? null : ((Integer)startFiller2_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 50, column: 4
          if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 51, column: 14
            System.out.println("[ST] Filler 2: dispensing into bottle " + b_thread_3 + ".");//sysj/stationStubs.sysj line: 51, column: 16
          }
          t_thread_3 = (b_thread_3 == 0) ? 0 : FILL_thread_3;//sysj/stationStubs.sysj line: 54, column: 4
          S10428=1;
          if(t_thread_3 > 0){//sysj/stationStubs.sysj line: 55, column: 10
            t_thread_3 = t_thread_3 - 1;//sysj/stationStubs.sysj line: 55, column: 18
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            ends[3]=2;
            ;//sysj/stationStubs.sysj line: 55, column: 4
            if(b_thread_3 != 0) {//sysj/stationStubs.sysj line: 56, column: 14
              System.out.println("[ST] Filler 2: bottle " + b_thread_3 + " complete.");//sysj/stationStubs.sysj line: 56, column: 16
            }
            S10428=2;
            S10463=0;
            if(!doneFiller2_o.isPartnerPresent() || doneFiller2_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 57, column: 4
              doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
              S10463=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S10458=0;
              if(doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                doneFiller2_o.setVal(b_thread_3);//sysj/stationStubs.sysj line: 57, column: 4
                S10458=1;
                if(!doneFiller2_o.isACK()){//sysj/stationStubs.sysj line: 57, column: 4
                  doneFiller2_o.setREQ(false);//sysj/stationStubs.sysj line: 57, column: 4
                  ends[3]=2;
                  ;//sysj/stationStubs.sysj line: 57, column: 4
                  S10428=3;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
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

  public void thread13312(int [] tdone, int [] ends){
        S10404=1;
    FILL_thread_2 = 6;//sysj/stationStubs.sysj line: 27, column: 3
    b_thread_2 = 0;//sysj/stationStubs.sysj line: 28, column: 3
    t_thread_2 = 0;//sysj/stationStubs.sysj line: 29, column: 3
    S9460=0;
    S9444=0;
    if(!startFiller1_in.isPartnerPresent() || startFiller1_in.isPartnerPreempted()){//sysj/stationStubs.sysj line: 31, column: 4
      startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
      S9444=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      S9439=0;
      if(!startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
        startFiller1_in.setACK(true);//sysj/stationStubs.sysj line: 31, column: 4
        S9439=1;
        if(startFiller1_in.isREQ()){//sysj/stationStubs.sysj line: 31, column: 4
          startFiller1_in.setACK(false);//sysj/stationStubs.sysj line: 31, column: 4
          ends[2]=2;
          ;//sysj/stationStubs.sysj line: 31, column: 4
          b_thread_2 = ((Integer)(startFiller1_in.getVal() == null ? null : ((Integer)startFiller1_in.getVal()))).intValue();//sysj/stationStubs.sysj line: 32, column: 4
          if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 33, column: 14
            System.out.println("[ST] Filler 1: dispensing into bottle " + b_thread_2 + ".");//sysj/stationStubs.sysj line: 33, column: 16
          }
          t_thread_2 = (b_thread_2 == 0) ? 0 : FILL_thread_2;//sysj/stationStubs.sysj line: 36, column: 4
          S9460=1;
          if(t_thread_2 > 0){//sysj/stationStubs.sysj line: 37, column: 10
            t_thread_2 = t_thread_2 - 1;//sysj/stationStubs.sysj line: 37, column: 18
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj/stationStubs.sysj line: 37, column: 4
            if(b_thread_2 != 0) {//sysj/stationStubs.sysj line: 38, column: 14
              System.out.println("[ST] Filler 1: bottle " + b_thread_2 + " complete.");//sysj/stationStubs.sysj line: 38, column: 16
            }
            S9460=2;
            S9495=0;
            if(!doneFiller1_o.isPartnerPresent() || doneFiller1_o.isPartnerPreempted()){//sysj/stationStubs.sysj line: 39, column: 4
              doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
              S9495=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S9490=0;
              if(doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                doneFiller1_o.setVal(b_thread_2);//sysj/stationStubs.sysj line: 39, column: 4
                S9490=1;
                if(!doneFiller1_o.isACK()){//sysj/stationStubs.sysj line: 39, column: 4
                  doneFiller1_o.setREQ(false);//sysj/stationStubs.sysj line: 39, column: 4
                  ends[2]=2;
                  ;//sysj/stationStubs.sysj line: 39, column: 4
                  S9460=3;
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
              else {
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
          }
        }
        else {
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
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S13310){
        case 0 : 
          S13310=0;
          break RUN;
        
        case 1 : 
          S13310=2;
          S13310=2;
          thread13312(tdone,ends);
          thread13313(tdone,ends);
          thread13314(tdone,ends);
          thread13315(tdone,ends);
          int biggest13316 = 0;
          if(ends[2]>=biggest13316){
            biggest13316=ends[2];
          }
          if(ends[3]>=biggest13316){
            biggest13316=ends[3];
          }
          if(ends[4]>=biggest13316){
            biggest13316=ends[4];
          }
          if(ends[5]>=biggest13316){
            biggest13316=ends[5];
          }
          if(biggest13316 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread13317(tdone,ends);
          thread13318(tdone,ends);
          thread13319(tdone,ends);
          thread13320(tdone,ends);
          int biggest13321 = 0;
          if(ends[2]>=biggest13321){
            biggest13321=ends[2];
          }
          if(ends[3]>=biggest13321){
            biggest13321=ends[3];
          }
          if(ends[4]>=biggest13321){
            biggest13321=ends[4];
          }
          if(ends[5]>=biggest13321){
            biggest13321=ends[5];
          }
          if(biggest13321 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest13321 == 0){
            S13310=0;
            active[1]=0;
            ends[1]=0;
            S13310=0;
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
          startFiller1_in.gethook();
          startFiller2_in.gethook();
          startLid_in.gethook();
          startCapper_in.gethook();
          doneFiller1_o.gethook();
          doneFiller2_o.gethook();
          doneLid_o.gethook();
          doneCapper_o.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      startFiller1_in.sethook();
      startFiller2_in.sethook();
      startLid_in.sethook();
      startCapper_in.sethook();
      doneFiller1_o.sethook();
      doneFiller2_o.sethook();
      doneLid_o.sethook();
      doneCapper_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        startFiller1_in.gethook();
        startFiller2_in.gethook();
        startLid_in.gethook();
        startCapper_in.gethook();
        doneFiller1_o.gethook();
        doneFiller2_o.gethook();
        doneLid_o.gethook();
        doneCapper_o.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
