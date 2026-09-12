import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LabellerController extends ClockDomain{
  public LabellerController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.INPUT);
  public Signal labelPrinted = new Signal("labelPrinted", Signal.INPUT);
  public Signal labelApplied = new Signal("labelApplied", Signal.INPUT);
  public Signal labelStockLow = new Signal("labelStockLow", Signal.INPUT);
  public Signal glueLow = new Signal("glueLow", Signal.INPUT);
  public Signal labelStock = new Signal("labelStock", Signal.INPUT);
  public Signal glueLevel = new Signal("glueLevel", Signal.INPUT);
  public Signal applyLabelExtendM = new Signal("applyLabelExtendM", Signal.INPUT);
  public Signal rollerOnOffM = new Signal("rollerOnOffM", Signal.INPUT);
  public Signal printLabel = new Signal("printLabel", Signal.OUTPUT);
  public Signal applyLabelExtend = new Signal("applyLabelExtend", Signal.OUTPUT);
  public Signal applyLabelRetract = new Signal("applyLabelRetract", Signal.OUTPUT);
  public Signal rollerOnOff = new Signal("rollerOnOff", Signal.OUTPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal status = new Signal("status", Signal.OUTPUT);
  public input_Channel labelBottle_in = new input_Channel();
  public output_Channel labelDone_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LabellerTwin t_thread_3;//sysj\labellerController.sysj line: 54, column: 3
  private WorkpieceTwin w_thread_3;//sysj\labellerController.sysj line: 55, column: 3
  private LabelData label_thread_3;//sysj\labellerController.sysj line: 56, column: 3
  private String refusal_thread_3;//sysj\labellerController.sysj line: 57, column: 3
  private LabellerTwin t_thread_4;//sysj\labellerController.sysj line: 139, column: 3
  private int labels_thread_4;//sysj\labellerController.sysj line: 140, column: 3
  private int glue_thread_4;//sysj\labellerController.sysj line: 141, column: 3
  private boolean labelsReported_thread_4;//sysj\labellerController.sysj line: 142, column: 3
  private boolean glueReported_thread_4;//sysj\labellerController.sysj line: 143, column: 3
  private boolean permitted_thread_3;//sysj\labellerController.sysj line: 66, column: 1
  private int S73770 = 1;
  private int S51454 = 1;
  private int S73500 = 1;
  private int S55129 = 1;
  private int S51479 = 1;
  private int S51463 = 1;
  private int S51458 = 1;
  private int S51480 = 1;
  private int S51548 = 1;
  private int S51960 = 1;
  private int S51955 = 1;
  private int S73616 = 1;
  private int S73768 = 1;
  private int S73666 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread73780(int [] tdone, int [] ends){
        switch(S73768){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S73666){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 174, column: 20
              S73666=1;
              if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 175, column: 20
                S73666=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(applyLabelExtendM.getprestatus()){//sysj\labellerController.sysj line: 177, column: 14
                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 177, column: 34
                  currsigs.addElement(applyLabelExtend);
                  if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                    rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                    currsigs.addElement(rollerOnOff);
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
                  if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                    rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                    currsigs.addElement(rollerOnOff);
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
              }
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 175, column: 20
              S73666=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              if(applyLabelExtendM.getprestatus()){//sysj\labellerController.sysj line: 177, column: 14
                applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 177, column: 34
                currsigs.addElement(applyLabelExtend);
                if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                  currsigs.addElement(rollerOnOff);
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
                if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                  currsigs.addElement(rollerOnOff);
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
            }
            break;
          
          case 2 : 
            S73666=2;
            S73666=0;
            if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 174, column: 20
              S73666=1;
              if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 175, column: 20
                S73666=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(applyLabelExtendM.getprestatus()){//sysj\labellerController.sysj line: 177, column: 14
                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 177, column: 34
                  currsigs.addElement(applyLabelExtend);
                  if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                    rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                    currsigs.addElement(rollerOnOff);
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
                  if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
                    rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
                    currsigs.addElement(rollerOnOff);
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
              }
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread73779(int [] tdone, int [] ends){
        switch(S73616){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(labelStock.getprestatus()){//sysj\labellerController.sysj line: 146, column: 12
          labels_thread_4 = (Integer)(labelStock.getpreval() == null ? null : ((Integer)labelStock.getpreval()));//sysj\labellerController.sysj line: 146, column: 25
          if(glueLevel.getprestatus()){//sysj\labellerController.sysj line: 147, column: 12
            glue_thread_4 = (Integer)(glueLevel.getpreval() == null ? null : ((Integer)glueLevel.getpreval()));//sysj\labellerController.sysj line: 147, column: 24
            if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
              if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
                System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
                labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
              }
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
              if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
                System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
                labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
              }
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
        }
        else {
          if(glueLevel.getprestatus()){//sysj\labellerController.sysj line: 147, column: 12
            glue_thread_4 = (Integer)(glueLevel.getpreval() == null ? null : ((Integer)glueLevel.getpreval()));//sysj\labellerController.sysj line: 147, column: 24
            if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
              if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
                System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
                labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
              }
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
              if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
                System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
                labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
              }
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
              if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
                if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
                  System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
                  glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
                }
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
        }
        break;
      
    }
  }

  public void thread73778(int [] tdone, int [] ends){
        switch(S73500){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S55129){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 60, column: 20
              S55129=1;
              if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 62, column: 20
                labelBottle_in.setPreempted();
                labelDone_o.setPreempted();
                S55129=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S51479=0;
                S51463=0;
                if(!labelBottle_in.isPartnerPresent() || labelBottle_in.isPartnerPreempted()){//sysj\labellerController.sysj line: 63, column: 5
                  labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                  S51463=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S51458=0;
                  if(!labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                    labelBottle_in.setACK(true);//sysj\labellerController.sysj line: 63, column: 5
                    S51458=1;
                    if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                      labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                      ends[3]=2;
                      ;//sysj\labellerController.sysj line: 63, column: 5
                      w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
                      S51479=1;
                      if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                        permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                        S51480=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51479=2;
                        if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                          w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                          refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                          if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                            System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                            w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                              twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                              status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                              currsigs.addElement(status);
                              status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                              S51479=3;
                              S51960=0;
                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                S51960=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S51955=0;
                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                  S51955=1;
                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                    S55129=2;
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
                            else {
                              status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                              currsigs.addElement(status);
                              status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                              S51479=3;
                              S51960=0;
                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                S51960=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S51955=0;
                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                  S51955=1;
                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                    S55129=2;
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
                            w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                            label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                              twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                              S51548=0;
                              if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                S51548=1;
                                if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                  applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                  currsigs.addElement(applyLabelRetract);
                                  w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                  t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                  System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  else {
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                  currsigs.addElement(applyLabelExtend);
                                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                  currsigs.addElement(rollerOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                currsigs.addElement(printLabel);
                                printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S51548=0;
                              if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                S51548=1;
                                if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                  applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                  currsigs.addElement(applyLabelRetract);
                                  w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                  t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                  System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  else {
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                  currsigs.addElement(applyLabelExtend);
                                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                  currsigs.addElement(rollerOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                currsigs.addElement(printLabel);
                                printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S51479=3;
                          S51960=0;
                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            S51960=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S51955=0;
                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                              S51955=1;
                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 125, column: 5
                                S55129=2;
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
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 62, column: 20
              labelBottle_in.setPreempted();
              labelDone_o.setPreempted();
              S55129=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S51479){
                case 0 : 
                  switch(S51463){
                    case 0 : 
                      if(!labelBottle_in.isPartnerPresent() || labelBottle_in.isPartnerPreempted()){//sysj\labellerController.sysj line: 63, column: 5
                        labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                        S51463=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S51458){
                          case 0 : 
                            if(!labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                              labelBottle_in.setACK(true);//sysj\labellerController.sysj line: 63, column: 5
                              S51458=1;
                              if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                                labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 63, column: 5
                                w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
                                S51479=1;
                                if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                                  permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                                  S51480=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S51479=2;
                                  if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                                    w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                                    refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                                    if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                                      System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                                      w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                                        twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                                        status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                        currsigs.addElement(status);
                                        status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                        S51479=3;
                                        S51960=0;
                                        if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          S51960=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S51955=0;
                                          if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                            S51955=1;
                                            if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              ends[3]=2;
                                              ;//sysj\labellerController.sysj line: 125, column: 5
                                              S55129=2;
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
                                      else {
                                        status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                        currsigs.addElement(status);
                                        status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                        S51479=3;
                                        S51960=0;
                                        if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          S51960=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S51955=0;
                                          if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                            S51955=1;
                                            if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              ends[3]=2;
                                              ;//sysj\labellerController.sysj line: 125, column: 5
                                              S55129=2;
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
                                      w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                                      label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                                        twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                                        S51548=0;
                                        if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                          S51548=1;
                                          if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                            applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                            currsigs.addElement(applyLabelRetract);
                                            w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                            t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                            System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                              twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                              status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                              currsigs.addElement(status);
                                              status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                              S51479=3;
                                              S51960=0;
                                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                S51960=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S51955=0;
                                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                  S51955=1;
                                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                                    S55129=2;
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
                                            else {
                                              status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                              currsigs.addElement(status);
                                              status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                              S51479=3;
                                              S51960=0;
                                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                S51960=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S51955=0;
                                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                  S51955=1;
                                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                                    S55129=2;
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
                                            applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                            currsigs.addElement(applyLabelExtend);
                                            rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                            currsigs.addElement(rollerOnOff);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                          currsigs.addElement(printLabel);
                                          printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                          currsigs.addElement(rollerOnOff);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S51548=0;
                                        if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                          S51548=1;
                                          if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                            applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                            currsigs.addElement(applyLabelRetract);
                                            w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                            t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                            System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                              twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                              status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                              currsigs.addElement(status);
                                              status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                              S51479=3;
                                              S51960=0;
                                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                S51960=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S51955=0;
                                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                  S51955=1;
                                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                                    S55129=2;
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
                                            else {
                                              status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                              currsigs.addElement(status);
                                              status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                              S51479=3;
                                              S51960=0;
                                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                S51960=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S51955=0;
                                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                  S51955=1;
                                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                                    S55129=2;
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
                                            applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                            currsigs.addElement(applyLabelExtend);
                                            rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                            currsigs.addElement(rollerOnOff);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                          currsigs.addElement(printLabel);
                                          printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                          currsigs.addElement(rollerOnOff);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                            if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                              labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                              ends[3]=2;
                              ;//sysj\labellerController.sysj line: 63, column: 5
                              w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
                              S51479=1;
                              if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                                permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                                S51480=0;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S51479=2;
                                if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                                  w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                                  refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                                  if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                                    System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                                    w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                                      twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                                      status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                      currsigs.addElement(status);
                                      status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                      S51479=3;
                                      S51960=0;
                                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        S51960=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S51955=0;
                                        if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                          S51955=1;
                                          if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            ends[3]=2;
                                            ;//sysj\labellerController.sysj line: 125, column: 5
                                            S55129=2;
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
                                    else {
                                      status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                      currsigs.addElement(status);
                                      status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                      S51479=3;
                                      S51960=0;
                                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        S51960=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S51955=0;
                                        if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                          S51955=1;
                                          if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            ends[3]=2;
                                            ;//sysj\labellerController.sysj line: 125, column: 5
                                            S55129=2;
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
                                    w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                                    label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                                      twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                                      S51548=0;
                                      if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                        S51548=1;
                                        if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                          applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                          currsigs.addElement(applyLabelRetract);
                                          w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                          t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                          System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                            twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                            currsigs.addElement(status);
                                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                            S51479=3;
                                            S51960=0;
                                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              S51960=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S51955=0;
                                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                S51955=1;
                                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                                  S55129=2;
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
                                          else {
                                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                            currsigs.addElement(status);
                                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                            S51479=3;
                                            S51960=0;
                                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              S51960=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S51955=0;
                                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                S51955=1;
                                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                                  S55129=2;
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
                                          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                          currsigs.addElement(applyLabelExtend);
                                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                          currsigs.addElement(rollerOnOff);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                        currsigs.addElement(printLabel);
                                        printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                        currsigs.addElement(rollerOnOff);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S51548=0;
                                      if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                        S51548=1;
                                        if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                          applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                          currsigs.addElement(applyLabelRetract);
                                          w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                          t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                          System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                            twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                            currsigs.addElement(status);
                                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                            S51479=3;
                                            S51960=0;
                                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              S51960=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S51955=0;
                                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                S51955=1;
                                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                                  S55129=2;
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
                                          else {
                                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                            currsigs.addElement(status);
                                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                            S51479=3;
                                            S51960=0;
                                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                              S51960=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S51955=0;
                                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                                S51955=1;
                                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                                  S55129=2;
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
                                          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                          currsigs.addElement(applyLabelExtend);
                                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                          currsigs.addElement(rollerOnOff);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                        currsigs.addElement(printLabel);
                                        printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                        currsigs.addElement(rollerOnOff);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  S51479=3;
                                  S51960=0;
                                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    S51960=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S51955=0;
                                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                      S51955=1;
                                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\labellerController.sysj line: 125, column: 5
                                        S55129=2;
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
                      S51463=1;
                      S51463=0;
                      if(!labelBottle_in.isPartnerPresent() || labelBottle_in.isPartnerPreempted()){//sysj\labellerController.sysj line: 63, column: 5
                        labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                        S51463=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51458=0;
                        if(!labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                          labelBottle_in.setACK(true);//sysj\labellerController.sysj line: 63, column: 5
                          S51458=1;
                          if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                            labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                            ends[3]=2;
                            ;//sysj\labellerController.sysj line: 63, column: 5
                            w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
                            S51479=1;
                            if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                              permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                              S51480=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51479=2;
                              if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                                w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                                refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                                if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                                  System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                                  w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                                    status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  else {
                                    status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                                  label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                                    S51548=0;
                                    if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                      S51548=1;
                                      if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                        applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                        currsigs.addElement(applyLabelRetract);
                                        w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                        t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                        System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                          twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                          currsigs.addElement(status);
                                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                          S51479=3;
                                          S51960=0;
                                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            S51960=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S51955=0;
                                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                              S51955=1;
                                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                ends[3]=2;
                                                ;//sysj\labellerController.sysj line: 125, column: 5
                                                S55129=2;
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
                                        else {
                                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                          currsigs.addElement(status);
                                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                          S51479=3;
                                          S51960=0;
                                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            S51960=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S51955=0;
                                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                              S51955=1;
                                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                ends[3]=2;
                                                ;//sysj\labellerController.sysj line: 125, column: 5
                                                S55129=2;
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
                                        applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                        currsigs.addElement(applyLabelExtend);
                                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                        currsigs.addElement(rollerOnOff);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                      currsigs.addElement(printLabel);
                                      printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                      rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                      currsigs.addElement(rollerOnOff);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S51548=0;
                                    if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                      S51548=1;
                                      if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                        applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                        currsigs.addElement(applyLabelRetract);
                                        w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                        t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                        System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                          twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                          currsigs.addElement(status);
                                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                          S51479=3;
                                          S51960=0;
                                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            S51960=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S51955=0;
                                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                              S51955=1;
                                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                ends[3]=2;
                                                ;//sysj\labellerController.sysj line: 125, column: 5
                                                S55129=2;
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
                                        else {
                                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                          currsigs.addElement(status);
                                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                          S51479=3;
                                          S51960=0;
                                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                            S51960=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S51955=0;
                                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                              S51955=1;
                                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                                ends[3]=2;
                                                ;//sysj\labellerController.sysj line: 125, column: 5
                                                S55129=2;
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
                                        applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                        currsigs.addElement(applyLabelExtend);
                                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                        currsigs.addElement(rollerOnOff);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                      currsigs.addElement(printLabel);
                                      printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                      rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                      currsigs.addElement(rollerOnOff);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S51479=3;
                                S51960=0;
                                if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  S51960=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S51955=0;
                                  if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                    S51955=1;
                                    if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj\labellerController.sysj line: 125, column: 5
                                      S55129=2;
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
                  switch(S51480){
                    case 0 : 
                      S51480=0;
                      S51480=1;
                      if(!permitted_thread_3){//sysj\labellerController.sysj line: 68, column: 19
                        permitted_thread_3 = GuiStep.take("LABEL", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\labellerController.sysj line: 69, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\labellerController.sysj line: 68, column: 13
                        S51480=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!permitted_thread_3){//sysj\labellerController.sysj line: 68, column: 19
                        permitted_thread_3 = GuiStep.take("LABEL", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\labellerController.sysj line: 69, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\labellerController.sysj line: 68, column: 13
                        S51480=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      S51480=2;
                      S51479=2;
                      if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                        w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                        refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                        if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                          System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                          w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                            twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                            status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                            currsigs.addElement(status);
                            status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          else {
                            status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                            currsigs.addElement(status);
                            status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                          label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                            twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                            S51548=0;
                            if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                              S51548=1;
                              if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                currsigs.addElement(applyLabelRetract);
                                w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                  twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                  status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                  currsigs.addElement(status);
                                  status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                  S51479=3;
                                  S51960=0;
                                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    S51960=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S51955=0;
                                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                      S51955=1;
                                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\labellerController.sysj line: 125, column: 5
                                        S55129=2;
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
                                else {
                                  status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                  currsigs.addElement(status);
                                  status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                  S51479=3;
                                  S51960=0;
                                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    S51960=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S51955=0;
                                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                      S51955=1;
                                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\labellerController.sysj line: 125, column: 5
                                        S55129=2;
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
                                applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                currsigs.addElement(applyLabelExtend);
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                              currsigs.addElement(printLabel);
                              printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                              rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                              currsigs.addElement(rollerOnOff);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S51548=0;
                            if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                              S51548=1;
                              if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                currsigs.addElement(applyLabelRetract);
                                w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                  twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                  status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                  currsigs.addElement(status);
                                  status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                  S51479=3;
                                  S51960=0;
                                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    S51960=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S51955=0;
                                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                      S51955=1;
                                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\labellerController.sysj line: 125, column: 5
                                        S55129=2;
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
                                else {
                                  status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                  currsigs.addElement(status);
                                  status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                  S51479=3;
                                  S51960=0;
                                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    S51960=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S51955=0;
                                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                      S51955=1;
                                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\labellerController.sysj line: 125, column: 5
                                        S55129=2;
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
                                applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                currsigs.addElement(applyLabelExtend);
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                              currsigs.addElement(printLabel);
                              printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                              rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                              currsigs.addElement(rollerOnOff);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        S51479=3;
                        S51960=0;
                        if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                          S51960=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S51955=0;
                          if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                            S51955=1;
                            if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj\labellerController.sysj line: 125, column: 5
                              S55129=2;
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
                    
                  }
                  break;
                
                case 2 : 
                  switch(S51548){
                    case 0 : 
                      if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                        S51548=1;
                        if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                          applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                          currsigs.addElement(applyLabelRetract);
                          w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                          t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                          System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                            twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          else {
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                          currsigs.addElement(applyLabelExtend);
                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                          currsigs.addElement(rollerOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                        currsigs.addElement(printLabel);
                        printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                        currsigs.addElement(rollerOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                        applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                        currsigs.addElement(applyLabelRetract);
                        w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                        t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                        System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                          twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                          currsigs.addElement(status);
                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                          S51479=3;
                          S51960=0;
                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            S51960=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S51955=0;
                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                              S51955=1;
                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 125, column: 5
                                S55129=2;
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
                        else {
                          status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                          currsigs.addElement(status);
                          status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                          S51479=3;
                          S51960=0;
                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            S51960=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S51955=0;
                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                              S51955=1;
                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 125, column: 5
                                S55129=2;
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
                        applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                        currsigs.addElement(applyLabelExtend);
                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                        currsigs.addElement(rollerOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 3 : 
                  switch(S51960){
                    case 0 : 
                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                        S51960=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S51955){
                          case 0 : 
                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                              S51955=1;
                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 125, column: 5
                                S55129=2;
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
                            if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj\labellerController.sysj line: 125, column: 5
                              S55129=2;
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
                      S51960=1;
                      S51960=0;
                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                        S51960=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51955=0;
                        if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                          labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                          S51955=1;
                          if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj\labellerController.sysj line: 125, column: 5
                            S55129=2;
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
                
                case 4 : 
                  S55129=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S55129=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 6 : 
                  S55129=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S55129=2;
            S55129=0;
            if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 60, column: 20
              S55129=1;
              if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 62, column: 20
                labelBottle_in.setPreempted();
                labelDone_o.setPreempted();
                S55129=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S51479=0;
                S51463=0;
                if(!labelBottle_in.isPartnerPresent() || labelBottle_in.isPartnerPreempted()){//sysj\labellerController.sysj line: 63, column: 5
                  labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                  S51463=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S51458=0;
                  if(!labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                    labelBottle_in.setACK(true);//sysj\labellerController.sysj line: 63, column: 5
                    S51458=1;
                    if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
                      labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
                      ends[3]=2;
                      ;//sysj\labellerController.sysj line: 63, column: 5
                      w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
                      S51479=1;
                      if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                        permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                        S51480=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51479=2;
                        if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                          w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                          refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                          if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                            System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                            w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                              twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                              status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                              currsigs.addElement(status);
                              status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                              S51479=3;
                              S51960=0;
                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                S51960=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S51955=0;
                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                  S51955=1;
                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                    S55129=2;
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
                            else {
                              status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                              currsigs.addElement(status);
                              status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                              S51479=3;
                              S51960=0;
                              if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                S51960=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S51955=0;
                                if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                  S51955=1;
                                  if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\labellerController.sysj line: 125, column: 5
                                    S55129=2;
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
                            w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                            label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                              twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                              S51548=0;
                              if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                S51548=1;
                                if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                  applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                  currsigs.addElement(applyLabelRetract);
                                  w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                  t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                  System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  else {
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                  currsigs.addElement(applyLabelExtend);
                                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                  currsigs.addElement(rollerOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                currsigs.addElement(printLabel);
                                printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S51548=0;
                              if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                                S51548=1;
                                if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                                  applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                                  currsigs.addElement(applyLabelRetract);
                                  w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                                  t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                                  System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                                    twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  else {
                                    status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                                    currsigs.addElement(status);
                                    status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                                    S51479=3;
                                    S51960=0;
                                    if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                                      labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                      S51960=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S51955=0;
                                      if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                        labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                        S51955=1;
                                        if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                          labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\labellerController.sysj line: 125, column: 5
                                          S55129=2;
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
                                  applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                                  currsigs.addElement(applyLabelExtend);
                                  rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                                  currsigs.addElement(rollerOnOff);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                                currsigs.addElement(printLabel);
                                printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                                rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                                currsigs.addElement(rollerOnOff);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S51479=3;
                          S51960=0;
                          if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            S51960=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S51955=0;
                            if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                              S51955=1;
                              if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\labellerController.sysj line: 125, column: 5
                                S55129=2;
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
        break;
      
    }
  }

  public void thread73777(int [] tdone, int [] ends){
        switch(S51454){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\labellerController.sysj line: 45, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\labellerController.sysj line: 46, column: 8
            auto_1.setPresent();//sysj\labellerController.sysj line: 46, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\labellerController.sysj line: 47, column: 12
            currsigs.addElement(manual_1);
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
      
    }
  }

  public void thread73775(int [] tdone, int [] ends){
        S73768=1;
    S73666=0;
    if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 174, column: 20
      S73666=1;
      if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 175, column: 20
        S73666=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(applyLabelExtendM.getprestatus()){//sysj\labellerController.sysj line: 177, column: 14
          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 177, column: 34
          currsigs.addElement(applyLabelExtend);
          if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
            rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
            currsigs.addElement(rollerOnOff);
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
          if(rollerOnOffM.getprestatus()){//sysj\labellerController.sysj line: 178, column: 14
            rollerOnOff.setPresent();//sysj\labellerController.sysj line: 178, column: 29
            currsigs.addElement(rollerOnOff);
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
      }
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread73774(int [] tdone, int [] ends){
        S73616=1;
    t_thread_4 = new LabellerTwin();//sysj\labellerController.sysj line: 139, column: 3
    labels_thread_4 = 0;//sysj\labellerController.sysj line: 140, column: 3
    glue_thread_4 = 0;//sysj\labellerController.sysj line: 141, column: 3
    labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 142, column: 3
    glueReported_thread_4 = false;//sysj\labellerController.sysj line: 143, column: 3
    if(labelStock.getprestatus()){//sysj\labellerController.sysj line: 146, column: 12
      labels_thread_4 = (Integer)(labelStock.getpreval() == null ? null : ((Integer)labelStock.getpreval()));//sysj\labellerController.sysj line: 146, column: 25
      if(glueLevel.getprestatus()){//sysj\labellerController.sysj line: 147, column: 12
        glue_thread_4 = (Integer)(glueLevel.getpreval() == null ? null : ((Integer)glueLevel.getpreval()));//sysj\labellerController.sysj line: 147, column: 24
        if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
          if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
            System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
            labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
          }
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
      else {
        if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
          if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
            System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
            labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
          }
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
    }
    else {
      if(glueLevel.getprestatus()){//sysj\labellerController.sysj line: 147, column: 12
        glue_thread_4 = (Integer)(glueLevel.getpreval() == null ? null : ((Integer)glueLevel.getpreval()));//sysj\labellerController.sysj line: 147, column: 24
        if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
          if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
            System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
            labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
          }
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
      else {
        if(labelStockLow.getprestatus()){//sysj\labellerController.sysj line: 149, column: 12
          if(!labelsReported_thread_4) {//sysj\labellerController.sysj line: 150, column: 24
            System.out.println("[LAB] Label stock low: " + labels_thread_4 + " left.");//sysj\labellerController.sysj line: 151, column: 6
            labelsReported_thread_4 = true;//sysj\labellerController.sysj line: 152, column: 6
          }
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          labelsReported_thread_4 = false;//sysj\labellerController.sysj line: 156, column: 5
          if(glueLow.getprestatus()){//sysj\labellerController.sysj line: 159, column: 12
            if(!glueReported_thread_4) {//sysj\labellerController.sysj line: 160, column: 22
              System.out.println("[LAB] Glue low: " + glue_thread_4 + " left.");//sysj\labellerController.sysj line: 161, column: 6
              glueReported_thread_4 = true;//sysj\labellerController.sysj line: 162, column: 6
            }
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            glueReported_thread_4 = false;//sysj\labellerController.sysj line: 166, column: 5
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
    }
  }

  public void thread73773(int [] tdone, int [] ends){
        S73500=1;
    t_thread_3 = new LabellerTwin();//sysj\labellerController.sysj line: 54, column: 3
    w_thread_3 = null;//sysj\labellerController.sysj line: 55, column: 3
    label_thread_3 = null;//sysj\labellerController.sysj line: 56, column: 3
    refusal_thread_3 = null;//sysj\labellerController.sysj line: 57, column: 3
    S55129=0;
    if(auto_1.getprestatus()){//sysj\labellerController.sysj line: 60, column: 20
      S55129=1;
      if(manual_1.getprestatus()){//sysj\labellerController.sysj line: 62, column: 20
        labelBottle_in.setPreempted();
        labelDone_o.setPreempted();
        S55129=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S51479=0;
        S51463=0;
        if(!labelBottle_in.isPartnerPresent() || labelBottle_in.isPartnerPreempted()){//sysj\labellerController.sysj line: 63, column: 5
          labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
          S51463=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S51458=0;
          if(!labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
            labelBottle_in.setACK(true);//sysj\labellerController.sysj line: 63, column: 5
            S51458=1;
            if(labelBottle_in.isREQ()){//sysj\labellerController.sysj line: 63, column: 5
              labelBottle_in.setACK(false);//sysj\labellerController.sysj line: 63, column: 5
              ends[3]=2;
              ;//sysj\labellerController.sysj line: 63, column: 5
              w_thread_3 = (WorkpieceTwin)(labelBottle_in.getVal() == null ? null : ((WorkpieceTwin)labelBottle_in.getVal()));//sysj\labellerController.sysj line: 64, column: 5
              S51479=1;
              if(w_thread_3 != null){//sysj\labellerController.sysj line: 65, column: 4
                permitted_thread_3 = false;//sysj\labellerController.sysj line: 66, column: 1
                S51480=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S51479=2;
                if(w_thread_3 != null){//sysj\labellerController.sysj line: 76, column: 8
                  w_thread_3.arrived(Machine.LABELLER);//sysj\labellerController.sysj line: 77, column: 6
                  refusal_thread_3 = w_thread_3.labelRefusalReason();//sysj\labellerController.sysj line: 78, column: 6
                  if(refusal_thread_3 != null){//sysj\labellerController.sysj line: 80, column: 9
                    System.out.println("[LAB] Refusing " + w_thread_3 + ": " + refusal_thread_3);//sysj\labellerController.sysj line: 82, column: 7
                    w_thread_3.reject(Machine.LABELLER, "label refused - " + refusal_thread_3);//sysj\labellerController.sysj line: 83, column: 7
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.FAULT, "refuse", refusal_thread_3)){//sysj\labellerController.sysj line: 84, column: 7
                      twin.setPresent();//sysj\labellerController.sysj line: 85, column: 8
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 85, column: 8
                      status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                      currsigs.addElement(status);
                      status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                      S51479=3;
                      S51960=0;
                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                        S51960=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51955=0;
                        if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                          labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                          S51955=1;
                          if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj\labellerController.sysj line: 125, column: 5
                            S55129=2;
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
                    else {
                      status.setPresent();//sysj\labellerController.sysj line: 87, column: 7
                      currsigs.addElement(status);
                      status.setValue(2);//sysj\labellerController.sysj line: 87, column: 7
                      S51479=3;
                      S51960=0;
                      if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                        S51960=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S51955=0;
                        if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                          labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                          S51955=1;
                          if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                            labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj\labellerController.sysj line: 125, column: 5
                            S55129=2;
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
                    w_thread_3.started(Machine.LABELLER, "labelling");//sysj\labellerController.sysj line: 90, column: 7
                    label_thread_3 = new LabelData(w_thread_3);//sysj\labellerController.sysj line: 91, column: 7
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "printLabel", label_thread_3.serial)){//sysj\labellerController.sysj line: 92, column: 7
                      twin.setPresent();//sysj\labellerController.sysj line: 93, column: 8
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 93, column: 8
                      S51548=0;
                      if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                        S51548=1;
                        if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                          applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                          currsigs.addElement(applyLabelRetract);
                          w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                          t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                          System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                            twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          else {
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                          currsigs.addElement(applyLabelExtend);
                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                          currsigs.addElement(rollerOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                        currsigs.addElement(printLabel);
                        printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                        currsigs.addElement(rollerOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S51548=0;
                      if(labelPrinted.getprestatus()){//sysj\labellerController.sysj line: 97, column: 23
                        S51548=1;
                        if(labelApplied.getprestatus()){//sysj\labellerController.sysj line: 105, column: 23
                          applyLabelRetract.setPresent();//sysj\labellerController.sysj line: 113, column: 7
                          currsigs.addElement(applyLabelRetract);
                          w_thread_3.completed(Machine.LABELLER, "label " + label_thread_3.serial);//sysj\labellerController.sysj line: 115, column: 7
                          t_thread_3.setLastSerial(label_thread_3.serial);//sysj\labellerController.sysj line: 116, column: 7
                          System.out.println("[LAB] Labelled " + w_thread_3 + " as " + label_thread_3.serial + ", mix " + label_thread_3.actualPctOne + "/" + label_thread_3.actualPctTwo + ".");//sysj\labellerController.sysj line: 117, column: 7
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "retract", label_thread_3.serial)){//sysj\labellerController.sysj line: 118, column: 7
                            twin.setPresent();//sysj\labellerController.sysj line: 119, column: 8
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\labellerController.sysj line: 119, column: 8
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          else {
                            status.setPresent();//sysj\labellerController.sysj line: 121, column: 7
                            currsigs.addElement(status);
                            status.setValue(0);//sysj\labellerController.sysj line: 121, column: 7
                            S51479=3;
                            S51960=0;
                            if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                              labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                              S51960=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S51955=0;
                              if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                                S51955=1;
                                if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                                  labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\labellerController.sysj line: 125, column: 5
                                  S55129=2;
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
                          applyLabelExtend.setPresent();//sysj\labellerController.sysj line: 107, column: 9
                          currsigs.addElement(applyLabelExtend);
                          rollerOnOff.setPresent();//sysj\labellerController.sysj line: 108, column: 9
                          currsigs.addElement(rollerOnOff);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        printLabel.setPresent();//sysj\labellerController.sysj line: 99, column: 9
                        currsigs.addElement(printLabel);
                        printLabel.setValue(label_thread_3);//sysj\labellerController.sysj line: 99, column: 9
                        rollerOnOff.setPresent();//sysj\labellerController.sysj line: 100, column: 9
                        currsigs.addElement(rollerOnOff);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                }
                else {
                  S51479=3;
                  S51960=0;
                  if(!labelDone_o.isPartnerPresent() || labelDone_o.isPartnerPreempted()){//sysj\labellerController.sysj line: 125, column: 5
                    labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                    S51960=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S51955=0;
                    if(labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                      labelDone_o.setVal(w_thread_3);//sysj\labellerController.sysj line: 125, column: 5
                      S51955=1;
                      if(!labelDone_o.isACK()){//sysj\labellerController.sysj line: 125, column: 5
                        labelDone_o.setREQ(false);//sysj\labellerController.sysj line: 125, column: 5
                        ends[3]=2;
                        ;//sysj\labellerController.sysj line: 125, column: 5
                        S55129=2;
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

  public void thread73772(int [] tdone, int [] ends){
        S51454=1;
    if(mode.getprestatus()){//sysj\labellerController.sysj line: 45, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\labellerController.sysj line: 46, column: 8
        auto_1.setPresent();//sysj\labellerController.sysj line: 46, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\labellerController.sysj line: 47, column: 12
        currsigs.addElement(manual_1);
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

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S73770){
        case 0 : 
          S73770=0;
          break RUN;
        
        case 1 : 
          S73770=2;
          S73770=2;
          auto_1.setClear();//sysj\labellerController.sysj line: 41, column: 2
          manual_1.setClear();//sysj\labellerController.sysj line: 41, column: 2
          thread73772(tdone,ends);
          thread73773(tdone,ends);
          thread73774(tdone,ends);
          thread73775(tdone,ends);
          int biggest73776 = 0;
          if(ends[2]>=biggest73776){
            biggest73776=ends[2];
          }
          if(ends[3]>=biggest73776){
            biggest73776=ends[3];
          }
          if(ends[4]>=biggest73776){
            biggest73776=ends[4];
          }
          if(ends[5]>=biggest73776){
            biggest73776=ends[5];
          }
          if(biggest73776 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\labellerController.sysj line: 41, column: 2
          manual_1.setClear();//sysj\labellerController.sysj line: 41, column: 2
          thread73777(tdone,ends);
          thread73778(tdone,ends);
          thread73779(tdone,ends);
          thread73780(tdone,ends);
          int biggest73781 = 0;
          if(ends[2]>=biggest73781){
            biggest73781=ends[2];
          }
          if(ends[3]>=biggest73781){
            biggest73781=ends[3];
          }
          if(ends[4]>=biggest73781){
            biggest73781=ends[4];
          }
          if(ends[5]>=biggest73781){
            biggest73781=ends[5];
          }
          if(biggest73781 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest73781 == 0){
            S73770=0;
            active[1]=0;
            ends[1]=0;
            S73770=0;
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
    auto_1 = new Signal();
    manual_1 = new Signal();
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
          labelBottle_in.gethook();
          labelDone_o.gethook();
          operatorPermit.gethook();
          mode.gethook();
          bottleAtLabeller.gethook();
          labelPrinted.gethook();
          labelApplied.gethook();
          labelStockLow.gethook();
          glueLow.gethook();
          labelStock.gethook();
          glueLevel.gethook();
          applyLabelExtendM.gethook();
          rollerOnOffM.gethook();
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
      mode.setpreclear();
      bottleAtLabeller.setpreclear();
      labelPrinted.setpreclear();
      labelApplied.setpreclear();
      labelStockLow.setpreclear();
      glueLow.setpreclear();
      labelStock.setpreclear();
      glueLevel.setpreclear();
      applyLabelExtendM.setpreclear();
      rollerOnOffM.setpreclear();
      printLabel.setpreclear();
      applyLabelExtend.setpreclear();
      applyLabelRetract.setpreclear();
      rollerOnOff.setpreclear();
      twin.setpreclear();
      status.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = bottleAtLabeller.getStatus() ? bottleAtLabeller.setprepresent() : bottleAtLabeller.setpreclear();
      bottleAtLabeller.setpreval(bottleAtLabeller.getValue());
      bottleAtLabeller.setClear();
      dummyint = labelPrinted.getStatus() ? labelPrinted.setprepresent() : labelPrinted.setpreclear();
      labelPrinted.setpreval(labelPrinted.getValue());
      labelPrinted.setClear();
      dummyint = labelApplied.getStatus() ? labelApplied.setprepresent() : labelApplied.setpreclear();
      labelApplied.setpreval(labelApplied.getValue());
      labelApplied.setClear();
      dummyint = labelStockLow.getStatus() ? labelStockLow.setprepresent() : labelStockLow.setpreclear();
      labelStockLow.setpreval(labelStockLow.getValue());
      labelStockLow.setClear();
      dummyint = glueLow.getStatus() ? glueLow.setprepresent() : glueLow.setpreclear();
      glueLow.setpreval(glueLow.getValue());
      glueLow.setClear();
      dummyint = labelStock.getStatus() ? labelStock.setprepresent() : labelStock.setpreclear();
      labelStock.setpreval(labelStock.getValue());
      labelStock.setClear();
      dummyint = glueLevel.getStatus() ? glueLevel.setprepresent() : glueLevel.setpreclear();
      glueLevel.setpreval(glueLevel.getValue());
      glueLevel.setClear();
      dummyint = applyLabelExtendM.getStatus() ? applyLabelExtendM.setprepresent() : applyLabelExtendM.setpreclear();
      applyLabelExtendM.setpreval(applyLabelExtendM.getValue());
      applyLabelExtendM.setClear();
      dummyint = rollerOnOffM.getStatus() ? rollerOnOffM.setprepresent() : rollerOnOffM.setpreclear();
      rollerOnOffM.setpreval(rollerOnOffM.getValue());
      rollerOnOffM.setClear();
      printLabel.sethook();
      printLabel.setClear();
      applyLabelExtend.sethook();
      applyLabelExtend.setClear();
      applyLabelRetract.sethook();
      applyLabelRetract.setClear();
      rollerOnOff.sethook();
      rollerOnOff.setClear();
      twin.sethook();
      twin.setClear();
      status.sethook();
      status.setClear();
      auto_1.setClear();
      manual_1.setClear();
      labelBottle_in.sethook();
      labelDone_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        labelBottle_in.gethook();
        labelDone_o.gethook();
        operatorPermit.gethook();
        mode.gethook();
        bottleAtLabeller.gethook();
        labelPrinted.gethook();
        labelApplied.gethook();
        labelStockLow.gethook();
        glueLow.gethook();
        labelStock.gethook();
        glueLevel.gethook();
        applyLabelExtendM.gethook();
        rollerOnOffM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
