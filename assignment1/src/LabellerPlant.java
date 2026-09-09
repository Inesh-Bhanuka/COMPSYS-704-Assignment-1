import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LabellerPlant extends ClockDomain{
  public LabellerPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal applyLabelExtend = new Signal("applyLabelExtend", Signal.INPUT);
  public Signal applyLabelRetract = new Signal("applyLabelRetract", Signal.INPUT);
  public Signal rollerOnOff = new Signal("rollerOnOff", Signal.INPUT);
  public Signal printLabel = new Signal("printLabel", Signal.INPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.OUTPUT);
  public Signal labelPrinted = new Signal("labelPrinted", Signal.OUTPUT);
  public Signal labelApplied = new Signal("labelApplied", Signal.OUTPUT);
  public Signal labelStockLow = new Signal("labelStockLow", Signal.OUTPUT);
  public Signal glueLow = new Signal("glueLow", Signal.OUTPUT);
  public Signal labelStock = new Signal("labelStock", Signal.OUTPUT);
  public Signal glueLevel = new Signal("glueLevel", Signal.OUTPUT);
  private int PRINT_thread_2;//sysj/labellerPlant.sysj line: 20, column: 3
  private int labels_thread_2;//sysj/labellerPlant.sysj line: 21, column: 3
  private int printing_thread_2;//sysj/labellerPlant.sysj line: 22, column: 3
  private boolean armed_thread_2;//sysj/labellerPlant.sysj line: 23, column: 3
  private int APPLY_thread_3;//sysj/labellerPlant.sysj line: 56, column: 3
  private int glue_thread_3;//sysj/labellerPlant.sysj line: 57, column: 3
  private int extending_thread_3;//sysj/labellerPlant.sysj line: 58, column: 3
  private boolean out_thread_3;//sysj/labellerPlant.sysj line: 59, column: 3
  private int S56329 = 1;
  private int S56170 = 1;
  private int S56316 = 1;
  private int S56327 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread56337(int [] tdone, int [] ends){
        switch(S56327){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 95, column: 12
          if(rollerOnOff.getprestatus()){//sysj/labellerPlant.sysj line: 96, column: 13
            bottleAtLabeller.setPresent();//sysj/labellerPlant.sysj line: 97, column: 6
            currsigs.addElement(bottleAtLabeller);
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
      
    }
  }

  public void thread56336(int [] tdone, int [] ends){
        switch(S56316){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 62, column: 12
          if(applyLabelExtend.getprestatus()){//sysj/labellerPlant.sysj line: 63, column: 13
            if(!out_thread_3) {//sysj/labellerPlant.sysj line: 64, column: 14
              if(extending_thread_3 < APPLY_thread_3) {//sysj/labellerPlant.sysj line: 65, column: 28
                extending_thread_3 = extending_thread_3 + 1;//sysj/labellerPlant.sysj line: 66, column: 8
              }
              if(extending_thread_3 >= APPLY_thread_3) {//sysj/labellerPlant.sysj line: 68, column: 29
                out_thread_3 = true;//sysj/labellerPlant.sysj line: 69, column: 8
                if(glue_thread_3 > 0) {//sysj/labellerPlant.sysj line: 70, column: 20
                  glue_thread_3 = glue_thread_3 - 1;//sysj/labellerPlant.sysj line: 70, column: 22
                }
                System.out.println("[LABPlant] Label applied.");//sysj/labellerPlant.sysj line: 71, column: 8
              }
            }
            if(applyLabelRetract.getprestatus()){//sysj/labellerPlant.sysj line: 75, column: 13
              out_thread_3 = false;//sysj/labellerPlant.sysj line: 76, column: 6
              extending_thread_3 = 0;//sysj/labellerPlant.sysj line: 77, column: 6
              if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
                labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
                currsigs.addElement(labelApplied);
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
            }
            else {
              if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
                labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
                currsigs.addElement(labelApplied);
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
            }
          }
          else {
            if(applyLabelRetract.getprestatus()){//sysj/labellerPlant.sysj line: 75, column: 13
              out_thread_3 = false;//sysj/labellerPlant.sysj line: 76, column: 6
              extending_thread_3 = 0;//sysj/labellerPlant.sysj line: 77, column: 6
              if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
                labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
                currsigs.addElement(labelApplied);
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
            }
            else {
              if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
                labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
                currsigs.addElement(labelApplied);
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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
                glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
                currsigs.addElement(glueLevel);
                glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
                if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
                  glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
                  currsigs.addElement(glueLow);
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

  public void thread56335(int [] tdone, int [] ends){
        switch(S56170){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 26, column: 12
          if(printLabel.getprestatus()){//sysj/labellerPlant.sysj line: 27, column: 13
            if(!armed_thread_2 && labels_thread_2 > 0) {//sysj/labellerPlant.sysj line: 28, column: 30
              armed_thread_2 = true;//sysj/labellerPlant.sysj line: 29, column: 7
              printing_thread_2 = PRINT_thread_2;//sysj/labellerPlant.sysj line: 30, column: 7
              labels_thread_2 = labels_thread_2 - 1;//sysj/labellerPlant.sysj line: 31, column: 7
              System.out.println("[LABPlant] Printing: " + (LabelData)(printLabel.getpreval() == null ? null : ((LabelData)printLabel.getpreval())));//sysj/labellerPlant.sysj line: 32, column: 7
            }
            if(printing_thread_2 > 0) {//sysj/labellerPlant.sysj line: 39, column: 21
              printing_thread_2 = printing_thread_2 - 1;//sysj/labellerPlant.sysj line: 40, column: 6
            }
            if(armed_thread_2 && printing_thread_2 == 0){//sysj/labellerPlant.sysj line: 42, column: 8
              labelPrinted.setPresent();//sysj/labellerPlant.sysj line: 43, column: 6
              currsigs.addElement(labelPrinted);
              labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
              currsigs.addElement(labelStock);
              labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
              if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
                labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
                currsigs.addElement(labelStockLow);
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
              labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
              currsigs.addElement(labelStock);
              labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
              if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
                labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
                currsigs.addElement(labelStockLow);
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
          }
          else {
            armed_thread_2 = false;//sysj/labellerPlant.sysj line: 36, column: 6
            if(printing_thread_2 > 0) {//sysj/labellerPlant.sysj line: 39, column: 21
              printing_thread_2 = printing_thread_2 - 1;//sysj/labellerPlant.sysj line: 40, column: 6
            }
            if(armed_thread_2 && printing_thread_2 == 0){//sysj/labellerPlant.sysj line: 42, column: 8
              labelPrinted.setPresent();//sysj/labellerPlant.sysj line: 43, column: 6
              currsigs.addElement(labelPrinted);
              labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
              currsigs.addElement(labelStock);
              labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
              if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
                labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
                currsigs.addElement(labelStockLow);
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
              labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
              currsigs.addElement(labelStock);
              labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
              if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
                labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
                currsigs.addElement(labelStockLow);
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

  public void thread56333(int [] tdone, int [] ends){
        S56327=1;
    if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 95, column: 12
      if(rollerOnOff.getprestatus()){//sysj/labellerPlant.sysj line: 96, column: 13
        bottleAtLabeller.setPresent();//sysj/labellerPlant.sysj line: 97, column: 6
        currsigs.addElement(bottleAtLabeller);
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

  public void thread56332(int [] tdone, int [] ends){
        S56316=1;
    APPLY_thread_3 = 3;//sysj/labellerPlant.sysj line: 56, column: 3
    glue_thread_3 = 10;//sysj/labellerPlant.sysj line: 57, column: 3
    extending_thread_3 = 0;//sysj/labellerPlant.sysj line: 58, column: 3
    out_thread_3 = false;//sysj/labellerPlant.sysj line: 59, column: 3
    if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 62, column: 12
      if(applyLabelExtend.getprestatus()){//sysj/labellerPlant.sysj line: 63, column: 13
        if(!out_thread_3) {//sysj/labellerPlant.sysj line: 64, column: 14
          if(extending_thread_3 < APPLY_thread_3) {//sysj/labellerPlant.sysj line: 65, column: 28
            extending_thread_3 = extending_thread_3 + 1;//sysj/labellerPlant.sysj line: 66, column: 8
          }
          if(extending_thread_3 >= APPLY_thread_3) {//sysj/labellerPlant.sysj line: 68, column: 29
            out_thread_3 = true;//sysj/labellerPlant.sysj line: 69, column: 8
            if(glue_thread_3 > 0) {//sysj/labellerPlant.sysj line: 70, column: 20
              glue_thread_3 = glue_thread_3 - 1;//sysj/labellerPlant.sysj line: 70, column: 22
            }
            System.out.println("[LABPlant] Label applied.");//sysj/labellerPlant.sysj line: 71, column: 8
          }
        }
        if(applyLabelRetract.getprestatus()){//sysj/labellerPlant.sysj line: 75, column: 13
          out_thread_3 = false;//sysj/labellerPlant.sysj line: 76, column: 6
          extending_thread_3 = 0;//sysj/labellerPlant.sysj line: 77, column: 6
          if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
            labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
            currsigs.addElement(labelApplied);
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
        }
        else {
          if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
            labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
            currsigs.addElement(labelApplied);
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
        }
      }
      else {
        if(applyLabelRetract.getprestatus()){//sysj/labellerPlant.sysj line: 75, column: 13
          out_thread_3 = false;//sysj/labellerPlant.sysj line: 76, column: 6
          extending_thread_3 = 0;//sysj/labellerPlant.sysj line: 77, column: 6
          if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
            labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
            currsigs.addElement(labelApplied);
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
        }
        else {
          if(out_thread_3){//sysj/labellerPlant.sysj line: 80, column: 5
            labelApplied.setPresent();//sysj/labellerPlant.sysj line: 81, column: 6
            currsigs.addElement(labelApplied);
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
            glueLevel.setPresent();//sysj/labellerPlant.sysj line: 84, column: 5
            currsigs.addElement(glueLevel);
            glueLevel.setValue(glue_thread_3);//sysj/labellerPlant.sysj line: 84, column: 5
            if(glue_thread_3 <= 2){//sysj/labellerPlant.sysj line: 85, column: 8
              glueLow.setPresent();//sysj/labellerPlant.sysj line: 86, column: 6
              currsigs.addElement(glueLow);
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
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread56331(int [] tdone, int [] ends){
        S56170=1;
    PRINT_thread_2 = 4;//sysj/labellerPlant.sysj line: 20, column: 3
    labels_thread_2 = 8;//sysj/labellerPlant.sysj line: 21, column: 3
    printing_thread_2 = 0;//sysj/labellerPlant.sysj line: 22, column: 3
    armed_thread_2 = false;//sysj/labellerPlant.sysj line: 23, column: 3
    if(enable.getprestatus()){//sysj/labellerPlant.sysj line: 26, column: 12
      if(printLabel.getprestatus()){//sysj/labellerPlant.sysj line: 27, column: 13
        if(!armed_thread_2 && labels_thread_2 > 0) {//sysj/labellerPlant.sysj line: 28, column: 30
          armed_thread_2 = true;//sysj/labellerPlant.sysj line: 29, column: 7
          printing_thread_2 = PRINT_thread_2;//sysj/labellerPlant.sysj line: 30, column: 7
          labels_thread_2 = labels_thread_2 - 1;//sysj/labellerPlant.sysj line: 31, column: 7
          System.out.println("[LABPlant] Printing: " + (LabelData)(printLabel.getpreval() == null ? null : ((LabelData)printLabel.getpreval())));//sysj/labellerPlant.sysj line: 32, column: 7
        }
        if(printing_thread_2 > 0) {//sysj/labellerPlant.sysj line: 39, column: 21
          printing_thread_2 = printing_thread_2 - 1;//sysj/labellerPlant.sysj line: 40, column: 6
        }
        if(armed_thread_2 && printing_thread_2 == 0){//sysj/labellerPlant.sysj line: 42, column: 8
          labelPrinted.setPresent();//sysj/labellerPlant.sysj line: 43, column: 6
          currsigs.addElement(labelPrinted);
          labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
          currsigs.addElement(labelStock);
          labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
          if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
            labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
            currsigs.addElement(labelStockLow);
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
          labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
          currsigs.addElement(labelStock);
          labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
          if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
            labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
            currsigs.addElement(labelStockLow);
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
      }
      else {
        armed_thread_2 = false;//sysj/labellerPlant.sysj line: 36, column: 6
        if(printing_thread_2 > 0) {//sysj/labellerPlant.sysj line: 39, column: 21
          printing_thread_2 = printing_thread_2 - 1;//sysj/labellerPlant.sysj line: 40, column: 6
        }
        if(armed_thread_2 && printing_thread_2 == 0){//sysj/labellerPlant.sysj line: 42, column: 8
          labelPrinted.setPresent();//sysj/labellerPlant.sysj line: 43, column: 6
          currsigs.addElement(labelPrinted);
          labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
          currsigs.addElement(labelStock);
          labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
          if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
            labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
            currsigs.addElement(labelStockLow);
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
          labelStock.setPresent();//sysj/labellerPlant.sysj line: 46, column: 5
          currsigs.addElement(labelStock);
          labelStock.setValue(labels_thread_2);//sysj/labellerPlant.sysj line: 46, column: 5
          if(labels_thread_2 <= 2){//sysj/labellerPlant.sysj line: 47, column: 8
            labelStockLow.setPresent();//sysj/labellerPlant.sysj line: 48, column: 6
            currsigs.addElement(labelStockLow);
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
      switch(S56329){
        case 0 : 
          S56329=0;
          break RUN;
        
        case 1 : 
          S56329=2;
          S56329=2;
          thread56331(tdone,ends);
          thread56332(tdone,ends);
          thread56333(tdone,ends);
          int biggest56334 = 0;
          if(ends[2]>=biggest56334){
            biggest56334=ends[2];
          }
          if(ends[3]>=biggest56334){
            biggest56334=ends[3];
          }
          if(ends[4]>=biggest56334){
            biggest56334=ends[4];
          }
          if(biggest56334 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread56335(tdone,ends);
          thread56336(tdone,ends);
          thread56337(tdone,ends);
          int biggest56338 = 0;
          if(ends[2]>=biggest56338){
            biggest56338=ends[2];
          }
          if(ends[3]>=biggest56338){
            biggest56338=ends[3];
          }
          if(ends[4]>=biggest56338){
            biggest56338=ends[4];
          }
          if(biggest56338 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest56338 == 0){
            S56329=0;
            active[1]=0;
            ends[1]=0;
            S56329=0;
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
          enable.gethook();
          applyLabelExtend.gethook();
          applyLabelRetract.gethook();
          rollerOnOff.gethook();
          printLabel.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      applyLabelExtend.setpreclear();
      applyLabelRetract.setpreclear();
      rollerOnOff.setpreclear();
      printLabel.setpreclear();
      bottleAtLabeller.setpreclear();
      labelPrinted.setpreclear();
      labelApplied.setpreclear();
      labelStockLow.setpreclear();
      glueLow.setpreclear();
      labelStock.setpreclear();
      glueLevel.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = applyLabelExtend.getStatus() ? applyLabelExtend.setprepresent() : applyLabelExtend.setpreclear();
      applyLabelExtend.setpreval(applyLabelExtend.getValue());
      applyLabelExtend.setClear();
      dummyint = applyLabelRetract.getStatus() ? applyLabelRetract.setprepresent() : applyLabelRetract.setpreclear();
      applyLabelRetract.setpreval(applyLabelRetract.getValue());
      applyLabelRetract.setClear();
      dummyint = rollerOnOff.getStatus() ? rollerOnOff.setprepresent() : rollerOnOff.setpreclear();
      rollerOnOff.setpreval(rollerOnOff.getValue());
      rollerOnOff.setClear();
      dummyint = printLabel.getStatus() ? printLabel.setprepresent() : printLabel.setpreclear();
      printLabel.setpreval(printLabel.getValue());
      printLabel.setClear();
      bottleAtLabeller.sethook();
      bottleAtLabeller.setClear();
      labelPrinted.sethook();
      labelPrinted.setClear();
      labelApplied.sethook();
      labelApplied.setClear();
      labelStockLow.sethook();
      labelStockLow.setClear();
      glueLow.sethook();
      glueLow.setClear();
      labelStock.sethook();
      labelStock.setClear();
      glueLevel.sethook();
      glueLevel.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        applyLabelExtend.gethook();
        applyLabelRetract.gethook();
        rollerOnOff.gethook();
        printLabel.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
