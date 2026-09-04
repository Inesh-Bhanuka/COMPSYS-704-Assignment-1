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
  public output_Channel order_o = new output_Channel();
  private int i_thread_2;//sysj/posStub.sysj line: 15, column: 3
  private Workpiece w_thread_2;//sysj/posStub.sysj line: 16, column: 3
  private int n_thread_3;//sysj/posStub.sysj line: 33, column: 3
  private int S40689 = 1;
  private int S40547 = 1;
  private int S40268 = 1;
  private int S40269 = 1;
  private int S40276 = 1;
  private int S40271 = 1;
  private int S40687 = 1;
  private int S40570 = 1;
  private int S40554 = 1;
  private int S40549 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread40695(int [] tdone, int [] ends){
        switch(S40687){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S40570){
          case 0 : 
            switch(S40554){
              case 0 : 
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj/posStub.sysj line: 35, column: 4
                  completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                  S40554=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S40549){
                    case 0 : 
                      if(!completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                        completed_in.setACK(true);//sysj/posStub.sysj line: 35, column: 4
                        S40549=1;
                        if(completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                          completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                          ends[3]=2;
                          ;//sysj/posStub.sysj line: 35, column: 4
                          n_thread_3 = n_thread_3 + 1;//sysj/posStub.sysj line: 36, column: 4
                          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj/posStub.sysj line: 37, column: 4
                          S40570=1;
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
                      if(completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                        completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                        ends[3]=2;
                        ;//sysj/posStub.sysj line: 35, column: 4
                        n_thread_3 = n_thread_3 + 1;//sysj/posStub.sysj line: 36, column: 4
                        System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj/posStub.sysj line: 37, column: 4
                        S40570=1;
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
                S40554=1;
                S40554=0;
                if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj/posStub.sysj line: 35, column: 4
                  completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                  S40554=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S40549=0;
                  if(!completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                    completed_in.setACK(true);//sysj/posStub.sysj line: 35, column: 4
                    S40549=1;
                    if(completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                      completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                      ends[3]=2;
                      ;//sysj/posStub.sysj line: 35, column: 4
                      n_thread_3 = n_thread_3 + 1;//sysj/posStub.sysj line: 36, column: 4
                      System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj/posStub.sysj line: 37, column: 4
                      S40570=1;
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
            S40570=1;
            S40570=0;
            S40554=0;
            if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj/posStub.sysj line: 35, column: 4
              completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
              S40554=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S40549=0;
              if(!completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                completed_in.setACK(true);//sysj/posStub.sysj line: 35, column: 4
                S40549=1;
                if(completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
                  completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
                  ends[3]=2;
                  ;//sysj/posStub.sysj line: 35, column: 4
                  n_thread_3 = n_thread_3 + 1;//sysj/posStub.sysj line: 36, column: 4
                  System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj/posStub.sysj line: 37, column: 4
                  S40570=1;
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

  public void thread40694(int [] tdone, int [] ends){
        switch(S40547){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S40268){
          case 0 : 
            S40268=0;
            S40268=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            S40268=1;
            S40268=2;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            S40268=2;
            S40268=3;
            if(i_thread_2 < OrderBook.count()){//sysj/posStub.sysj line: 20, column: 9
              w_thread_2 = OrderBook.order(i_thread_2);//sysj/posStub.sysj line: 21, column: 4
              System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + ".");//sysj/posStub.sysj line: 22, column: 4
              S40269=0;
              S40276=0;
              if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj/posStub.sysj line: 23, column: 4
                order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                S40276=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S40271=0;
                if(order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                  order_o.setVal(w_thread_2);//sysj/posStub.sysj line: 23, column: 4
                  S40271=1;
                  if(!order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                    order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                    ends[2]=2;
                    ;//sysj/posStub.sysj line: 23, column: 4
                    i_thread_2 = i_thread_2 + 1;//sysj/posStub.sysj line: 24, column: 4
                    S40269=1;
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
              order_o.setPreempted();//sysj/posStub.sysj line: 20, column: 3
              ends[2]=2;
              ;//sysj/posStub.sysj line: 20, column: 3
              System.out.println("[POS] All orders placed.");//sysj/posStub.sysj line: 28, column: 3
              S40268=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            switch(S40269){
              case 0 : 
                switch(S40276){
                  case 0 : 
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj/posStub.sysj line: 23, column: 4
                      order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                      S40276=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S40271){
                        case 0 : 
                          if(order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                            order_o.setVal(w_thread_2);//sysj/posStub.sysj line: 23, column: 4
                            S40271=1;
                            if(!order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                              order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                              ends[2]=2;
                              ;//sysj/posStub.sysj line: 23, column: 4
                              i_thread_2 = i_thread_2 + 1;//sysj/posStub.sysj line: 24, column: 4
                              S40269=1;
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
                          if(!order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                            order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                            ends[2]=2;
                            ;//sysj/posStub.sysj line: 23, column: 4
                            i_thread_2 = i_thread_2 + 1;//sysj/posStub.sysj line: 24, column: 4
                            S40269=1;
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
                    S40276=1;
                    S40276=0;
                    if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj/posStub.sysj line: 23, column: 4
                      order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                      S40276=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S40271=0;
                      if(order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                        order_o.setVal(w_thread_2);//sysj/posStub.sysj line: 23, column: 4
                        S40271=1;
                        if(!order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                          order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                          ends[2]=2;
                          ;//sysj/posStub.sysj line: 23, column: 4
                          i_thread_2 = i_thread_2 + 1;//sysj/posStub.sysj line: 24, column: 4
                          S40269=1;
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
                S40269=1;
                if(i_thread_2 < OrderBook.count()){//sysj/posStub.sysj line: 20, column: 9
                  w_thread_2 = OrderBook.order(i_thread_2);//sysj/posStub.sysj line: 21, column: 4
                  System.out.println("[POS] Order " + (i_thread_2 + 1) + ": " + w_thread_2 + ".");//sysj/posStub.sysj line: 22, column: 4
                  S40269=0;
                  S40276=0;
                  if(!order_o.isPartnerPresent() || order_o.isPartnerPreempted()){//sysj/posStub.sysj line: 23, column: 4
                    order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                    S40276=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S40271=0;
                    if(order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                      order_o.setVal(w_thread_2);//sysj/posStub.sysj line: 23, column: 4
                      S40271=1;
                      if(!order_o.isACK()){//sysj/posStub.sysj line: 23, column: 4
                        order_o.setREQ(false);//sysj/posStub.sysj line: 23, column: 4
                        ends[2]=2;
                        ;//sysj/posStub.sysj line: 23, column: 4
                        i_thread_2 = i_thread_2 + 1;//sysj/posStub.sysj line: 24, column: 4
                        S40269=1;
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
                  order_o.setPreempted();//sysj/posStub.sysj line: 20, column: 3
                  ends[2]=2;
                  ;//sysj/posStub.sysj line: 20, column: 3
                  System.out.println("[POS] All orders placed.");//sysj/posStub.sysj line: 28, column: 3
                  S40268=4;
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

  public void thread40692(int [] tdone, int [] ends){
        S40687=1;
    n_thread_3 = 0;//sysj/posStub.sysj line: 33, column: 3
    S40570=0;
    S40554=0;
    if(!completed_in.isPartnerPresent() || completed_in.isPartnerPreempted()){//sysj/posStub.sysj line: 35, column: 4
      completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
      S40554=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S40549=0;
      if(!completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
        completed_in.setACK(true);//sysj/posStub.sysj line: 35, column: 4
        S40549=1;
        if(completed_in.isREQ()){//sysj/posStub.sysj line: 35, column: 4
          completed_in.setACK(false);//sysj/posStub.sysj line: 35, column: 4
          ends[3]=2;
          ;//sysj/posStub.sysj line: 35, column: 4
          n_thread_3 = n_thread_3 + 1;//sysj/posStub.sysj line: 36, column: 4
          System.out.println("[POS] Bottle " + (Integer)(completed_in.getVal() == null ? null : ((Integer)completed_in.getVal())) + " delivered (" + n_thread_3 + " done).");//sysj/posStub.sysj line: 37, column: 4
          S40570=1;
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

  public void thread40691(int [] tdone, int [] ends){
        S40547=1;
    i_thread_2 = 0;//sysj/posStub.sysj line: 15, column: 3
    w_thread_2 = null;//sysj/posStub.sysj line: 16, column: 3
    S40268=0;
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
      switch(S40689){
        case 0 : 
          S40689=0;
          break RUN;
        
        case 1 : 
          S40689=2;
          S40689=2;
          thread40691(tdone,ends);
          thread40692(tdone,ends);
          int biggest40693 = 0;
          if(ends[2]>=biggest40693){
            biggest40693=ends[2];
          }
          if(ends[3]>=biggest40693){
            biggest40693=ends[3];
          }
          if(biggest40693 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread40694(tdone,ends);
          thread40695(tdone,ends);
          int biggest40696 = 0;
          if(ends[2]>=biggest40696){
            biggest40696=ends[2];
          }
          if(ends[3]>=biggest40696){
            biggest40696=ends[3];
          }
          if(biggest40696 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest40696 == 0){
            S40689=0;
            active[1]=0;
            ends[1]=0;
            S40689=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
      order_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        completed_in.gethook();
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
