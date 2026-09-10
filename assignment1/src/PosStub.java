import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class PosStub extends ClockDomain{
  public PosStub(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public input_Channel completed_in = new input_Channel();
  public input_Channel recycled_in = new input_Channel();
  public output_Channel order_o = new output_Channel();
  private int i_thread_2;//sysj\posStub.sysj line: 25, column: 3
  private WorkpieceTwin w_thread_2;//sysj\posStub.sysj line: 26, column: 3
  private int n_thread_3;//sysj\posStub.sysj line: 51, column: 3
  private int n_thread_4;//sysj\posStub.sysj line: 61, column: 3
  private int settle_thread_2;//sysj\posStub.sysj line: 44, column: 3
  private int S119357 = 1;
  private int S119075 = 1;
  private int S118775 = 1;
  private int S118776 = 1;
  private int S118783 = 1;
  private int S118778 = 1;
  private int S119215 = 1;
  private int S119098 = 1;
  private int S119082 = 1;
  private int S119077 = 1;
  private int S119355 = 1;
  private int S119238 = 1;
  private int S119222 = 1;
  private int S119217 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread119365(int [] tdone, int [] ends){
        switch(S119355){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S119238){
          case 0 : 
            switch(S119222){
              case 0 : 
                if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 63, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                  S119222=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S119217){
                    case 0 : 
                      if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                        recycled_in.setACK(true);//sysj\posStub.sysj line: 63, column: 4
                        S119217=1;
                        if(recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                          recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                          ends[4]=2;
                          ;//sysj\posStub.sysj line: 63, column: 4
                          n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 64, column: 4
                          System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 65, column: 4
                          S119238=1;
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
                      if(recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                        recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                        ends[4]=2;
                        ;//sysj\posStub.sysj line: 63, column: 4
                        n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 64, column: 4
                        System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 65, column: 4
                        S119238=1;
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
                S119222=1;
                S119222=0;
                if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 63, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                  S119222=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S119217=0;
                  if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                    recycled_in.setACK(true);//sysj\posStub.sysj line: 63, column: 4
                    S119217=1;
                    if(recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                      recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                      ends[4]=2;
                      ;//sysj\posStub.sysj line: 63, column: 4
                      n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 64, column: 4
                      System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 65, column: 4
                      S119238=1;
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
          
          case 1 : 
            S119238=1;
            S119238=0;
            S119222=0;
            if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 63, column: 4
              recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
              S119222=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S119217=0;
              if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                recycled_in.setACK(true);//sysj\posStub.sysj line: 63, column: 4
                S119217=1;
                if(recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
                  ends[4]=2;
                  ;//sysj\posStub.sysj line: 63, column: 4
                  n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 64, column: 4
                  System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 65, column: 4
                  S119238=1;
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
      
    }
  }

  public void thread119364(int [] tdone, int [] ends){
        switch(S119215){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S119098){
          case 0 : 
            switch(S119082){
              case 0 : 
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 53, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                  S119082=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S119077){
                    case 0 : 
                      if(!completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                        completed_in.setACK(true);//sysj\posStub.sysj line: 53, column: 4
                        S119077=1;
                        if(completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                          completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                          ends[3]=2;
                          ;//sysj\posStub.sysj line: 53, column: 4
                          n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 54, column: 4
                          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 55, column: 4
                          S119098=1;
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
                      if(completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                        completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                        ends[3]=2;
                        ;//sysj\posStub.sysj line: 53, column: 4
                        n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 54, column: 4
                        System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 55, column: 4
                        S119098=1;
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
                S119082=1;
                S119082=0;
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 53, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                  S119082=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S119077=0;
                  if(!completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                    completed_in.setACK(true);//sysj\posStub.sysj line: 53, column: 4
                    S119077=1;
                    if(completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                      completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                      ends[3]=2;
                      ;//sysj\posStub.sysj line: 53, column: 4
                      n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 54, column: 4
                      System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 55, column: 4
                      S119098=1;
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
          
          case 1 : 
            S119098=1;
            S119098=0;
            S119082=0;
            if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 53, column: 4
              completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
              S119082=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S119077=0;
              if(!completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                completed_in.setACK(true);//sysj\posStub.sysj line: 53, column: 4
                S119077=1;
                if(completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
                  ends[3]=2;
                  ;//sysj\posStub.sysj line: 53, column: 4
                  n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 54, column: 4
                  System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 55, column: 4
                  S119098=1;
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

  public void thread119363(int [] tdone, int [] ends){
        switch(S119075){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S118775){
          case 0 : 
            S118775=0;
            S118775=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            S118775=1;
            S118775=2;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            S118775=2;
            S118775=3;
            if(i_thread_2 < OrderBook.count()){//sysj\posStub.sysj line: 30, column: 9
              w_thread_2 = OrderBook.order(i_thread_2);//sysj\posStub.sysj line: 31, column: 4
              System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + (w_thread_2.isRejected() ? " [fault armed: " + w_thread_2.defect() + "]" : "") + ".");//sysj\posStub.sysj line: 32, column: 4
              S118776=0;
              S118783=0;
              if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                S118783=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S118778=0;
                if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                  order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                  S118778=1;
                  if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                    order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                    ends[2]=2;
                    ;//sysj\posStub.sysj line: 34, column: 4
                    i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                    S118776=1;
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
            else {
              order_o.setPreempted();//sysj\posStub.sysj line: 30, column: 3
              ends[2]=2;
              ;//sysj\posStub.sysj line: 30, column: 3
              System.out.println("[POS] All orders placed.");//sysj\posStub.sysj line: 39, column: 3
              settle_thread_2 = 900;//sysj\posStub.sysj line: 44, column: 3
              S118775=4;
              if(settle_thread_2 > 0){//sysj\posStub.sysj line: 45, column: 9
                settle_thread_2 = settle_thread_2 - 1;//sysj\posStub.sysj line: 45, column: 22
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                ends[2]=2;
                ;//sysj\posStub.sysj line: 45, column: 3
                TwinAudit.report();//sysj\posStub.sysj line: 46, column: 3
                S118775=5;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            break;
          
          case 3 : 
            switch(S118776){
              case 0 : 
                switch(S118783){
                  case 0 : 
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                      S118783=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S118778){
                        case 0 : 
                          if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                            order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                            S118778=1;
                            if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                              order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                              ends[2]=2;
                              ;//sysj\posStub.sysj line: 34, column: 4
                              i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                              S118776=1;
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
                          if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                            order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                            ends[2]=2;
                            ;//sysj\posStub.sysj line: 34, column: 4
                            i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                            S118776=1;
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
                    S118783=1;
                    S118783=0;
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                      S118783=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S118778=0;
                      if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                        order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                        S118778=1;
                        if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                          order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                          ends[2]=2;
                          ;//sysj\posStub.sysj line: 34, column: 4
                          i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                          S118776=1;
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
              
              case 1 : 
                S118776=1;
                if(i_thread_2 < OrderBook.count()){//sysj\posStub.sysj line: 30, column: 9
                  w_thread_2 = OrderBook.order(i_thread_2);//sysj\posStub.sysj line: 31, column: 4
                  System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + (w_thread_2.isRejected() ? " [fault armed: " + w_thread_2.defect() + "]" : "") + ".");//sysj\posStub.sysj line: 32, column: 4
                  S118776=0;
                  S118783=0;
                  if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                    order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                    S118783=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S118778=0;
                    if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                      S118778=1;
                      if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                        order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                        ends[2]=2;
                        ;//sysj\posStub.sysj line: 34, column: 4
                        i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                        S118776=1;
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
                else {
                  order_o.setPreempted();//sysj\posStub.sysj line: 30, column: 3
                  ends[2]=2;
                  ;//sysj\posStub.sysj line: 30, column: 3
                  System.out.println("[POS] All orders placed.");//sysj\posStub.sysj line: 39, column: 3
                  settle_thread_2 = 900;//sysj\posStub.sysj line: 44, column: 3
                  S118775=4;
                  if(settle_thread_2 > 0){//sysj\posStub.sysj line: 45, column: 9
                    settle_thread_2 = settle_thread_2 - 1;//sysj\posStub.sysj line: 45, column: 22
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\posStub.sysj line: 45, column: 3
                    TwinAudit.report();//sysj\posStub.sysj line: 46, column: 3
                    S118775=5;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 4 : 
            if(settle_thread_2 > 0){//sysj\posStub.sysj line: 45, column: 9
              settle_thread_2 = settle_thread_2 - 1;//sysj\posStub.sysj line: 45, column: 22
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\posStub.sysj line: 45, column: 3
              TwinAudit.report();//sysj\posStub.sysj line: 46, column: 3
              S118775=5;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 5 : 
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread119361(int [] tdone, int [] ends){
        S119355=1;
    n_thread_4 = 0;//sysj\posStub.sysj line: 61, column: 3
    S119238=0;
    S119222=0;
    if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 63, column: 4
      recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
      S119222=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S119217=0;
      if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
        recycled_in.setACK(true);//sysj\posStub.sysj line: 63, column: 4
        S119217=1;
        if(recycled_in.isREQ()){//sysj\posStub.sysj line: 63, column: 4
          recycled_in.setACK(false);//sysj\posStub.sysj line: 63, column: 4
          ends[4]=2;
          ;//sysj\posStub.sysj line: 63, column: 4
          n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 64, column: 4
          System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 65, column: 4
          S119238=1;
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

  public void thread119360(int [] tdone, int [] ends){
        S119215=1;
    n_thread_3 = 0;//sysj\posStub.sysj line: 51, column: 3
    S119098=0;
    S119082=0;
    if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 53, column: 4
      completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
      S119082=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S119077=0;
      if(!completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
        completed_in.setACK(true);//sysj\posStub.sysj line: 53, column: 4
        S119077=1;
        if(completed_in.isREQ()){//sysj\posStub.sysj line: 53, column: 4
          completed_in.setACK(false);//sysj\posStub.sysj line: 53, column: 4
          ends[3]=2;
          ;//sysj\posStub.sysj line: 53, column: 4
          n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 54, column: 4
          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 55, column: 4
          S119098=1;
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

  public void thread119359(int [] tdone, int [] ends){
        S119075=1;
    i_thread_2 = 0;//sysj\posStub.sysj line: 25, column: 3
    w_thread_2 = null;//sysj\posStub.sysj line: 26, column: 3
    S118775=0;
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
      switch(S119357){
        case 0 : 
          S119357=0;
          break RUN;
        
        case 1 : 
          S119357=2;
          S119357=2;
          thread119359(tdone,ends);
          thread119360(tdone,ends);
          thread119361(tdone,ends);
          int biggest119362 = 0;
          if(ends[2]>=biggest119362){
            biggest119362=ends[2];
          }
          if(ends[3]>=biggest119362){
            biggest119362=ends[3];
          }
          if(ends[4]>=biggest119362){
            biggest119362=ends[4];
          }
          if(biggest119362 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread119363(tdone,ends);
          thread119364(tdone,ends);
          thread119365(tdone,ends);
          int biggest119366 = 0;
          if(ends[2]>=biggest119366){
            biggest119366=ends[2];
          }
          if(ends[3]>=biggest119366){
            biggest119366=ends[3];
          }
          if(ends[4]>=biggest119366){
            biggest119366=ends[4];
          }
          if(biggest119366 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest119366 == 0){
            S119357=0;
            active[1]=0;
            ends[1]=0;
            S119357=0;
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
          completed_in.gethook();
          recycled_in.gethook();
          order_o.gethook();
          df = true;
        }
        runClockDomain();
      }
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      completed_in.sethook();
      recycled_in.sethook();
      order_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        completed_in.gethook();
        recycled_in.gethook();
        order_o.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
