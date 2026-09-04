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
  private Workpiece w_thread_2;//sysj\posStub.sysj line: 26, column: 3
  private int n_thread_3;//sysj\posStub.sysj line: 44, column: 3
  private int n_thread_4;//sysj\posStub.sysj line: 54, column: 3
  private int S81493 = 1;
  private int S81211 = 1;
  private int S80932 = 1;
  private int S80933 = 1;
  private int S80940 = 1;
  private int S80935 = 1;
  private int S81351 = 1;
  private int S81234 = 1;
  private int S81218 = 1;
  private int S81213 = 1;
  private int S81491 = 1;
  private int S81374 = 1;
  private int S81358 = 1;
  private int S81353 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread81501(int [] tdone, int [] ends){
        switch(S81491){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S81374){
          case 0 : 
            switch(S81358){
              case 0 : 
                if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 56, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                  S81358=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S81353){
                    case 0 : 
                      if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                        recycled_in.setACK(true);//sysj\posStub.sysj line: 56, column: 4
                        S81353=1;
                        if(recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                          recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                          ends[4]=2;
                          ;//sysj\posStub.sysj line: 56, column: 4
                          n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 57, column: 4
                          System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 58, column: 4
                          S81374=1;
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
                      if(recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                        recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                        ends[4]=2;
                        ;//sysj\posStub.sysj line: 56, column: 4
                        n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 57, column: 4
                        System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 58, column: 4
                        S81374=1;
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
                S81358=1;
                S81358=0;
                if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 56, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                  S81358=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S81353=0;
                  if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                    recycled_in.setACK(true);//sysj\posStub.sysj line: 56, column: 4
                    S81353=1;
                    if(recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                      recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                      ends[4]=2;
                      ;//sysj\posStub.sysj line: 56, column: 4
                      n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 57, column: 4
                      System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 58, column: 4
                      S81374=1;
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
            S81374=1;
            S81374=0;
            S81358=0;
            if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 56, column: 4
              recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
              S81358=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S81353=0;
              if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                recycled_in.setACK(true);//sysj\posStub.sysj line: 56, column: 4
                S81353=1;
                if(recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
                  recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
                  ends[4]=2;
                  ;//sysj\posStub.sysj line: 56, column: 4
                  n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 57, column: 4
                  System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 58, column: 4
                  S81374=1;
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

  public void thread81500(int [] tdone, int [] ends){
        switch(S81351){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S81234){
          case 0 : 
            switch(S81218){
              case 0 : 
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 46, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                  S81218=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S81213){
                    case 0 : 
                      if(!completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                        completed_in.setACK(true);//sysj\posStub.sysj line: 46, column: 4
                        S81213=1;
                        if(completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                          completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                          ends[3]=2;
                          ;//sysj\posStub.sysj line: 46, column: 4
                          n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 47, column: 4
                          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 48, column: 4
                          S81234=1;
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
                      if(completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                        completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                        ends[3]=2;
                        ;//sysj\posStub.sysj line: 46, column: 4
                        n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 47, column: 4
                        System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 48, column: 4
                        S81234=1;
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
                S81218=1;
                S81218=0;
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 46, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                  S81218=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S81213=0;
                  if(!completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                    completed_in.setACK(true);//sysj\posStub.sysj line: 46, column: 4
                    S81213=1;
                    if(completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                      completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                      ends[3]=2;
                      ;//sysj\posStub.sysj line: 46, column: 4
                      n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 47, column: 4
                      System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 48, column: 4
                      S81234=1;
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
            S81234=1;
            S81234=0;
            S81218=0;
            if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 46, column: 4
              completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
              S81218=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S81213=0;
              if(!completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                completed_in.setACK(true);//sysj\posStub.sysj line: 46, column: 4
                S81213=1;
                if(completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
                  completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
                  ends[3]=2;
                  ;//sysj\posStub.sysj line: 46, column: 4
                  n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 47, column: 4
                  System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 48, column: 4
                  S81234=1;
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

  public void thread81499(int [] tdone, int [] ends){
        switch(S81211){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S80932){
          case 0 : 
            S80932=0;
            S80932=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            S80932=1;
            S80932=2;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            S80932=2;
            S80932=3;
            if(i_thread_2 < OrderBook.count()){//sysj\posStub.sysj line: 30, column: 9
              w_thread_2 = OrderBook.order(i_thread_2);//sysj\posStub.sysj line: 31, column: 4
              System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + (w_thread_2.isRejected() ? " [fault armed: " + w_thread_2.defect() + "]" : "") + ".");//sysj\posStub.sysj line: 32, column: 4
              S80933=0;
              S80940=0;
              if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                S80940=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S80935=0;
                if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                  order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                  S80935=1;
                  if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                    order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                    ends[2]=2;
                    ;//sysj\posStub.sysj line: 34, column: 4
                    i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                    S80933=1;
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
              S80932=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            switch(S80933){
              case 0 : 
                switch(S80940){
                  case 0 : 
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                      S80940=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S80935){
                        case 0 : 
                          if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                            order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                            S80935=1;
                            if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                              order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                              ends[2]=2;
                              ;//sysj\posStub.sysj line: 34, column: 4
                              i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                              S80933=1;
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
                            S80933=1;
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
                    S80940=1;
                    S80940=0;
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                      S80940=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S80935=0;
                      if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                        order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                        S80935=1;
                        if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                          order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                          ends[2]=2;
                          ;//sysj\posStub.sysj line: 34, column: 4
                          i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                          S80933=1;
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
                S80933=1;
                if(i_thread_2 < OrderBook.count()){//sysj\posStub.sysj line: 30, column: 9
                  w_thread_2 = OrderBook.order(i_thread_2);//sysj\posStub.sysj line: 31, column: 4
                  System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + (w_thread_2.isRejected() ? " [fault armed: " + w_thread_2.defect() + "]" : "") + ".");//sysj\posStub.sysj line: 32, column: 4
                  S80933=0;
                  S80940=0;
                  if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj\posStub.sysj line: 34, column: 4
                    order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                    S80940=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S80935=0;
                    if(order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                      order_o.setVal(w_thread_2);//sysj\posStub.sysj line: 34, column: 4
                      S80935=1;
                      if(!order_o.isACK()){//sysj\posStub.sysj line: 34, column: 4
                        order_o.setREQ(false);//sysj\posStub.sysj line: 34, column: 4
                        ends[2]=2;
                        ;//sysj\posStub.sysj line: 34, column: 4
                        i_thread_2 = i_thread_2 + 1;//sysj\posStub.sysj line: 35, column: 4
                        S80933=1;
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
                  S80932=4;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 4 : 
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread81497(int [] tdone, int [] ends){
        S81491=1;
    n_thread_4 = 0;//sysj\posStub.sysj line: 54, column: 3
    S81374=0;
    S81358=0;
    if(!recycled_in.isPartnerPresent() || recycled_in.isPartnerPreempted()){//sysj\posStub.sysj line: 56, column: 4
      recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
      S81358=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S81353=0;
      if(!recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
        recycled_in.setACK(true);//sysj\posStub.sysj line: 56, column: 4
        S81353=1;
        if(recycled_in.isREQ()){//sysj\posStub.sysj line: 56, column: 4
          recycled_in.setACK(false);//sysj\posStub.sysj line: 56, column: 4
          ends[4]=2;
          ;//sysj\posStub.sysj line: 56, column: 4
          n_thread_4 = n_thread_4 + 1;//sysj\posStub.sysj line: 57, column: 4
          System.out.println("[POS] Bottle " + (Integer)(recycled_in.getVal() == null ? null : ((Integer)recycled_in.getVal())) + " was defective; container reclaimed, order line unfilled (" + n_thread_4 + " recycled).");//sysj\posStub.sysj line: 58, column: 4
          S81374=1;
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

  public void thread81496(int [] tdone, int [] ends){
        S81351=1;
    n_thread_3 = 0;//sysj\posStub.sysj line: 44, column: 3
    S81234=0;
    S81218=0;
    if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj\posStub.sysj line: 46, column: 4
      completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
      S81218=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S81213=0;
      if(!completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
        completed_in.setACK(true);//sysj\posStub.sysj line: 46, column: 4
        S81213=1;
        if(completed_in.isREQ()){//sysj\posStub.sysj line: 46, column: 4
          completed_in.setACK(false);//sysj\posStub.sysj line: 46, column: 4
          ends[3]=2;
          ;//sysj\posStub.sysj line: 46, column: 4
          n_thread_3 = n_thread_3 + 1;//sysj\posStub.sysj line: 47, column: 4
          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj\posStub.sysj line: 48, column: 4
          S81234=1;
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

  public void thread81495(int [] tdone, int [] ends){
        S81211=1;
    i_thread_2 = 0;//sysj\posStub.sysj line: 25, column: 3
    w_thread_2 = null;//sysj\posStub.sysj line: 26, column: 3
    S80932=0;
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
      switch(S81493){
        case 0 : 
          S81493=0;
          break RUN;
        
        case 1 : 
          S81493=2;
          S81493=2;
          thread81495(tdone,ends);
          thread81496(tdone,ends);
          thread81497(tdone,ends);
          int biggest81498 = 0;
          if(ends[2]>=biggest81498){
            biggest81498=ends[2];
          }
          if(ends[3]>=biggest81498){
            biggest81498=ends[3];
          }
          if(ends[4]>=biggest81498){
            biggest81498=ends[4];
          }
          if(biggest81498 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread81499(tdone,ends);
          thread81500(tdone,ends);
          thread81501(tdone,ends);
          int biggest81502 = 0;
          if(ends[2]>=biggest81502){
            biggest81502=ends[2];
          }
          if(ends[3]>=biggest81502){
            biggest81502=ends[3];
          }
          if(ends[4]>=biggest81502){
            biggest81502=ends[4];
          }
          if(biggest81502 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest81502 == 0){
            S81493=0;
            active[1]=0;
            ends[1]=0;
            S81493=0;
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
