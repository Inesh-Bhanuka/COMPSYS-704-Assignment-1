import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class POS extends ClockDomain{
  public POS(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal productionStatus = new Signal("productionStatus", Signal.INPUT);
  public Signal purchaseOrder = new Signal("purchaseOrder", Signal.OUTPUT);
  private PosOrderRequest order_thread_1;//sysj\pos.sysj line: 9, column: 5
  private int S118848 = 1;
  private int S118814 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S118848){
        case 0 : 
          S118848=0;
          break RUN;
        
        case 1 : 
          S118848=2;
          S118848=2;
          order_thread_1 = null;//sysj\pos.sysj line: 9, column: 5
          PosBridge.open();//sysj\pos.sysj line: 10, column: 5
          order_thread_1 = PosBridge.pending();//sysj\pos.sysj line: 12, column: 9
          S118814=0;
          if(order_thread_1 != null){//sysj\pos.sysj line: 13, column: 12
            purchaseOrder.setPresent();//sysj\pos.sysj line: 13, column: 28
            currsigs.addElement(purchaseOrder);
            purchaseOrder.setValue(order_thread_1);//sysj\pos.sysj line: 13, column: 28
            if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
              PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
              S118814=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S118814=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
          else {
            if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
              PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
              S118814=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S118814=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S118814){
            case 0 : 
              order_thread_1 = PosBridge.pending();//sysj\pos.sysj line: 12, column: 9
              S118814=0;
              if(order_thread_1 != null){//sysj\pos.sysj line: 13, column: 12
                purchaseOrder.setPresent();//sysj\pos.sysj line: 13, column: 28
                currsigs.addElement(purchaseOrder);
                purchaseOrder.setValue(order_thread_1);//sysj\pos.sysj line: 13, column: 28
                if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
                  PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
                  PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S118814=1;
              order_thread_1 = PosBridge.pending();//sysj\pos.sysj line: 12, column: 9
              S118814=0;
              if(order_thread_1 != null){//sysj\pos.sysj line: 13, column: 12
                purchaseOrder.setPresent();//sysj\pos.sysj line: 13, column: 28
                currsigs.addElement(purchaseOrder);
                purchaseOrder.setValue(order_thread_1);//sysj\pos.sysj line: 13, column: 28
                if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
                  PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                if(productionStatus.getprestatus()){//sysj\pos.sysj line: 14, column: 17
                  PosBridge.acceptFeedback((PosOrderStatus)(productionStatus.getpreval() == null ? null : ((PosOrderStatus)productionStatus.getpreval())));//sysj\pos.sysj line: 14, column: 36
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S118814=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          productionStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      productionStatus.setpreclear();
      purchaseOrder.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = productionStatus.getStatus() ? productionStatus.setprepresent() : productionStatus.setpreclear();
      productionStatus.setpreval(productionStatus.getValue());
      productionStatus.setClear();
      purchaseOrder.sethook();
      purchaseOrder.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        productionStatus.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
