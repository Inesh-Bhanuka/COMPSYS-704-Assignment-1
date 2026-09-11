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
<<<<<<< Updated upstream
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.INPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.OUTPUT);
  public Signal bottleLoad = new Signal("bottleLoad", Signal.OUTPUT);
  public Signal enableBL = new Signal("enableBL", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  public Signal enableRT = new Signal("enableRT", Signal.OUTPUT);
  public Signal enableST = new Signal("enableST", Signal.OUTPUT);
  private int delivered_thread_5;//sysj\systemController.sysj line: 59, column: 3
  private boolean seen_thread_5;//sysj\systemController.sysj line: 60, column: 3
  private int cycles_thread_4;//sysj\systemController.sysj line: 38, column: 3
  private int i_thread_4;//sysj\systemController.sysj line: 39, column: 3
  private int S4726 = 1;
  private int S4641 = 1;
  private int S4646 = 1;
  private int S4710 = 1;
  private int S4647 = 1;
  private int S4656 = 1;
  private int S4724 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4736(int [] tdone, int [] ends){
        switch(S4724){
=======
  public Signal purchaseOrder = new Signal("purchaseOrder", Signal.INPUT);
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
  public Signal productionStatus = new Signal("productionStatus", Signal.OUTPUT);
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
  public input_Channel loadAck_in = new input_Channel();
  public input_Channel bottleDone_in = new input_Channel();
  public input_Channel labelDone_in = new input_Channel();
  public input_Channel bottleRecycled_in = new input_Channel();
  public output_Channel loadOrder_o = new output_Channel();
  public output_Channel labelBottle_o = new output_Channel();
  public output_Channel bottleRejected_o = new output_Channel();
  private PosOrderStatus status_thread_4;//sysj\systemController.sysj line: 91, column: 3
  private WorkpieceTwin w_thread_5;//sysj\systemController.sysj line: 101, column: 3
  private WorkpieceTwin w_thread_7;//sysj\systemController.sysj line: 127, column: 3
  private WorkpieceTwin w_thread_8;//sysj\systemController.sysj line: 147, column: 3
  private int done_thread_8;//sysj\systemController.sysj line: 148, column: 3
  private ABSTwin plant_thread_9;//sysj\systemController.sysj line: 181, column: 3
  private TwinPublisher out_thread_9;//sysj\systemController.sysj line: 182, column: 3
  private WorkpieceTwin w_thread_10;//sysj\systemController.sysj line: 210, column: 3
  private int recovered_thread_10;//sysj\systemController.sysj line: 211, column: 3
  private int last_thread_11;//sysj\systemController.sysj line: 226, column: 3
  private int v_thread_11;//sysj\systemController.sysj line: 227, column: 3
  private int S212150 = 1;
  private int S207798 = 1;
  private int S207803 = 1;
  private int S207835 = 1;
  private int S207805 = 1;
  private int S208395 = 1;
  private int S207928 = 1;
  private int S207843 = 1;
  private int S207838 = 1;
  private int S208466 = 1;
  private int S208418 = 1;
  private int S208402 = 1;
  private int S208397 = 1;
  private int S209134 = 1;
  private int S208489 = 1;
  private int S208473 = 1;
  private int S208468 = 1;
  private int S208496 = 1;
  private int S208491 = 1;
  private int S210402 = 1;
  private int S209158 = 1;
  private int S209142 = 1;
  private int S209137 = 1;
  private int S209165 = 1;
  private int S209160 = 1;
  private int S211988 = 1;
  private int S212128 = 1;
  private int S212012 = 1;
  private int S211996 = 1;
  private int S211991 = 1;
  private int S212148 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread212172(int [] tdone, int [] ends){
        switch(S212148){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 229, column: 12
          v_thread_11 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 230, column: 5
          if(v_thread_11 != last_thread_11) {//sysj\systemController.sysj line: 231, column: 18
            if(v_thread_11 == 0) {//sysj\systemController.sysj line: 232, column: 16
              System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 232, column: 18
            }
            if(v_thread_11 == 1) {//sysj\systemController.sysj line: 233, column: 16
              System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 233, column: 18
            }
            if(v_thread_11 == 2) {//sysj\systemController.sysj line: 234, column: 16
              System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 234, column: 18
            }
            if(v_thread_11 == 3) {//sysj\systemController.sysj line: 235, column: 16
              System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 235, column: 18
            }
            last_thread_11 = v_thread_11;//sysj\systemController.sysj line: 236, column: 6
          }
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread212171(int [] tdone, int [] ends){
        switch(S212128){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S212012){
          case 0 : 
            switch(S211996){
              case 0 : 
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 213, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                  S211996=1;
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                else {
                  switch(S211991){
                    case 0 : 
                      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 213, column: 4
                        S211991=1;
                        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                          ends[10]=2;
                          ;//sysj\systemController.sysj line: 213, column: 4
                          w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 214, column: 4
                          recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 215, column: 4
                          System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 216, column: 4
                          OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 218, column: 4
                          S212012=1;
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
                      else {
                        active[10]=1;
                        ends[10]=1;
                        tdone[10]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                        bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                        ends[10]=2;
                        ;//sysj\systemController.sysj line: 213, column: 4
                        w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 214, column: 4
                        recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 215, column: 4
                        System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 216, column: 4
                        OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 218, column: 4
                        S212012=1;
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
                break;
              
              case 1 : 
                S211996=1;
                S211996=0;
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 213, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                  S211996=1;
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                else {
                  S211991=0;
                  if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                    bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 213, column: 4
                    S211991=1;
                    if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                      ends[10]=2;
                      ;//sysj\systemController.sysj line: 213, column: 4
                      w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 214, column: 4
                      recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 215, column: 4
                      System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 216, column: 4
                      OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 218, column: 4
                      S212012=1;
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
                  else {
                    active[10]=1;
                    ends[10]=1;
                    tdone[10]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            S212012=1;
            S212012=0;
            S211996=0;
            if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 213, column: 4
              bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
              S211996=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S211991=0;
              if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 213, column: 4
                S211991=1;
                if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
                  ends[10]=2;
                  ;//sysj\systemController.sysj line: 213, column: 4
                  w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 214, column: 4
                  recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 215, column: 4
                  System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 216, column: 4
                  OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 218, column: 4
                  S212012=1;
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
              else {
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread212170(int [] tdone, int [] ends){
        switch(S211988){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        PlantClock.advance();//sysj\systemController.sysj line: 185, column: 4
        if(twinBL.getprestatus()){//sysj\systemController.sysj line: 187, column: 12
          plant_thread_9.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 187, column: 21
          if(twinCV.getprestatus()){//sysj\systemController.sysj line: 188, column: 12
            plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 188, column: 21
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
          }
          else {
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else {
          if(twinCV.getprestatus()){//sysj\systemController.sysj line: 188, column: 12
            plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 188, column: 21
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
          }
          else {
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
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
  }

  public void thread212169(int [] tdone, int [] ends){
        switch(S210402){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S209158){
          case 0 : 
            switch(S209142){
              case 0 : 
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 150, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                  S209142=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  switch(S209137){
                    case 0 : 
                      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                        labelDone_in.setACK(true);//sysj\systemController.sysj line: 150, column: 4
                        S209137=1;
                        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                          labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 150, column: 4
                          w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 151, column: 4
                          S209158=1;
                          if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 153, column: 4
                            System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 154, column: 5
                            S209165=0;
                            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                              S209165=1;
                              active[8]=1;
                              ends[8]=1;
                              tdone[8]=1;
                            }
                            else {
                              S209160=0;
                              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                                bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                                S209160=1;
                                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                                  ends[8]=2;
                                  ;//sysj\systemController.sysj line: 156, column: 5
                                  S209158=2;
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
                              else {
                                active[8]=1;
                                ends[8]=1;
                                tdone[8]=1;
                              }
                            }
                          }
                          else {
                            w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 161, column: 5
                            w_thread_8.seal();//sysj\systemController.sysj line: 162, column: 5
                            BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 163, column: 5
                            done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 164, column: 5
                            System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 165, column: 5
                            OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 168, column: 5
                            S209158=2;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                        else {
                          active[8]=1;
                          ends[8]=1;
                          tdone[8]=1;
                        }
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                        labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                        ends[8]=2;
                        ;//sysj\systemController.sysj line: 150, column: 4
                        w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 151, column: 4
                        S209158=1;
                        if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 153, column: 4
                          System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 154, column: 5
                          S209165=0;
                          if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                            bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                            S209165=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            S209160=0;
                            if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                              bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                              S209160=1;
                              if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                                bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                                ends[8]=2;
                                ;//sysj\systemController.sysj line: 156, column: 5
                                S209158=2;
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
                            else {
                              active[8]=1;
                              ends[8]=1;
                              tdone[8]=1;
                            }
                          }
                        }
                        else {
                          w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 161, column: 5
                          w_thread_8.seal();//sysj\systemController.sysj line: 162, column: 5
                          BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 163, column: 5
                          done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 164, column: 5
                          System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 165, column: 5
                          OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 168, column: 5
                          S209158=2;
                          active[8]=1;
                          ends[8]=1;
                          tdone[8]=1;
                        }
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S209142=1;
                S209142=0;
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 150, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                  S209142=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S209137=0;
                  if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                    labelDone_in.setACK(true);//sysj\systemController.sysj line: 150, column: 4
                    S209137=1;
                    if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                      labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                      ends[8]=2;
                      ;//sysj\systemController.sysj line: 150, column: 4
                      w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 151, column: 4
                      S209158=1;
                      if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 153, column: 4
                        System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 154, column: 5
                        S209165=0;
                        if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                          S209165=1;
                          active[8]=1;
                          ends[8]=1;
                          tdone[8]=1;
                        }
                        else {
                          S209160=0;
                          if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                            bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                            S209160=1;
                            if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                              ends[8]=2;
                              ;//sysj\systemController.sysj line: 156, column: 5
                              S209158=2;
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
                          else {
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                        }
                      }
                      else {
                        w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 161, column: 5
                        w_thread_8.seal();//sysj\systemController.sysj line: 162, column: 5
                        BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 163, column: 5
                        done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 164, column: 5
                        System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 165, column: 5
                        OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 168, column: 5
                        S209158=2;
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                  else {
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            switch(S209165){
              case 0 : 
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                  S209165=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  switch(S209160){
                    case 0 : 
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                        bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                        S209160=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 156, column: 5
                          S209158=2;
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
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                        bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                        ends[8]=2;
                        ;//sysj\systemController.sysj line: 156, column: 5
                        S209158=2;
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
                break;
              
              case 1 : 
                S209165=1;
                S209165=0;
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                  S209165=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S209160=0;
                  if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                    bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                    S209160=1;
                    if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                      ends[8]=2;
                      ;//sysj\systemController.sysj line: 156, column: 5
                      S209158=2;
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
                  else {
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            S209158=2;
            S209158=0;
            S209142=0;
            if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 150, column: 4
              labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
              S209142=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S209137=0;
              if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                labelDone_in.setACK(true);//sysj\systemController.sysj line: 150, column: 4
                S209137=1;
                if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
                  ends[8]=2;
                  ;//sysj\systemController.sysj line: 150, column: 4
                  w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 151, column: 4
                  S209158=1;
                  if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 153, column: 4
                    System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 154, column: 5
                    S209165=0;
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                      S209165=1;
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      S209160=0;
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                        bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                        S209160=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 156, column: 5
                          S209158=2;
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
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                  else {
                    w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 161, column: 5
                    w_thread_8.seal();//sysj\systemController.sysj line: 162, column: 5
                    BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 163, column: 5
                    done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 164, column: 5
                    System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 165, column: 5
                    OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 168, column: 5
                    S209158=2;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                  }
                }
                else {
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread212168(int [] tdone, int [] ends){
        switch(S209134){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S208489){
          case 0 : 
            switch(S208473){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 129, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                  S208473=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S208468){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 129, column: 4
                        S208468=1;
                        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 129, column: 4
                          w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 130, column: 4
                          S208489=1;
                          S208496=0;
                          if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                            S208496=1;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            S208491=0;
                            if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                              labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                              S208491=1;
                              if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                                ends[7]=2;
                                ;//sysj\systemController.sysj line: 136, column: 4
                                S208489=2;
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
                      if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                        bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 129, column: 4
                        w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 130, column: 4
                        S208489=1;
                        S208496=0;
                        if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                          S208496=1;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          S208491=0;
                          if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                            labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                            S208491=1;
                            if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                              labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 136, column: 4
                              S208489=2;
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
                S208473=1;
                S208473=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 129, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                  S208473=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S208468=0;
                  if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                    bottleDone_in.setACK(true);//sysj\systemController.sysj line: 129, column: 4
                    S208468=1;
                    if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 129, column: 4
                      w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 130, column: 4
                      S208489=1;
                      S208496=0;
                      if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                        S208496=1;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        S208491=0;
                        if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                          labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                          S208491=1;
                          if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                            ends[7]=2;
                            ;//sysj\systemController.sysj line: 136, column: 4
                            S208489=2;
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
            switch(S208496){
              case 0 : 
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                  S208496=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S208491){
                    case 0 : 
                      if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                        labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                        S208491=1;
                        if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 136, column: 4
                          S208489=2;
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
                      if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 136, column: 4
                        S208489=2;
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
                S208496=1;
                S208496=0;
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                  S208496=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S208491=0;
                  if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                    labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                    S208491=1;
                    if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                      labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 136, column: 4
                      S208489=2;
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
            S208489=2;
            S208489=0;
            S208473=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 129, column: 4
              bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
              S208473=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S208468=0;
              if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                bottleDone_in.setACK(true);//sysj\systemController.sysj line: 129, column: 4
                S208468=1;
                if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 129, column: 4
                  w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 130, column: 4
                  S208489=1;
                  S208496=0;
                  if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
                    labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                    S208496=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S208491=0;
                    if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                      labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
                      S208491=1;
                      if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 136, column: 4
                        S208489=2;
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

  public void thread212167(int [] tdone, int [] ends){
        switch(S208466){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S208418){
          case 0 : 
            switch(S208402){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 115, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                  S208402=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S208397){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                        loadAck_in.setACK(true);//sysj\systemController.sysj line: 115, column: 4
                        S208397=1;
                        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                          loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 115, column: 4
                          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 116, column: 4
                          S208418=1;
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
                      if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                        loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 115, column: 4
                        System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 116, column: 4
                        S208418=1;
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
                S208402=1;
                S208402=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 115, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                  S208402=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S208397=0;
                  if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                    loadAck_in.setACK(true);//sysj\systemController.sysj line: 115, column: 4
                    S208397=1;
                    if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                      loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 115, column: 4
                      System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 116, column: 4
                      S208418=1;
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
          
          case 1 : 
            S208418=1;
            S208418=0;
            S208402=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 115, column: 4
              loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
              S208402=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S208397=0;
              if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                loadAck_in.setACK(true);//sysj\systemController.sysj line: 115, column: 4
                S208397=1;
                if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
                  ends[6]=2;
                  ;//sysj\systemController.sysj line: 115, column: 4
                  System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 116, column: 4
                  S208418=1;
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
      
    }
  }

  public void thread212166(int [] tdone, int [] ends){
        switch(S208395){
>>>>>>> Stashed changes
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 63, column: 12
          if(!seen_thread_5) {//sysj\systemController.sysj line: 64, column: 14
            delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 65, column: 6
            seen_thread_5 = true;//sysj\systemController.sysj line: 66, column: 6
            System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 67, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          seen_thread_5 = false;//sysj\systemController.sysj line: 71, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
=======
        switch(S207928){
          case 0 : 
            switch(S207843){
              case 0 : 
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 107, column: 5
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                  S207843=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S207838){
                    case 0 : 
                      if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                        loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 107, column: 5
                        S207838=1;
                        if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                          ends[5]=2;
                          ;//sysj\systemController.sysj line: 107, column: 5
                          S207928=1;
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
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                        ends[5]=2;
                        ;//sysj\systemController.sysj line: 107, column: 5
                        S207928=1;
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
                S207843=1;
                S207843=0;
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 107, column: 5
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                  S207843=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S207838=0;
                  if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                    loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 107, column: 5
                    S207838=1;
                    if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                      loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                      ends[5]=2;
                      ;//sysj\systemController.sysj line: 107, column: 5
                      S207928=1;
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
            S207928=1;
            w_thread_5 = OrderBook.nextBottle();//sysj\systemController.sysj line: 103, column: 4
            S207928=0;
            if(w_thread_5 != null){//sysj\systemController.sysj line: 104, column: 7
              System.out.println("[SC] Loading " + w_thread_5 + ".");//sysj\systemController.sysj line: 105, column: 5
              TwinRegistry.shared().admit(w_thread_5);//sysj\systemController.sysj line: 106, column: 5
              S207843=0;
              if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 107, column: 5
                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                S207843=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S207838=0;
                if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                  loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 107, column: 5
                  S207838=1;
                  if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
                    loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
                    ends[5]=2;
                    ;//sysj\systemController.sysj line: 107, column: 5
                    S207928=1;
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
            else {
              S207928=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
>>>>>>> Stashed changes
        }
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread4735(int [] tdone, int [] ends){
        switch(S4710){
=======
  public void thread212165(int [] tdone, int [] ends){
        switch(S207835){
>>>>>>> Stashed changes
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        switch(S4647){
          case 0 : 
            S4647=0;
            S4647=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S4647=1;
            S4647=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S4647=2;
            S4647=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S4647=3;
            S4647=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S4647=4;
            cycles_thread_4 = 4;//sysj\systemController.sysj line: 38, column: 3
            i_thread_4 = 0;//sysj\systemController.sysj line: 39, column: 3
            S4647=5;
            if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 41, column: 9
              System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 42, column: 4
              S4656=0;
              bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
              currsigs.addElement(bottleLoad);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\systemController.sysj line: 41, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 54, column: 3
              S4647=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S4656){
              case 0 : 
                if(bottleLoaded.getprestatus()){//sysj\systemController.sysj line: 44, column: 10
                  i_thread_4 = i_thread_4 + 1;//sysj\systemController.sysj line: 48, column: 4
                  System.out.println("[SC] Bottle " + i_thread_4 + " loaded onto conveyor.");//sysj\systemController.sysj line: 49, column: 4
                  S4656=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S4656=1;
                S4656=2;
=======
        switch(S207805){
          case 0 : 
            S207805=0;
            if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 93, column: 12
              OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 93, column: 28
              status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
              if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
                productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
                currsigs.addElement(productionStatus);
                productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
              if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
                productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
                currsigs.addElement(productionStatus);
                productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 1 : 
            S207805=1;
            S207805=0;
            if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 93, column: 12
              OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 93, column: 28
              status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
              if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
                productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
                currsigs.addElement(productionStatus);
                productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
              if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
                productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
                currsigs.addElement(productionStatus);
                productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
                S207805=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S207805=1;
>>>>>>> Stashed changes
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 2 : 
                S4656=2;
                S4656=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 3 : 
                S4656=3;
                if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 41, column: 9
                  System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 42, column: 4
                  S4656=0;
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 41, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 54, column: 3
                  S4647=6;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 6 : 
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread4734(int [] tdone, int [] ends){
        switch(S4646){
=======
  public void thread212164(int [] tdone, int [] ends){
        switch(S207803){
>>>>>>> Stashed changes
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        enableBL.setPresent();//sysj\systemController.sysj line: 27, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 28, column: 4
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 29, column: 4
        currsigs.addElement(enableRT);
        enableST.setPresent();//sysj\systemController.sysj line: 30, column: 4
        currsigs.addElement(enableST);
=======
        enableBL.setPresent();//sysj\systemController.sysj line: 82, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 82, column: 19
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 82, column: 34
        currsigs.addElement(enableRT);
        enableF1.setPresent();//sysj\systemController.sysj line: 83, column: 4
        currsigs.addElement(enableF1);
        enableF2.setPresent();//sysj\systemController.sysj line: 83, column: 19
        currsigs.addElement(enableF2);
        enableLL.setPresent();//sysj\systemController.sysj line: 83, column: 34
        currsigs.addElement(enableLL);
        enableCP.setPresent();//sysj\systemController.sysj line: 83, column: 49
        currsigs.addElement(enableCP);
        enableLB.setPresent();//sysj\systemController.sysj line: 83, column: 64
        currsigs.addElement(enableLB);
        enableSP.setPresent();//sysj\systemController.sysj line: 84, column: 4
        currsigs.addElement(enableSP);
        enableRC.setPresent();//sysj\systemController.sysj line: 84, column: 19
        currsigs.addElement(enableRC);
        enableLR.setPresent();//sysj\systemController.sysj line: 84, column: 34
        currsigs.addElement(enableLR);
        enableLD.setPresent();//sysj\systemController.sysj line: 85, column: 4
        currsigs.addElement(enableLD);
        enableBR.setPresent();//sysj\systemController.sysj line: 85, column: 19
        currsigs.addElement(enableBR);
>>>>>>> Stashed changes
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread4733(int [] tdone, int [] ends){
        switch(S4641){
=======
  public void thread212163(int [] tdone, int [] ends){
        switch(S207798){
>>>>>>> Stashed changes
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        mode.setPresent();//sysj\systemController.sysj line: 20, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj\systemController.sysj line: 20, column: 4
=======
        modeBL.setPresent();//sysj\systemController.sysj line: 72, column: 4
        currsigs.addElement(modeBL);
        modeBL.setValue(0);//sysj\systemController.sysj line: 72, column: 4
        modeF1.setPresent();//sysj\systemController.sysj line: 72, column: 20
        currsigs.addElement(modeF1);
        modeF1.setValue(0);//sysj\systemController.sysj line: 72, column: 20
        modeF2.setPresent();//sysj\systemController.sysj line: 72, column: 36
        currsigs.addElement(modeF2);
        modeF2.setValue(0);//sysj\systemController.sysj line: 72, column: 36
        modeLL.setPresent();//sysj\systemController.sysj line: 73, column: 4
        currsigs.addElement(modeLL);
        modeLL.setValue(0);//sysj\systemController.sysj line: 73, column: 4
        modeCP.setPresent();//sysj\systemController.sysj line: 73, column: 20
        currsigs.addElement(modeCP);
        modeCP.setValue(0);//sysj\systemController.sysj line: 73, column: 20
        modeLB.setPresent();//sysj\systemController.sysj line: 73, column: 36
        currsigs.addElement(modeLB);
        modeLB.setValue(0);//sysj\systemController.sysj line: 73, column: 36
        modeSP.setPresent();//sysj\systemController.sysj line: 74, column: 4
        currsigs.addElement(modeSP);
        modeSP.setValue(0);//sysj\systemController.sysj line: 74, column: 4
        modeRC.setPresent();//sysj\systemController.sysj line: 74, column: 20
        currsigs.addElement(modeRC);
        modeRC.setValue(0);//sysj\systemController.sysj line: 74, column: 20
        modeLR.setPresent();//sysj\systemController.sysj line: 74, column: 36
        currsigs.addElement(modeLR);
        modeLR.setValue(0);//sysj\systemController.sysj line: 74, column: 36
        modeLD.setPresent();//sysj\systemController.sysj line: 75, column: 4
        currsigs.addElement(modeLD);
        modeLD.setValue(0);//sysj\systemController.sysj line: 75, column: 4
        modeBR.setPresent();//sysj\systemController.sysj line: 75, column: 20
        currsigs.addElement(modeBR);
        modeBR.setValue(0);//sysj\systemController.sysj line: 75, column: 20
>>>>>>> Stashed changes
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread4731(int [] tdone, int [] ends){
        S4724=1;
    delivered_thread_5 = 0;//sysj\systemController.sysj line: 59, column: 3
    seen_thread_5 = false;//sysj\systemController.sysj line: 60, column: 3
    if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 63, column: 12
      if(!seen_thread_5) {//sysj\systemController.sysj line: 64, column: 14
        delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 65, column: 6
        seen_thread_5 = true;//sysj\systemController.sysj line: 66, column: 6
        System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 67, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      seen_thread_5 = false;//sysj\systemController.sysj line: 71, column: 5
=======
  public void thread212161(int [] tdone, int [] ends){
        S212148=1;
    last_thread_11 = -1;//sysj\systemController.sysj line: 226, column: 3
    v_thread_11 = 0;//sysj\systemController.sysj line: 227, column: 3
    if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 229, column: 12
      v_thread_11 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 230, column: 5
      if(v_thread_11 != last_thread_11) {//sysj\systemController.sysj line: 231, column: 18
        if(v_thread_11 == 0) {//sysj\systemController.sysj line: 232, column: 16
          System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 232, column: 18
        }
        if(v_thread_11 == 1) {//sysj\systemController.sysj line: 233, column: 16
          System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 233, column: 18
        }
        if(v_thread_11 == 2) {//sysj\systemController.sysj line: 234, column: 16
          System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 234, column: 18
        }
        if(v_thread_11 == 3) {//sysj\systemController.sysj line: 235, column: 16
          System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 235, column: 18
        }
        last_thread_11 = v_thread_11;//sysj\systemController.sysj line: 236, column: 6
      }
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread212160(int [] tdone, int [] ends){
        S212128=1;
    w_thread_10 = null;//sysj\systemController.sysj line: 210, column: 3
    recovered_thread_10 = 0;//sysj\systemController.sysj line: 211, column: 3
    S212012=0;
    S211996=0;
    if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 213, column: 4
      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
      S211996=1;
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      S211991=0;
      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 213, column: 4
        S211991=1;
        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 213, column: 4
          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 213, column: 4
          ends[10]=2;
          ;//sysj\systemController.sysj line: 213, column: 4
          w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 214, column: 4
          recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 215, column: 4
          System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 216, column: 4
          OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 218, column: 4
          S212012=1;
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
      else {
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
      }
    }
  }

  public void thread212159(int [] tdone, int [] ends){
        S211988=1;
    plant_thread_9 = new ABSTwin();//sysj\systemController.sysj line: 181, column: 3
    out_thread_9 = TwinPublisher.shared();//sysj\systemController.sysj line: 182, column: 3
    PlantClock.advance();//sysj\systemController.sysj line: 185, column: 4
    if(twinBL.getprestatus()){//sysj\systemController.sysj line: 187, column: 12
      plant_thread_9.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 187, column: 21
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 188, column: 12
        plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 188, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
      }
      else {
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
      }
    }
    else {
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 188, column: 12
        plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 188, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
      }
      else {
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 189, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 189, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
        else {
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 190, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 190, column: 21
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 191, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 191, column: 21
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 192, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 192, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 193, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 193, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 194, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 194, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 196, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 197, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 198, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 199, column: 4
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public void thread212158(int [] tdone, int [] ends){
        S210402=1;
    w_thread_8 = null;//sysj\systemController.sysj line: 147, column: 3
    done_thread_8 = 0;//sysj\systemController.sysj line: 148, column: 3
    S209158=0;
    S209142=0;
    if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 150, column: 4
      labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
      S209142=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S209137=0;
      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
        labelDone_in.setACK(true);//sysj\systemController.sysj line: 150, column: 4
        S209137=1;
        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 150, column: 4
          labelDone_in.setACK(false);//sysj\systemController.sysj line: 150, column: 4
          ends[8]=2;
          ;//sysj\systemController.sysj line: 150, column: 4
          w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 151, column: 4
          S209158=1;
          if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 153, column: 4
            System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 154, column: 5
            S209165=0;
            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 156, column: 5
              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
              S209165=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S209160=0;
              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 156, column: 5
                S209160=1;
                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 156, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 156, column: 5
                  ends[8]=2;
                  ;//sysj\systemController.sysj line: 156, column: 5
                  S209158=2;
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
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
          }
          else {
            w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 161, column: 5
            w_thread_8.seal();//sysj\systemController.sysj line: 162, column: 5
            BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 163, column: 5
            done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 164, column: 5
            System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 165, column: 5
            OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 168, column: 5
            S209158=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
          }
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
      }
      else {
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
    }
  }

  public void thread212157(int [] tdone, int [] ends){
        S209134=1;
    w_thread_7 = null;//sysj\systemController.sysj line: 127, column: 3
    S208489=0;
    S208473=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 129, column: 4
      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
      S208473=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S208468=0;
      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 129, column: 4
        S208468=1;
        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 129, column: 4
          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 129, column: 4
          ends[7]=2;
          ;//sysj\systemController.sysj line: 129, column: 4
          w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 130, column: 4
          S208489=1;
          S208496=0;
          if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 136, column: 4
            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
            S208496=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            S208491=0;
            if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
              labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 136, column: 4
              S208491=1;
              if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 136, column: 4
                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 136, column: 4
                ends[7]=2;
                ;//sysj\systemController.sysj line: 136, column: 4
                S208489=2;
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

  public void thread212156(int [] tdone, int [] ends){
        S208466=1;
    S208418=0;
    S208402=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 115, column: 4
      loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
      S208402=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S208397=0;
      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
        loadAck_in.setACK(true);//sysj\systemController.sysj line: 115, column: 4
        S208397=1;
        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 115, column: 4
          loadAck_in.setACK(false);//sysj\systemController.sysj line: 115, column: 4
          ends[6]=2;
          ;//sysj\systemController.sysj line: 115, column: 4
          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 116, column: 4
          S208418=1;
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

  public void thread212155(int [] tdone, int [] ends){
        S208395=1;
    w_thread_5 = null;//sysj\systemController.sysj line: 101, column: 3
    w_thread_5 = OrderBook.nextBottle();//sysj\systemController.sysj line: 103, column: 4
    S207928=0;
    if(w_thread_5 != null){//sysj\systemController.sysj line: 104, column: 7
      System.out.println("[SC] Loading " + w_thread_5 + ".");//sysj\systemController.sysj line: 105, column: 5
      TwinRegistry.shared().admit(w_thread_5);//sysj\systemController.sysj line: 106, column: 5
      S207843=0;
      if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 107, column: 5
        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
        S207843=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S207838=0;
        if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
          loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 107, column: 5
          S207838=1;
          if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 107, column: 5
            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 107, column: 5
            ends[5]=2;
            ;//sysj\systemController.sysj line: 107, column: 5
            S207928=1;
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
    else {
      S207928=1;
>>>>>>> Stashed changes
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

<<<<<<< Updated upstream
  public void thread4730(int [] tdone, int [] ends){
        S4710=1;
    S4647=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4729(int [] tdone, int [] ends){
        S4646=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 27, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 28, column: 4
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 29, column: 4
    currsigs.addElement(enableRT);
    enableST.setPresent();//sysj\systemController.sysj line: 30, column: 4
    currsigs.addElement(enableST);
=======
  public void thread212154(int [] tdone, int [] ends){
        S207835=1;
    status_thread_4 = null;//sysj\systemController.sysj line: 91, column: 3
    S207805=0;
    if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 93, column: 12
      OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 93, column: 28
      status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
      if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
        productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
        currsigs.addElement(productionStatus);
        productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
        S207805=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S207805=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      status_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 94, column: 4
      if(status_thread_4 != null){//sysj\systemController.sysj line: 95, column: 7
        productionStatus.setPresent();//sysj\systemController.sysj line: 95, column: 24
        currsigs.addElement(productionStatus);
        productionStatus.setValue(status_thread_4);//sysj\systemController.sysj line: 95, column: 24
        S207805=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S207805=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
  }

  public void thread212153(int [] tdone, int [] ends){
        S207803=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 82, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 82, column: 19
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 82, column: 34
    currsigs.addElement(enableRT);
    enableF1.setPresent();//sysj\systemController.sysj line: 83, column: 4
    currsigs.addElement(enableF1);
    enableF2.setPresent();//sysj\systemController.sysj line: 83, column: 19
    currsigs.addElement(enableF2);
    enableLL.setPresent();//sysj\systemController.sysj line: 83, column: 34
    currsigs.addElement(enableLL);
    enableCP.setPresent();//sysj\systemController.sysj line: 83, column: 49
    currsigs.addElement(enableCP);
    enableLB.setPresent();//sysj\systemController.sysj line: 83, column: 64
    currsigs.addElement(enableLB);
    enableSP.setPresent();//sysj\systemController.sysj line: 84, column: 4
    currsigs.addElement(enableSP);
    enableRC.setPresent();//sysj\systemController.sysj line: 84, column: 19
    currsigs.addElement(enableRC);
    enableLR.setPresent();//sysj\systemController.sysj line: 84, column: 34
    currsigs.addElement(enableLR);
    enableLD.setPresent();//sysj\systemController.sysj line: 85, column: 4
    currsigs.addElement(enableLD);
    enableBR.setPresent();//sysj\systemController.sysj line: 85, column: 19
    currsigs.addElement(enableBR);
>>>>>>> Stashed changes
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

<<<<<<< Updated upstream
  public void thread4728(int [] tdone, int [] ends){
        S4641=1;
    mode.setPresent();//sysj\systemController.sysj line: 20, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj\systemController.sysj line: 20, column: 4
=======
  public void thread212152(int [] tdone, int [] ends){
        S207798=1;
    modeBL.setPresent();//sysj\systemController.sysj line: 72, column: 4
    currsigs.addElement(modeBL);
    modeBL.setValue(0);//sysj\systemController.sysj line: 72, column: 4
    modeF1.setPresent();//sysj\systemController.sysj line: 72, column: 20
    currsigs.addElement(modeF1);
    modeF1.setValue(0);//sysj\systemController.sysj line: 72, column: 20
    modeF2.setPresent();//sysj\systemController.sysj line: 72, column: 36
    currsigs.addElement(modeF2);
    modeF2.setValue(0);//sysj\systemController.sysj line: 72, column: 36
    modeLL.setPresent();//sysj\systemController.sysj line: 73, column: 4
    currsigs.addElement(modeLL);
    modeLL.setValue(0);//sysj\systemController.sysj line: 73, column: 4
    modeCP.setPresent();//sysj\systemController.sysj line: 73, column: 20
    currsigs.addElement(modeCP);
    modeCP.setValue(0);//sysj\systemController.sysj line: 73, column: 20
    modeLB.setPresent();//sysj\systemController.sysj line: 73, column: 36
    currsigs.addElement(modeLB);
    modeLB.setValue(0);//sysj\systemController.sysj line: 73, column: 36
    modeSP.setPresent();//sysj\systemController.sysj line: 74, column: 4
    currsigs.addElement(modeSP);
    modeSP.setValue(0);//sysj\systemController.sysj line: 74, column: 4
    modeRC.setPresent();//sysj\systemController.sysj line: 74, column: 20
    currsigs.addElement(modeRC);
    modeRC.setValue(0);//sysj\systemController.sysj line: 74, column: 20
    modeLR.setPresent();//sysj\systemController.sysj line: 74, column: 36
    currsigs.addElement(modeLR);
    modeLR.setValue(0);//sysj\systemController.sysj line: 74, column: 36
    modeLD.setPresent();//sysj\systemController.sysj line: 75, column: 4
    currsigs.addElement(modeLD);
    modeLD.setValue(0);//sysj\systemController.sysj line: 75, column: 4
    modeBR.setPresent();//sysj\systemController.sysj line: 75, column: 20
    currsigs.addElement(modeBR);
    modeBR.setValue(0);//sysj\systemController.sysj line: 75, column: 20
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
      switch(S4726){
        case 0 : 
          S4726=0;
          break RUN;
        
        case 1 : 
          S4726=2;
          S4726=2;
          thread4728(tdone,ends);
          thread4729(tdone,ends);
          thread4730(tdone,ends);
          thread4731(tdone,ends);
          int biggest4732 = 0;
          if(ends[2]>=biggest4732){
            biggest4732=ends[2];
          }
          if(ends[3]>=biggest4732){
            biggest4732=ends[3];
          }
          if(ends[4]>=biggest4732){
            biggest4732=ends[4];
          }
          if(ends[5]>=biggest4732){
            biggest4732=ends[5];
          }
          if(biggest4732 == 1){
=======
      switch(S212150){
        case 0 : 
          S212150=0;
          break RUN;
        
        case 1 : 
          S212150=2;
          S212150=2;
          thread212152(tdone,ends);
          thread212153(tdone,ends);
          thread212154(tdone,ends);
          thread212155(tdone,ends);
          thread212156(tdone,ends);
          thread212157(tdone,ends);
          thread212158(tdone,ends);
          thread212159(tdone,ends);
          thread212160(tdone,ends);
          thread212161(tdone,ends);
          int biggest212162 = 0;
          if(ends[2]>=biggest212162){
            biggest212162=ends[2];
          }
          if(ends[3]>=biggest212162){
            biggest212162=ends[3];
          }
          if(ends[4]>=biggest212162){
            biggest212162=ends[4];
          }
          if(ends[5]>=biggest212162){
            biggest212162=ends[5];
          }
          if(ends[6]>=biggest212162){
            biggest212162=ends[6];
          }
          if(ends[7]>=biggest212162){
            biggest212162=ends[7];
          }
          if(ends[8]>=biggest212162){
            biggest212162=ends[8];
          }
          if(ends[9]>=biggest212162){
            biggest212162=ends[9];
          }
          if(ends[10]>=biggest212162){
            biggest212162=ends[10];
          }
          if(ends[11]>=biggest212162){
            biggest212162=ends[11];
          }
          if(biggest212162 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
<<<<<<< Updated upstream
          thread4733(tdone,ends);
          thread4734(tdone,ends);
          thread4735(tdone,ends);
          thread4736(tdone,ends);
          int biggest4737 = 0;
          if(ends[2]>=biggest4737){
            biggest4737=ends[2];
          }
          if(ends[3]>=biggest4737){
            biggest4737=ends[3];
          }
          if(ends[4]>=biggest4737){
            biggest4737=ends[4];
          }
          if(ends[5]>=biggest4737){
            biggest4737=ends[5];
          }
          if(biggest4737 == 1){
=======
          thread212163(tdone,ends);
          thread212164(tdone,ends);
          thread212165(tdone,ends);
          thread212166(tdone,ends);
          thread212167(tdone,ends);
          thread212168(tdone,ends);
          thread212169(tdone,ends);
          thread212170(tdone,ends);
          thread212171(tdone,ends);
          thread212172(tdone,ends);
          int biggest212173 = 0;
          if(ends[2]>=biggest212173){
            biggest212173=ends[2];
          }
          if(ends[3]>=biggest212173){
            biggest212173=ends[3];
          }
          if(ends[4]>=biggest212173){
            biggest212173=ends[4];
          }
          if(ends[5]>=biggest212173){
            biggest212173=ends[5];
          }
          if(ends[6]>=biggest212173){
            biggest212173=ends[6];
          }
          if(ends[7]>=biggest212173){
            biggest212173=ends[7];
          }
          if(ends[8]>=biggest212173){
            biggest212173=ends[8];
          }
          if(ends[9]>=biggest212173){
            biggest212173=ends[9];
          }
          if(ends[10]>=biggest212173){
            biggest212173=ends[10];
          }
          if(ends[11]>=biggest212173){
            biggest212173=ends[11];
          }
          if(biggest212173 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
<<<<<<< Updated upstream
          if(biggest4737 == 0){
            S4726=0;
            active[1]=0;
            ends[1]=0;
            S4726=0;
=======
          if(biggest212173 == 0){
            S212150=0;
            active[1]=0;
            ends[1]=0;
            S212150=0;
>>>>>>> Stashed changes
            break RUN;
          }
        
      }
    }
  }

  public void init(){
<<<<<<< Updated upstream
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
=======
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
          bottleLoaded.gethook();
          bottleAtLabeller.gethook();
=======
          loadAck_in.gethook();
          bottleDone_in.gethook();
          labelDone_in.gethook();
          bottleRecycled_in.gethook();
          loadOrder_o.gethook();
          labelBottle_o.gethook();
          bottleRejected_o.gethook();
          purchaseOrder.gethook();
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
>>>>>>> Stashed changes
          df = true;
        }
        runClockDomain();
      }
<<<<<<< Updated upstream
      bottleLoaded.setpreclear();
      bottleAtLabeller.setpreclear();
      mode.setpreclear();
      bottleLoad.setpreclear();
=======
      purchaseOrder.setpreclear();
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
      productionStatus.setpreclear();
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
>>>>>>> Stashed changes
      enableBL.setpreclear();
      enableCV.setpreclear();
      enableRT.setpreclear();
      enableST.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
<<<<<<< Updated upstream
      dummyint = bottleLoaded.getStatus() ? bottleLoaded.setprepresent() : bottleLoaded.setpreclear();
      bottleLoaded.setpreval(bottleLoaded.getValue());
      bottleLoaded.setClear();
      dummyint = bottleAtLabeller.getStatus() ? bottleAtLabeller.setprepresent() : bottleAtLabeller.setpreclear();
      bottleAtLabeller.setpreval(bottleAtLabeller.getValue());
      bottleAtLabeller.setClear();
      mode.sethook();
      mode.setClear();
      bottleLoad.sethook();
      bottleLoad.setClear();
=======
      dummyint = purchaseOrder.getStatus() ? purchaseOrder.setprepresent() : purchaseOrder.setpreclear();
      purchaseOrder.setpreval(purchaseOrder.getValue());
      purchaseOrder.setClear();
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
      productionStatus.sethook();
      productionStatus.setClear();
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
>>>>>>> Stashed changes
      enableBL.sethook();
      enableBL.setClear();
      enableCV.sethook();
      enableCV.setClear();
      enableRT.sethook();
      enableRT.setClear();
<<<<<<< Updated upstream
      enableST.sethook();
      enableST.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleLoaded.gethook();
        bottleAtLabeller.gethook();
=======
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
      loadAck_in.sethook();
      bottleDone_in.sethook();
      labelDone_in.sethook();
      bottleRecycled_in.sethook();
      loadOrder_o.sethook();
      labelBottle_o.sethook();
      bottleRejected_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        loadAck_in.gethook();
        bottleDone_in.gethook();
        labelDone_in.gethook();
        bottleRecycled_in.gethook();
        loadOrder_o.gethook();
        labelBottle_o.gethook();
        bottleRejected_o.gethook();
        purchaseOrder.gethook();
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
>>>>>>> Stashed changes
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
