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
  public Signal purchaseOrder = new Signal("purchaseOrder", Signal.INPUT);
  public Signal guiCommand = new Signal("guiCommand", Signal.INPUT);
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
  public Signal guiStatus = new Signal("guiStatus", Signal.OUTPUT);
  public Signal permitRT = new Signal("permitRT", Signal.OUTPUT);
  public Signal permitF1 = new Signal("permitF1", Signal.OUTPUT);
  public Signal permitF2 = new Signal("permitF2", Signal.OUTPUT);
  public Signal permitLL = new Signal("permitLL", Signal.OUTPUT);
  public Signal permitCP = new Signal("permitCP", Signal.OUTPUT);
  public Signal permitCV = new Signal("permitCV", Signal.OUTPUT);
  public Signal permitLB = new Signal("permitLB", Signal.OUTPUT);
  public Signal permitRC = new Signal("permitRC", Signal.OUTPUT);
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
  private GuiPermit permits_thread_4;//sysj\systemController.sysj line: 94, column: 9
  private PosOrderStatus feedback_thread_4;//sysj\systemController.sysj line: 95, column: 9
  private WorkpieceTwin w_thread_5;//sysj\systemController.sysj line: 110, column: 3
  private WorkpieceTwin w_thread_7;//sysj\systemController.sysj line: 137, column: 3
  private WorkpieceTwin w_thread_8;//sysj\systemController.sysj line: 158, column: 3
  private int done_thread_8;//sysj\systemController.sysj line: 159, column: 3
  private ABSTwin plant_thread_9;//sysj\systemController.sysj line: 192, column: 3
  private TwinPublisher out_thread_9;//sysj\systemController.sysj line: 193, column: 3
  private WorkpieceTwin w_thread_10;//sysj\systemController.sysj line: 223, column: 3
  private int recovered_thread_10;//sysj\systemController.sysj line: 224, column: 3
  private int last_thread_11;//sysj\systemController.sysj line: 239, column: 3
  private int v_thread_11;//sysj\systemController.sysj line: 240, column: 3
  private int S231287 = 1;
  private int S226521 = 1;
  private int S226526 = 1;
  private int S226588 = 1;
  private int S226529 = 1;
  private int S227148 = 1;
  private int S226589 = 1;
  private int S226597 = 1;
  private int S226592 = 1;
  private int S227219 = 1;
  private int S227171 = 1;
  private int S227155 = 1;
  private int S227150 = 1;
  private int S228115 = 1;
  private int S227242 = 1;
  private int S227226 = 1;
  private int S227221 = 1;
  private int S227265 = 1;
  private int S227260 = 1;
  private int S229383 = 1;
  private int S228139 = 1;
  private int S228123 = 1;
  private int S228118 = 1;
  private int S228146 = 1;
  private int S228141 = 1;
  private int S231125 = 1;
  private int S231265 = 1;
  private int S231149 = 1;
  private int S231133 = 1;
  private int S231128 = 1;
  private int S231285 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread231309(int [] tdone, int [] ends){
        switch(S231285){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 242, column: 12
          v_thread_11 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 243, column: 5
          if(v_thread_11 != last_thread_11) {//sysj\systemController.sysj line: 244, column: 18
            if(v_thread_11 == 0) {//sysj\systemController.sysj line: 245, column: 16
              System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 245, column: 18
            }
            if(v_thread_11 == 1) {//sysj\systemController.sysj line: 246, column: 16
              System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 246, column: 18
            }
            if(v_thread_11 == 2) {//sysj\systemController.sysj line: 247, column: 16
              System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 247, column: 18
            }
            if(v_thread_11 == 3) {//sysj\systemController.sysj line: 248, column: 16
              System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 248, column: 18
            }
            last_thread_11 = v_thread_11;//sysj\systemController.sysj line: 249, column: 6
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

  public void thread231308(int [] tdone, int [] ends){
        switch(S231265){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S231149){
          case 0 : 
            switch(S231133){
              case 0 : 
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 226, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                  S231133=1;
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                else {
                  switch(S231128){
                    case 0 : 
                      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 226, column: 4
                        S231128=1;
                        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                          ends[10]=2;
                          ;//sysj\systemController.sysj line: 226, column: 4
                          w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 227, column: 4
                          recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 228, column: 4
                          System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 229, column: 4
                          OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 231, column: 4
                          S231149=1;
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
                      if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                        bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                        ends[10]=2;
                        ;//sysj\systemController.sysj line: 226, column: 4
                        w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 227, column: 4
                        recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 228, column: 4
                        System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 229, column: 4
                        OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 231, column: 4
                        S231149=1;
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
                S231133=1;
                S231133=0;
                if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 226, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                  S231133=1;
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                else {
                  S231128=0;
                  if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                    bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 226, column: 4
                    S231128=1;
                    if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                      ends[10]=2;
                      ;//sysj\systemController.sysj line: 226, column: 4
                      w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 227, column: 4
                      recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 228, column: 4
                      System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 229, column: 4
                      OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 231, column: 4
                      S231149=1;
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
            S231149=1;
            S231149=0;
            S231133=0;
            if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 226, column: 4
              bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
              S231133=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S231128=0;
              if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 226, column: 4
                S231128=1;
                if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
                  bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
                  ends[10]=2;
                  ;//sysj\systemController.sysj line: 226, column: 4
                  w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 227, column: 4
                  recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 228, column: 4
                  System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 229, column: 4
                  OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 231, column: 4
                  S231149=1;
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

  public void thread231307(int [] tdone, int [] ends){
        switch(S231125){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        PlantClock.advance();//sysj\systemController.sysj line: 196, column: 4
        if(twinBL.getprestatus()){//sysj\systemController.sysj line: 198, column: 12
          plant_thread_9.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 198, column: 21
          if(twinCV.getprestatus()){//sysj\systemController.sysj line: 199, column: 12
            plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 199, column: 21
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
          if(twinCV.getprestatus()){//sysj\systemController.sysj line: 199, column: 12
            plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 199, column: 21
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
            if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
              plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
              if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
                plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
                GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
              }
              else {
                if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
                  plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
                  GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                }
                else {
                  if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                    plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                  }
                  else {
                    if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                      plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                    }
                    else {
                      if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                        plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                        active[9]=1;
                        ends[9]=1;
                        tdone[9]=1;
                      }
                      else {
                        plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                        plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                        TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                        out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                        GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                        guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                        currsigs.addElement(guiStatus);
                        guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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

  public void thread231306(int [] tdone, int [] ends){
        switch(S229383){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S228139){
          case 0 : 
            switch(S228123){
              case 0 : 
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 161, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                  S228123=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  switch(S228118){
                    case 0 : 
                      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                        labelDone_in.setACK(true);//sysj\systemController.sysj line: 161, column: 4
                        S228118=1;
                        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                          labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 161, column: 4
                          w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 162, column: 4
                          S228139=1;
                          if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 164, column: 4
                            System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 165, column: 5
                            S228146=0;
                            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                              S228146=1;
                              active[8]=1;
                              ends[8]=1;
                              tdone[8]=1;
                            }
                            else {
                              S228141=0;
                              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                                bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                                S228141=1;
                                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                                  ends[8]=2;
                                  ;//sysj\systemController.sysj line: 167, column: 5
                                  S228139=2;
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
                            w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 172, column: 5
                            w_thread_8.seal();//sysj\systemController.sysj line: 173, column: 5
                            BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 174, column: 5
                            done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 175, column: 5
                            System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 176, column: 5
                            OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 179, column: 5
                            S228139=2;
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
                      if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                        labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                        ends[8]=2;
                        ;//sysj\systemController.sysj line: 161, column: 4
                        w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 162, column: 4
                        S228139=1;
                        if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 164, column: 4
                          System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 165, column: 5
                          S228146=0;
                          if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                            bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                            S228146=1;
                            active[8]=1;
                            ends[8]=1;
                            tdone[8]=1;
                          }
                          else {
                            S228141=0;
                            if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                              bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                              S228141=1;
                              if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                                bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                                ends[8]=2;
                                ;//sysj\systemController.sysj line: 167, column: 5
                                S228139=2;
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
                          w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 172, column: 5
                          w_thread_8.seal();//sysj\systemController.sysj line: 173, column: 5
                          BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 174, column: 5
                          done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 175, column: 5
                          System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 176, column: 5
                          OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 179, column: 5
                          S228139=2;
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
                S228123=1;
                S228123=0;
                if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 161, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                  S228123=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S228118=0;
                  if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                    labelDone_in.setACK(true);//sysj\systemController.sysj line: 161, column: 4
                    S228118=1;
                    if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                      labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                      ends[8]=2;
                      ;//sysj\systemController.sysj line: 161, column: 4
                      w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 162, column: 4
                      S228139=1;
                      if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 164, column: 4
                        System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 165, column: 5
                        S228146=0;
                        if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                          S228146=1;
                          active[8]=1;
                          ends[8]=1;
                          tdone[8]=1;
                        }
                        else {
                          S228141=0;
                          if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                            bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                            S228141=1;
                            if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                              ends[8]=2;
                              ;//sysj\systemController.sysj line: 167, column: 5
                              S228139=2;
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
                        w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 172, column: 5
                        w_thread_8.seal();//sysj\systemController.sysj line: 173, column: 5
                        BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 174, column: 5
                        done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 175, column: 5
                        System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 176, column: 5
                        OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 179, column: 5
                        S228139=2;
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
            switch(S228146){
              case 0 : 
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                  S228146=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  switch(S228141){
                    case 0 : 
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                        bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                        S228141=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 167, column: 5
                          S228139=2;
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
                      if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                        bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                        ends[8]=2;
                        ;//sysj\systemController.sysj line: 167, column: 5
                        S228139=2;
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
                S228146=1;
                S228146=0;
                if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                  S228146=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S228141=0;
                  if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                    bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                    S228141=1;
                    if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                      ends[8]=2;
                      ;//sysj\systemController.sysj line: 167, column: 5
                      S228139=2;
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
            S228139=2;
            S228139=0;
            S228123=0;
            if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 161, column: 4
              labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
              S228123=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S228118=0;
              if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                labelDone_in.setACK(true);//sysj\systemController.sysj line: 161, column: 4
                S228118=1;
                if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
                  labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
                  ends[8]=2;
                  ;//sysj\systemController.sysj line: 161, column: 4
                  w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 162, column: 4
                  S228139=1;
                  if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 164, column: 4
                    System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 165, column: 5
                    S228146=0;
                    if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
                      bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                      S228146=1;
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      S228141=0;
                      if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                        bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                        S228141=1;
                        if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                          bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                          ends[8]=2;
                          ;//sysj\systemController.sysj line: 167, column: 5
                          S228139=2;
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
                    w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 172, column: 5
                    w_thread_8.seal();//sysj\systemController.sysj line: 173, column: 5
                    BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 174, column: 5
                    done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 175, column: 5
                    System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 176, column: 5
                    OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 179, column: 5
                    S228139=2;
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

  public void thread231305(int [] tdone, int [] ends){
        switch(S228115){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S227242){
          case 0 : 
            switch(S227226){
              case 0 : 
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                  S227226=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S227221){
                    case 0 : 
                      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 139, column: 4
                        S227221=1;
                        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 139, column: 4
                          w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 140, column: 4
                          S227242=1;
                          if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            ends[7]=2;
                            ;//sysj\systemController.sysj line: 141, column: 13
                            S227242=2;
                            S227265=0;
                            if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                              labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                              S227265=1;
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              S227260=0;
                              if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                                labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                                S227260=1;
                                if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                                  ends[7]=2;
                                  ;//sysj\systemController.sysj line: 147, column: 4
                                  S227242=3;
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
                      if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                        bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 139, column: 4
                        w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 140, column: 4
                        S227242=1;
                        if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 141, column: 13
                          S227242=2;
                          S227265=0;
                          if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                            labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                            S227265=1;
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            S227260=0;
                            if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                              labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                              S227260=1;
                              if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                                ends[7]=2;
                                ;//sysj\systemController.sysj line: 147, column: 4
                                S227242=3;
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
                S227226=1;
                S227226=0;
                if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                  S227226=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S227221=0;
                  if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                    bottleDone_in.setACK(true);//sysj\systemController.sysj line: 139, column: 4
                    S227221=1;
                    if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 139, column: 4
                      w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 140, column: 4
                      S227242=1;
                      if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 141, column: 13
                        S227242=2;
                        S227265=0;
                        if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                          S227265=1;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          S227260=0;
                          if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                            labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                            S227260=1;
                            if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                              labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                              ends[7]=2;
                              ;//sysj\systemController.sysj line: 147, column: 4
                              S227242=3;
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
            if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              ends[7]=2;
              ;//sysj\systemController.sysj line: 141, column: 13
              S227242=2;
              S227265=0;
              if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                S227265=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S227260=0;
                if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                  labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                  S227260=1;
                  if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                    labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                    ends[7]=2;
                    ;//sysj\systemController.sysj line: 147, column: 4
                    S227242=3;
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
            break;
          
          case 2 : 
            switch(S227265){
              case 0 : 
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                  S227265=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S227260){
                    case 0 : 
                      if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                        labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                        S227260=1;
                        if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 147, column: 4
                          S227242=3;
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
                      if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                        labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                        ends[7]=2;
                        ;//sysj\systemController.sysj line: 147, column: 4
                        S227242=3;
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
                S227265=1;
                S227265=0;
                if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                  S227265=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S227260=0;
                  if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                    labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                    S227260=1;
                    if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                      labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                      ends[7]=2;
                      ;//sysj\systemController.sysj line: 147, column: 4
                      S227242=3;
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
          
          case 3 : 
            S227242=3;
            S227242=0;
            S227226=0;
            if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
              bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
              S227226=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S227221=0;
              if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                bottleDone_in.setACK(true);//sysj\systemController.sysj line: 139, column: 4
                S227221=1;
                if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
                  bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 139, column: 4
                  w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 140, column: 4
                  S227242=1;
                  if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    ends[7]=2;
                    ;//sysj\systemController.sysj line: 141, column: 13
                    S227242=2;
                    S227265=0;
                    if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
                      labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                      S227265=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S227260=0;
                      if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                        labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                        S227260=1;
                        if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                          labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                          ends[7]=2;
                          ;//sysj\systemController.sysj line: 147, column: 4
                          S227242=3;
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

  public void thread231304(int [] tdone, int [] ends){
        switch(S227219){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S227171){
          case 0 : 
            switch(S227155){
              case 0 : 
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 125, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                  S227155=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  switch(S227150){
                    case 0 : 
                      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                        loadAck_in.setACK(true);//sysj\systemController.sysj line: 125, column: 4
                        S227150=1;
                        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                          loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                          ends[6]=2;
                          ;//sysj\systemController.sysj line: 125, column: 4
                          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 126, column: 4
                          S227171=1;
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
                      if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                        loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                        ends[6]=2;
                        ;//sysj\systemController.sysj line: 125, column: 4
                        System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 126, column: 4
                        S227171=1;
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
                S227155=1;
                S227155=0;
                if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 125, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                  S227155=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S227150=0;
                  if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                    loadAck_in.setACK(true);//sysj\systemController.sysj line: 125, column: 4
                    S227150=1;
                    if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                      loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                      ends[6]=2;
                      ;//sysj\systemController.sysj line: 125, column: 4
                      System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 126, column: 4
                      S227171=1;
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
            S227171=1;
            S227171=0;
            S227155=0;
            if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 125, column: 4
              loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
              S227155=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S227150=0;
              if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                loadAck_in.setACK(true);//sysj\systemController.sysj line: 125, column: 4
                S227150=1;
                if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
                  loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
                  ends[6]=2;
                  ;//sysj\systemController.sysj line: 125, column: 4
                  System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 126, column: 4
                  S227171=1;
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

  public void thread231303(int [] tdone, int [] ends){
        switch(S227148){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S226589){
          case 0 : 
            switch(S226597){
              case 0 : 
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 117, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                  S226597=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S226592){
                    case 0 : 
                      if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                        loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 117, column: 4
                        S226592=1;
                        if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                          loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                          ends[5]=2;
                          ;//sysj\systemController.sysj line: 117, column: 4
                          S226589=1;
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
                      if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                        ends[5]=2;
                        ;//sysj\systemController.sysj line: 117, column: 4
                        S226589=1;
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
                S226597=1;
                S226597=0;
                if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 117, column: 4
                  loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                  S226597=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S226592=0;
                  if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                    loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 117, column: 4
                    S226592=1;
                    if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                      loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                      ends[5]=2;
                      ;//sysj\systemController.sysj line: 117, column: 4
                      S226589=1;
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
            S226589=1;
            w_thread_5 = null;//sysj\systemController.sysj line: 112, column: 4
            if(GuiSupervisor.canLoad()) {//sysj\systemController.sysj line: 113, column: 40
              w_thread_5 = OrderBook.nextBottle();//sysj\systemController.sysj line: 113, column: 42
            }
            S226589=0;
            if(w_thread_5 != null){//sysj\systemController.sysj line: 114, column: 16
              System.out.println("[SC] Loading " + w_thread_5 + ".");//sysj\systemController.sysj line: 115, column: 4
              TwinRegistry.shared().admit(w_thread_5);//sysj\systemController.sysj line: 116, column: 4
              S226597=0;
              if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 117, column: 4
                loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                S226597=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S226592=0;
                if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                  loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 117, column: 4
                  S226592=1;
                  if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
                    loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
                    ends[5]=2;
                    ;//sysj\systemController.sysj line: 117, column: 4
                    S226589=1;
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
              S226589=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread231302(int [] tdone, int [] ends){
        switch(S226588){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S226529){
          case 0 : 
            S226529=0;
            if(guiCommand.getprestatus()){//sysj\systemController.sysj line: 97, column: 21
              GuiSupervisor.command((GuiCommand)(guiCommand.getpreval() == null ? null : ((GuiCommand)guiCommand.getpreval())));//sysj\systemController.sysj line: 97, column: 34
              permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
              permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
              currsigs.addElement(permitRT);
              permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
              permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
              currsigs.addElement(permitF1);
              permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
              permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
              currsigs.addElement(permitF2);
              permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
              permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
              currsigs.addElement(permitLL);
              permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
              permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
              currsigs.addElement(permitCP);
              permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
              permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
              currsigs.addElement(permitCV);
              permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
              permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
              currsigs.addElement(permitLB);
              permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
              permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
              currsigs.addElement(permitRC);
              permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
              if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
                OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
            }
            else {
              permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
              permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
              currsigs.addElement(permitRT);
              permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
              permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
              currsigs.addElement(permitF1);
              permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
              permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
              currsigs.addElement(permitF2);
              permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
              permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
              currsigs.addElement(permitLL);
              permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
              permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
              currsigs.addElement(permitCP);
              permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
              permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
              currsigs.addElement(permitCV);
              permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
              permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
              currsigs.addElement(permitLB);
              permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
              permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
              currsigs.addElement(permitRC);
              permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
              if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
                OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
            }
            break;
          
          case 1 : 
            S226529=1;
            S226529=0;
            if(guiCommand.getprestatus()){//sysj\systemController.sysj line: 97, column: 21
              GuiSupervisor.command((GuiCommand)(guiCommand.getpreval() == null ? null : ((GuiCommand)guiCommand.getpreval())));//sysj\systemController.sysj line: 97, column: 34
              permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
              permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
              currsigs.addElement(permitRT);
              permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
              permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
              currsigs.addElement(permitF1);
              permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
              permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
              currsigs.addElement(permitF2);
              permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
              permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
              currsigs.addElement(permitLL);
              permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
              permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
              currsigs.addElement(permitCP);
              permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
              permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
              currsigs.addElement(permitCV);
              permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
              permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
              currsigs.addElement(permitLB);
              permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
              permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
              currsigs.addElement(permitRC);
              permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
              if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
                OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
            }
            else {
              permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
              permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
              currsigs.addElement(permitRT);
              permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
              permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
              currsigs.addElement(permitF1);
              permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
              permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
              currsigs.addElement(permitF2);
              permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
              permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
              currsigs.addElement(permitLL);
              permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
              permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
              currsigs.addElement(permitCP);
              permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
              permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
              currsigs.addElement(permitCV);
              permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
              permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
              currsigs.addElement(permitLB);
              permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
              permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
              currsigs.addElement(permitRC);
              permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
              if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
                OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
                if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
                  productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
                  currsigs.addElement(productionStatus);
                  productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S226529=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread231301(int [] tdone, int [] ends){
        switch(S226526){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj\systemController.sysj line: 85, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 85, column: 19
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 85, column: 34
        currsigs.addElement(enableRT);
        enableF1.setPresent();//sysj\systemController.sysj line: 86, column: 4
        currsigs.addElement(enableF1);
        enableF2.setPresent();//sysj\systemController.sysj line: 86, column: 19
        currsigs.addElement(enableF2);
        enableLL.setPresent();//sysj\systemController.sysj line: 86, column: 34
        currsigs.addElement(enableLL);
        enableCP.setPresent();//sysj\systemController.sysj line: 86, column: 49
        currsigs.addElement(enableCP);
        enableLB.setPresent();//sysj\systemController.sysj line: 86, column: 64
        currsigs.addElement(enableLB);
        enableSP.setPresent();//sysj\systemController.sysj line: 87, column: 4
        currsigs.addElement(enableSP);
        enableRC.setPresent();//sysj\systemController.sysj line: 87, column: 19
        currsigs.addElement(enableRC);
        enableLR.setPresent();//sysj\systemController.sysj line: 87, column: 34
        currsigs.addElement(enableLR);
        enableLD.setPresent();//sysj\systemController.sysj line: 88, column: 4
        currsigs.addElement(enableLD);
        enableBR.setPresent();//sysj\systemController.sysj line: 88, column: 19
        currsigs.addElement(enableBR);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread231300(int [] tdone, int [] ends){
        switch(S226521){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        modeBL.setPresent();//sysj\systemController.sysj line: 75, column: 4
        currsigs.addElement(modeBL);
        modeBL.setValue(0);//sysj\systemController.sysj line: 75, column: 4
        modeF1.setPresent();//sysj\systemController.sysj line: 75, column: 20
        currsigs.addElement(modeF1);
        modeF1.setValue(0);//sysj\systemController.sysj line: 75, column: 20
        modeF2.setPresent();//sysj\systemController.sysj line: 75, column: 36
        currsigs.addElement(modeF2);
        modeF2.setValue(0);//sysj\systemController.sysj line: 75, column: 36
        modeLL.setPresent();//sysj\systemController.sysj line: 76, column: 4
        currsigs.addElement(modeLL);
        modeLL.setValue(0);//sysj\systemController.sysj line: 76, column: 4
        modeCP.setPresent();//sysj\systemController.sysj line: 76, column: 20
        currsigs.addElement(modeCP);
        modeCP.setValue(0);//sysj\systemController.sysj line: 76, column: 20
        modeLB.setPresent();//sysj\systemController.sysj line: 76, column: 36
        currsigs.addElement(modeLB);
        modeLB.setValue(0);//sysj\systemController.sysj line: 76, column: 36
        modeSP.setPresent();//sysj\systemController.sysj line: 77, column: 4
        currsigs.addElement(modeSP);
        modeSP.setValue(0);//sysj\systemController.sysj line: 77, column: 4
        modeRC.setPresent();//sysj\systemController.sysj line: 77, column: 20
        currsigs.addElement(modeRC);
        modeRC.setValue(0);//sysj\systemController.sysj line: 77, column: 20
        modeLR.setPresent();//sysj\systemController.sysj line: 77, column: 36
        currsigs.addElement(modeLR);
        modeLR.setValue(0);//sysj\systemController.sysj line: 77, column: 36
        modeLD.setPresent();//sysj\systemController.sysj line: 78, column: 4
        currsigs.addElement(modeLD);
        modeLD.setValue(0);//sysj\systemController.sysj line: 78, column: 4
        modeBR.setPresent();//sysj\systemController.sysj line: 78, column: 20
        currsigs.addElement(modeBR);
        modeBR.setValue(0);//sysj\systemController.sysj line: 78, column: 20
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread231298(int [] tdone, int [] ends){
        S231285=1;
    last_thread_11 = -1;//sysj\systemController.sysj line: 239, column: 3
    v_thread_11 = 0;//sysj\systemController.sysj line: 240, column: 3
    if(recyclingStatus.getprestatus()){//sysj\systemController.sysj line: 242, column: 12
      v_thread_11 = ((Integer)(recyclingStatus.getpreval() == null ? null : ((Integer)recyclingStatus.getpreval()))).intValue();//sysj\systemController.sysj line: 243, column: 5
      if(v_thread_11 != last_thread_11) {//sysj\systemController.sysj line: 244, column: 18
        if(v_thread_11 == 0) {//sysj\systemController.sysj line: 245, column: 16
          System.out.println("[SC] Recycling Station: idle.");//sysj\systemController.sysj line: 245, column: 18
        }
        if(v_thread_11 == 1) {//sysj\systemController.sysj line: 246, column: 16
          System.out.println("[SC] Recycling Station: busy.");//sysj\systemController.sysj line: 246, column: 18
        }
        if(v_thread_11 == 2) {//sysj\systemController.sysj line: 247, column: 16
          System.out.println("[SC] Recycling Station: FAULT - no further rejects accepted.");//sysj\systemController.sysj line: 247, column: 18
        }
        if(v_thread_11 == 3) {//sysj\systemController.sysj line: 248, column: 16
          System.out.println("[SC] Recycling Station: running, bin or tank near capacity.");//sysj\systemController.sysj line: 248, column: 18
        }
        last_thread_11 = v_thread_11;//sysj\systemController.sysj line: 249, column: 6
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

  public void thread231297(int [] tdone, int [] ends){
        S231265=1;
    w_thread_10 = null;//sysj\systemController.sysj line: 223, column: 3
    recovered_thread_10 = 0;//sysj\systemController.sysj line: 224, column: 3
    S231149=0;
    S231133=0;
    if(!bottleRecycled_in.isPartnerPresent() || bottleRecycled_in.isPartnerPreempted()){//sysj\systemController.sysj line: 226, column: 4
      bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
      S231133=1;
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      S231128=0;
      if(!bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
        bottleRecycled_in.setACK(true);//sysj\systemController.sysj line: 226, column: 4
        S231128=1;
        if(bottleRecycled_in.isREQ()){//sysj\systemController.sysj line: 226, column: 4
          bottleRecycled_in.setACK(false);//sysj\systemController.sysj line: 226, column: 4
          ends[10]=2;
          ;//sysj\systemController.sysj line: 226, column: 4
          w_thread_10 = (WorkpieceTwin)(bottleRecycled_in.getVal() == null ? null : ((WorkpieceTwin)bottleRecycled_in.getVal()));//sysj\systemController.sysj line: 227, column: 4
          recovered_thread_10 = recovered_thread_10 + 1;//sysj\systemController.sysj line: 228, column: 4
          System.out.println("[SC] " + w_thread_10 + " recovered by the Recycling Station at " + w_thread_10.filledMl() + "ml, sealed=" + w_thread_10.isSealed() + ". " + recovered_thread_10 + " recycled.");//sysj\systemController.sysj line: 229, column: 4
          OrderBook.recycled(w_thread_10);//sysj\systemController.sysj line: 231, column: 4
          S231149=1;
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

  public void thread231296(int [] tdone, int [] ends){
        S231125=1;
    plant_thread_9 = new ABSTwin();//sysj\systemController.sysj line: 192, column: 3
    out_thread_9 = TwinPublisher.shared();//sysj\systemController.sysj line: 193, column: 3
    PlantClock.advance();//sysj\systemController.sysj line: 196, column: 4
    if(twinBL.getprestatus()){//sysj\systemController.sysj line: 198, column: 12
      plant_thread_9.put((LoaderTwin)(twinBL.getpreval() == null ? null : ((LoaderTwin)twinBL.getpreval())));//sysj\systemController.sysj line: 198, column: 21
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 199, column: 12
        plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 199, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
      if(twinCV.getprestatus()){//sysj\systemController.sysj line: 199, column: 12
        plant_thread_9.put((ConveyorTwin)(twinCV.getpreval() == null ? null : ((ConveyorTwin)twinCV.getpreval())));//sysj\systemController.sysj line: 199, column: 21
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
        if(twinRT.getprestatus()){//sysj\systemController.sysj line: 200, column: 12
          plant_thread_9.put((RotaryTableTwin)(twinRT.getpreval() == null ? null : ((RotaryTableTwin)twinRT.getpreval())));//sysj\systemController.sysj line: 200, column: 21
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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
          if(twinF1.getprestatus()){//sysj\systemController.sysj line: 201, column: 12
            plant_thread_9.put((FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 21
            GuiTelemetry.noteMachine("FILLER1", (FillerTwin)(twinF1.getpreval() == null ? null : ((FillerTwin)twinF1.getpreval())));//sysj\systemController.sysj line: 201, column: 53
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
          }
          else {
            if(twinF2.getprestatus()){//sysj\systemController.sysj line: 202, column: 12
              plant_thread_9.put((FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 21
              GuiTelemetry.noteMachine("FILLER2", (FillerTwin)(twinF2.getpreval() == null ? null : ((FillerTwin)twinF2.getpreval())));//sysj\systemController.sysj line: 202, column: 53
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
            }
            else {
              if(twinLL.getprestatus()){//sysj\systemController.sysj line: 203, column: 12
                plant_thread_9.put((LidLoaderTwin)(twinLL.getpreval() == null ? null : ((LidLoaderTwin)twinLL.getpreval())));//sysj\systemController.sysj line: 203, column: 21
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
              }
              else {
                if(twinCP.getprestatus()){//sysj\systemController.sysj line: 204, column: 12
                  plant_thread_9.put((LidCapperTwin)(twinCP.getpreval() == null ? null : ((LidCapperTwin)twinCP.getpreval())));//sysj\systemController.sysj line: 204, column: 21
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                }
                else {
                  if(twinLB.getprestatus()){//sysj\systemController.sysj line: 205, column: 12
                    plant_thread_9.put((LabellerTwin)(twinLB.getpreval() == null ? null : ((LabellerTwin)twinLB.getpreval())));//sysj\systemController.sysj line: 205, column: 21
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
                    active[9]=1;
                    ends[9]=1;
                    tdone[9]=1;
                  }
                  else {
                    plant_thread_9.setTick(PlantClock.now());//sysj\systemController.sysj line: 207, column: 4
                    plant_thread_9.setMode(LineMode.AUTO);//sysj\systemController.sysj line: 208, column: 4
                    TwinRegistry.shared().fill(plant_thread_9);//sysj\systemController.sysj line: 209, column: 4
                    out_thread_9.publish(plant_thread_9, OrderBook.purchaseOrder());//sysj\systemController.sysj line: 210, column: 4
                    GuiSupervisor.observe(plant_thread_9);//sysj\systemController.sysj line: 211, column: 13
                    guiStatus.setPresent();//sysj\systemController.sysj line: 212, column: 13
                    currsigs.addElement(guiStatus);
                    guiStatus.setValue(GuiTelemetry.capture(plant_thread_9));//sysj\systemController.sysj line: 212, column: 13
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

  public void thread231295(int [] tdone, int [] ends){
        S229383=1;
    w_thread_8 = null;//sysj\systemController.sysj line: 158, column: 3
    done_thread_8 = 0;//sysj\systemController.sysj line: 159, column: 3
    S228139=0;
    S228123=0;
    if(!labelDone_in.isPartnerPresent() || labelDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 161, column: 4
      labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
      S228123=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S228118=0;
      if(!labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
        labelDone_in.setACK(true);//sysj\systemController.sysj line: 161, column: 4
        S228118=1;
        if(labelDone_in.isREQ()){//sysj\systemController.sysj line: 161, column: 4
          labelDone_in.setACK(false);//sysj\systemController.sysj line: 161, column: 4
          ends[8]=2;
          ;//sysj\systemController.sysj line: 161, column: 4
          w_thread_8 = (WorkpieceTwin)(labelDone_in.getVal() == null ? null : ((WorkpieceTwin)labelDone_in.getVal()));//sysj\systemController.sysj line: 162, column: 4
          S228139=1;
          if(w_thread_8.isRejected()){//sysj\systemController.sysj line: 164, column: 4
            System.out.println("[SC] " + w_thread_8 + " refused a label (" + w_thread_8.defect() + "); handing it to the Recycling Station.");//sysj\systemController.sysj line: 165, column: 5
            S228146=0;
            if(!bottleRejected_o.isPartnerPresent() || bottleRejected_o.isPartnerPreempted()){//sysj\systemController.sysj line: 167, column: 5
              bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
              S228146=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S228141=0;
              if(bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                bottleRejected_o.setVal(w_thread_8);//sysj\systemController.sysj line: 167, column: 5
                S228141=1;
                if(!bottleRejected_o.isACK()){//sysj\systemController.sysj line: 167, column: 5
                  bottleRejected_o.setREQ(false);//sysj\systemController.sysj line: 167, column: 5
                  ends[8]=2;
                  ;//sysj\systemController.sysj line: 167, column: 5
                  S228139=2;
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
            w_thread_8.arrived(Machine.BATCH_STORAGE);//sysj\systemController.sysj line: 172, column: 5
            w_thread_8.seal();//sysj\systemController.sysj line: 173, column: 5
            BatchStore.shared().store(w_thread_8);//sysj\systemController.sysj line: 174, column: 5
            done_thread_8 = done_thread_8 + 1;//sysj\systemController.sysj line: 175, column: 5
            System.out.println("[SC] " + w_thread_8 + " labelled " + w_thread_8.serial + " and stored in batch " + w_thread_8.batchId + " (" + BatchStore.shared().held(w_thread_8.batchId) + " on the shelf). " + done_thread_8 + " complete.");//sysj\systemController.sysj line: 176, column: 5
            OrderBook.delivered(w_thread_8);//sysj\systemController.sysj line: 179, column: 5
            S228139=2;
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

  public void thread231294(int [] tdone, int [] ends){
        S228115=1;
    w_thread_7 = null;//sysj\systemController.sysj line: 137, column: 3
    S227242=0;
    S227226=0;
    if(!bottleDone_in.isPartnerPresent() || bottleDone_in.isPartnerPreempted()){//sysj\systemController.sysj line: 139, column: 4
      bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
      S227226=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S227221=0;
      if(!bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
        bottleDone_in.setACK(true);//sysj\systemController.sysj line: 139, column: 4
        S227221=1;
        if(bottleDone_in.isREQ()){//sysj\systemController.sysj line: 139, column: 4
          bottleDone_in.setACK(false);//sysj\systemController.sysj line: 139, column: 4
          ends[7]=2;
          ;//sysj\systemController.sysj line: 139, column: 4
          w_thread_7 = (WorkpieceTwin)(bottleDone_in.getVal() == null ? null : ((WorkpieceTwin)bottleDone_in.getVal()));//sysj\systemController.sysj line: 140, column: 4
          S227242=1;
          if(!GuiSupervisor.qualityAllowed()){//sysj\systemController.sysj line: 141, column: 19
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            ends[7]=2;
            ;//sysj\systemController.sysj line: 141, column: 13
            S227242=2;
            S227265=0;
            if(!labelBottle_o.isPartnerPresent() || labelBottle_o.isPartnerPreempted()){//sysj\systemController.sysj line: 147, column: 4
              labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
              S227265=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S227260=0;
              if(labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                labelBottle_o.setVal(w_thread_7);//sysj\systemController.sysj line: 147, column: 4
                S227260=1;
                if(!labelBottle_o.isACK()){//sysj\systemController.sysj line: 147, column: 4
                  labelBottle_o.setREQ(false);//sysj\systemController.sysj line: 147, column: 4
                  ends[7]=2;
                  ;//sysj\systemController.sysj line: 147, column: 4
                  S227242=3;
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

  public void thread231293(int [] tdone, int [] ends){
        S227219=1;
    S227171=0;
    S227155=0;
    if(!loadAck_in.isPartnerPresent() || loadAck_in.isPartnerPreempted()){//sysj\systemController.sysj line: 125, column: 4
      loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
      S227155=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S227150=0;
      if(!loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
        loadAck_in.setACK(true);//sysj\systemController.sysj line: 125, column: 4
        S227150=1;
        if(loadAck_in.isREQ()){//sysj\systemController.sysj line: 125, column: 4
          loadAck_in.setACK(false);//sysj\systemController.sysj line: 125, column: 4
          ends[6]=2;
          ;//sysj\systemController.sysj line: 125, column: 4
          System.out.println("[SC] " + (WorkpieceTwin)(loadAck_in.getVal() == null ? null : ((WorkpieceTwin)loadAck_in.getVal())) + " is on the conveyor.");//sysj\systemController.sysj line: 126, column: 4
          S227171=1;
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

  public void thread231292(int [] tdone, int [] ends){
        S227148=1;
    w_thread_5 = null;//sysj\systemController.sysj line: 110, column: 3
    w_thread_5 = null;//sysj\systemController.sysj line: 112, column: 4
    if(GuiSupervisor.canLoad()) {//sysj\systemController.sysj line: 113, column: 40
      w_thread_5 = OrderBook.nextBottle();//sysj\systemController.sysj line: 113, column: 42
    }
    S226589=0;
    if(w_thread_5 != null){//sysj\systemController.sysj line: 114, column: 16
      System.out.println("[SC] Loading " + w_thread_5 + ".");//sysj\systemController.sysj line: 115, column: 4
      TwinRegistry.shared().admit(w_thread_5);//sysj\systemController.sysj line: 116, column: 4
      S226597=0;
      if(!loadOrder_o.isPartnerPresent() || loadOrder_o.isPartnerPreempted()){//sysj\systemController.sysj line: 117, column: 4
        loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
        S226597=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S226592=0;
        if(loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
          loadOrder_o.setVal(w_thread_5);//sysj\systemController.sysj line: 117, column: 4
          S226592=1;
          if(!loadOrder_o.isACK()){//sysj\systemController.sysj line: 117, column: 4
            loadOrder_o.setREQ(false);//sysj\systemController.sysj line: 117, column: 4
            ends[5]=2;
            ;//sysj\systemController.sysj line: 117, column: 4
            S226589=1;
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
      S226589=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread231291(int [] tdone, int [] ends){
        S226588=1;
    permits_thread_4 = null;//sysj\systemController.sysj line: 94, column: 9
    feedback_thread_4 = null;//sysj\systemController.sysj line: 95, column: 9
    S226529=0;
    if(guiCommand.getprestatus()){//sysj\systemController.sysj line: 97, column: 21
      GuiSupervisor.command((GuiCommand)(guiCommand.getpreval() == null ? null : ((GuiCommand)guiCommand.getpreval())));//sysj\systemController.sysj line: 97, column: 34
      permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
      permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
      currsigs.addElement(permitRT);
      permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
      permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
      currsigs.addElement(permitF1);
      permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
      permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
      currsigs.addElement(permitF2);
      permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
      permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
      currsigs.addElement(permitLL);
      permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
      permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
      currsigs.addElement(permitCP);
      permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
      permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
      currsigs.addElement(permitCV);
      permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
      permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
      currsigs.addElement(permitLB);
      permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
      permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
      currsigs.addElement(permitRC);
      permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
      if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
        OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
        feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
        if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
          productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
          currsigs.addElement(productionStatus);
          productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
      else {
        feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
        if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
          productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
          currsigs.addElement(productionStatus);
          productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      permits_thread_4 = GuiSupervisor.permits();//sysj\systemController.sysj line: 98, column: 13
      permitRT.setPresent();//sysj\systemController.sysj line: 99, column: 13
      currsigs.addElement(permitRT);
      permitRT.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 13
      permitF1.setPresent();//sysj\systemController.sysj line: 99, column: 37
      currsigs.addElement(permitF1);
      permitF1.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 37
      permitF2.setPresent();//sysj\systemController.sysj line: 99, column: 61
      currsigs.addElement(permitF2);
      permitF2.setValue(permits_thread_4);//sysj\systemController.sysj line: 99, column: 61
      permitLL.setPresent();//sysj\systemController.sysj line: 100, column: 13
      currsigs.addElement(permitLL);
      permitLL.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 13
      permitCP.setPresent();//sysj\systemController.sysj line: 100, column: 37
      currsigs.addElement(permitCP);
      permitCP.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 37
      permitCV.setPresent();//sysj\systemController.sysj line: 100, column: 61
      currsigs.addElement(permitCV);
      permitCV.setValue(permits_thread_4);//sysj\systemController.sysj line: 100, column: 61
      permitLB.setPresent();//sysj\systemController.sysj line: 101, column: 13
      currsigs.addElement(permitLB);
      permitLB.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 13
      permitRC.setPresent();//sysj\systemController.sysj line: 101, column: 37
      currsigs.addElement(permitRC);
      permitRC.setValue(permits_thread_4);//sysj\systemController.sysj line: 101, column: 37
      if(purchaseOrder.getprestatus()){//sysj\systemController.sysj line: 102, column: 21
        OrderBook.accept((PosOrderRequest)(purchaseOrder.getpreval() == null ? null : ((PosOrderRequest)purchaseOrder.getpreval())));//sysj\systemController.sysj line: 102, column: 37
        feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
        if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
          productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
          currsigs.addElement(productionStatus);
          productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
      else {
        feedback_thread_4 = OrderBook.feedback();//sysj\systemController.sysj line: 103, column: 13
        if(feedback_thread_4 != null){//sysj\systemController.sysj line: 104, column: 16
          productionStatus.setPresent();//sysj\systemController.sysj line: 104, column: 35
          currsigs.addElement(productionStatus);
          productionStatus.setValue(feedback_thread_4);//sysj\systemController.sysj line: 104, column: 35
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S226529=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
  }

  public void thread231290(int [] tdone, int [] ends){
        S226526=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 85, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 85, column: 19
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 85, column: 34
    currsigs.addElement(enableRT);
    enableF1.setPresent();//sysj\systemController.sysj line: 86, column: 4
    currsigs.addElement(enableF1);
    enableF2.setPresent();//sysj\systemController.sysj line: 86, column: 19
    currsigs.addElement(enableF2);
    enableLL.setPresent();//sysj\systemController.sysj line: 86, column: 34
    currsigs.addElement(enableLL);
    enableCP.setPresent();//sysj\systemController.sysj line: 86, column: 49
    currsigs.addElement(enableCP);
    enableLB.setPresent();//sysj\systemController.sysj line: 86, column: 64
    currsigs.addElement(enableLB);
    enableSP.setPresent();//sysj\systemController.sysj line: 87, column: 4
    currsigs.addElement(enableSP);
    enableRC.setPresent();//sysj\systemController.sysj line: 87, column: 19
    currsigs.addElement(enableRC);
    enableLR.setPresent();//sysj\systemController.sysj line: 87, column: 34
    currsigs.addElement(enableLR);
    enableLD.setPresent();//sysj\systemController.sysj line: 88, column: 4
    currsigs.addElement(enableLD);
    enableBR.setPresent();//sysj\systemController.sysj line: 88, column: 19
    currsigs.addElement(enableBR);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread231289(int [] tdone, int [] ends){
        S226521=1;
    modeBL.setPresent();//sysj\systemController.sysj line: 75, column: 4
    currsigs.addElement(modeBL);
    modeBL.setValue(0);//sysj\systemController.sysj line: 75, column: 4
    modeF1.setPresent();//sysj\systemController.sysj line: 75, column: 20
    currsigs.addElement(modeF1);
    modeF1.setValue(0);//sysj\systemController.sysj line: 75, column: 20
    modeF2.setPresent();//sysj\systemController.sysj line: 75, column: 36
    currsigs.addElement(modeF2);
    modeF2.setValue(0);//sysj\systemController.sysj line: 75, column: 36
    modeLL.setPresent();//sysj\systemController.sysj line: 76, column: 4
    currsigs.addElement(modeLL);
    modeLL.setValue(0);//sysj\systemController.sysj line: 76, column: 4
    modeCP.setPresent();//sysj\systemController.sysj line: 76, column: 20
    currsigs.addElement(modeCP);
    modeCP.setValue(0);//sysj\systemController.sysj line: 76, column: 20
    modeLB.setPresent();//sysj\systemController.sysj line: 76, column: 36
    currsigs.addElement(modeLB);
    modeLB.setValue(0);//sysj\systemController.sysj line: 76, column: 36
    modeSP.setPresent();//sysj\systemController.sysj line: 77, column: 4
    currsigs.addElement(modeSP);
    modeSP.setValue(0);//sysj\systemController.sysj line: 77, column: 4
    modeRC.setPresent();//sysj\systemController.sysj line: 77, column: 20
    currsigs.addElement(modeRC);
    modeRC.setValue(0);//sysj\systemController.sysj line: 77, column: 20
    modeLR.setPresent();//sysj\systemController.sysj line: 77, column: 36
    currsigs.addElement(modeLR);
    modeLR.setValue(0);//sysj\systemController.sysj line: 77, column: 36
    modeLD.setPresent();//sysj\systemController.sysj line: 78, column: 4
    currsigs.addElement(modeLD);
    modeLD.setValue(0);//sysj\systemController.sysj line: 78, column: 4
    modeBR.setPresent();//sysj\systemController.sysj line: 78, column: 20
    currsigs.addElement(modeBR);
    modeBR.setValue(0);//sysj\systemController.sysj line: 78, column: 20
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
      switch(S231287){
        case 0 : 
          S231287=0;
          break RUN;
        
        case 1 : 
          S231287=2;
          S231287=2;
          thread231289(tdone,ends);
          thread231290(tdone,ends);
          thread231291(tdone,ends);
          thread231292(tdone,ends);
          thread231293(tdone,ends);
          thread231294(tdone,ends);
          thread231295(tdone,ends);
          thread231296(tdone,ends);
          thread231297(tdone,ends);
          thread231298(tdone,ends);
          int biggest231299 = 0;
          if(ends[2]>=biggest231299){
            biggest231299=ends[2];
          }
          if(ends[3]>=biggest231299){
            biggest231299=ends[3];
          }
          if(ends[4]>=biggest231299){
            biggest231299=ends[4];
          }
          if(ends[5]>=biggest231299){
            biggest231299=ends[5];
          }
          if(ends[6]>=biggest231299){
            biggest231299=ends[6];
          }
          if(ends[7]>=biggest231299){
            biggest231299=ends[7];
          }
          if(ends[8]>=biggest231299){
            biggest231299=ends[8];
          }
          if(ends[9]>=biggest231299){
            biggest231299=ends[9];
          }
          if(ends[10]>=biggest231299){
            biggest231299=ends[10];
          }
          if(ends[11]>=biggest231299){
            biggest231299=ends[11];
          }
          if(biggest231299 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread231300(tdone,ends);
          thread231301(tdone,ends);
          thread231302(tdone,ends);
          thread231303(tdone,ends);
          thread231304(tdone,ends);
          thread231305(tdone,ends);
          thread231306(tdone,ends);
          thread231307(tdone,ends);
          thread231308(tdone,ends);
          thread231309(tdone,ends);
          int biggest231310 = 0;
          if(ends[2]>=biggest231310){
            biggest231310=ends[2];
          }
          if(ends[3]>=biggest231310){
            biggest231310=ends[3];
          }
          if(ends[4]>=biggest231310){
            biggest231310=ends[4];
          }
          if(ends[5]>=biggest231310){
            biggest231310=ends[5];
          }
          if(ends[6]>=biggest231310){
            biggest231310=ends[6];
          }
          if(ends[7]>=biggest231310){
            biggest231310=ends[7];
          }
          if(ends[8]>=biggest231310){
            biggest231310=ends[8];
          }
          if(ends[9]>=biggest231310){
            biggest231310=ends[9];
          }
          if(ends[10]>=biggest231310){
            biggest231310=ends[10];
          }
          if(ends[11]>=biggest231310){
            biggest231310=ends[11];
          }
          if(biggest231310 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest231310 == 0){
            S231287=0;
            active[1]=0;
            ends[1]=0;
            S231287=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          loadAck_in.gethook();
          bottleDone_in.gethook();
          labelDone_in.gethook();
          bottleRecycled_in.gethook();
          loadOrder_o.gethook();
          labelBottle_o.gethook();
          bottleRejected_o.gethook();
          purchaseOrder.gethook();
          guiCommand.gethook();
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
      purchaseOrder.setpreclear();
      guiCommand.setpreclear();
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
      guiStatus.setpreclear();
      permitRT.setpreclear();
      permitF1.setpreclear();
      permitF2.setpreclear();
      permitLL.setpreclear();
      permitCP.setpreclear();
      permitCV.setpreclear();
      permitLB.setpreclear();
      permitRC.setpreclear();
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
      dummyint = purchaseOrder.getStatus() ? purchaseOrder.setprepresent() : purchaseOrder.setpreclear();
      purchaseOrder.setpreval(purchaseOrder.getValue());
      purchaseOrder.setClear();
      dummyint = guiCommand.getStatus() ? guiCommand.setprepresent() : guiCommand.setpreclear();
      guiCommand.setpreval(guiCommand.getValue());
      guiCommand.setClear();
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
      guiStatus.sethook();
      guiStatus.setClear();
      permitRT.sethook();
      permitRT.setClear();
      permitF1.sethook();
      permitF1.setClear();
      permitF2.sethook();
      permitF2.setClear();
      permitLL.sethook();
      permitLL.setClear();
      permitCP.sethook();
      permitCP.setClear();
      permitCV.sethook();
      permitCV.setClear();
      permitLB.sethook();
      permitLB.setClear();
      permitRC.sethook();
      permitRC.setClear();
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
        guiCommand.gethook();
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
