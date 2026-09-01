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
  public Signal enableFiller1 = new Signal("enableFiller1", Signal.INPUT);
  public Signal enableFiller2 = new Signal("enableFiller2", Signal.INPUT);
  public Signal enableLid = new Signal("enableLid", Signal.INPUT);
  public Signal enableCapper = new Signal("enableCapper", Signal.INPUT);
  public Signal fillerDone1 = new Signal("fillerDone1", Signal.OUTPUT);
  public Signal fillerDone2 = new Signal("fillerDone2", Signal.OUTPUT);
  public Signal lidDone = new Signal("lidDone", Signal.OUTPUT);
  public Signal capperDone = new Signal("capperDone", Signal.OUTPUT);
  private int FILL_thread_2;//sysj\stationStubs.sysj line: 23, column: 3
  private int FILL_thread_3;//sysj\stationStubs.sysj line: 38, column: 3
  private int LID_thread_4;//sysj\stationStubs.sysj line: 53, column: 3
  private int CAP_thread_5;//sysj\stationStubs.sysj line: 68, column: 3
  private int t_thread_2;//sysj\stationStubs.sysj line: 27, column: 4
  private int t_thread_3;//sysj\stationStubs.sysj line: 42, column: 4
  private int t_thread_4;//sysj\stationStubs.sysj line: 57, column: 4
  private int t_thread_5;//sysj\stationStubs.sysj line: 72, column: 4
  private int S4625 = 1;
  private int S4017 = 1;
  private int S3817 = 1;
  private int S4219 = 1;
  private int S4019 = 1;
  private int S4421 = 1;
  private int S4221 = 1;
  private int S4623 = 1;
  private int S4423 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4635(int [] tdone, int [] ends){
        switch(S4623){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4423){
          case 0 : 
            if(enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 70, column: 20
              System.out.println("[ST] Capper: screwing cap.");//sysj\stationStubs.sysj line: 71, column: 4
              t_thread_5 = CAP_thread_5;//sysj\stationStubs.sysj line: 72, column: 4
              S4423=1;
              if(t_thread_5 > 0){//sysj\stationStubs.sysj line: 73, column: 10
                t_thread_5 = t_thread_5 - 1;//sysj\stationStubs.sysj line: 73, column: 18
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                ends[5]=2;
                ;//sysj\stationStubs.sysj line: 73, column: 4
                System.out.println("[ST] Capper: complete.");//sysj\stationStubs.sysj line: 74, column: 4
                capperDone.setPresent();//sysj\stationStubs.sysj line: 75, column: 4
                currsigs.addElement(capperDone);
                S4423=2;
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
            if(t_thread_5 > 0){//sysj\stationStubs.sysj line: 73, column: 10
              t_thread_5 = t_thread_5 - 1;//sysj\stationStubs.sysj line: 73, column: 18
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              ends[5]=2;
              ;//sysj\stationStubs.sysj line: 73, column: 4
              System.out.println("[ST] Capper: complete.");//sysj\stationStubs.sysj line: 74, column: 4
              capperDone.setPresent();//sysj\stationStubs.sysj line: 75, column: 4
              currsigs.addElement(capperDone);
              S4423=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S4423=2;
            capperDone.setPresent();//sysj\stationStubs.sysj line: 76, column: 4
            currsigs.addElement(capperDone);
            S4423=3;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 3 : 
            S4423=3;
            capperDone.setPresent();//sysj\stationStubs.sysj line: 77, column: 4
            currsigs.addElement(capperDone);
            S4423=4;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 4 : 
            S4423=4;
            S4423=5;
            if(!enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 78, column: 20
              S4423=0;
              if(enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 70, column: 20
                System.out.println("[ST] Capper: screwing cap.");//sysj\stationStubs.sysj line: 71, column: 4
                t_thread_5 = CAP_thread_5;//sysj\stationStubs.sysj line: 72, column: 4
                S4423=1;
                if(t_thread_5 > 0){//sysj\stationStubs.sysj line: 73, column: 10
                  t_thread_5 = t_thread_5 - 1;//sysj\stationStubs.sysj line: 73, column: 18
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  ends[5]=2;
                  ;//sysj\stationStubs.sysj line: 73, column: 4
                  System.out.println("[ST] Capper: complete.");//sysj\stationStubs.sysj line: 74, column: 4
                  capperDone.setPresent();//sysj\stationStubs.sysj line: 75, column: 4
                  currsigs.addElement(capperDone);
                  S4423=2;
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
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 5 : 
            if(!enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 78, column: 20
              S4423=0;
              if(enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 70, column: 20
                System.out.println("[ST] Capper: screwing cap.");//sysj\stationStubs.sysj line: 71, column: 4
                t_thread_5 = CAP_thread_5;//sysj\stationStubs.sysj line: 72, column: 4
                S4423=1;
                if(t_thread_5 > 0){//sysj\stationStubs.sysj line: 73, column: 10
                  t_thread_5 = t_thread_5 - 1;//sysj\stationStubs.sysj line: 73, column: 18
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  ends[5]=2;
                  ;//sysj\stationStubs.sysj line: 73, column: 4
                  System.out.println("[ST] Capper: complete.");//sysj\stationStubs.sysj line: 74, column: 4
                  capperDone.setPresent();//sysj\stationStubs.sysj line: 75, column: 4
                  currsigs.addElement(capperDone);
                  S4423=2;
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

  public void thread4634(int [] tdone, int [] ends){
        switch(S4421){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4221){
          case 0 : 
            if(enableLid.getprestatus()){//sysj\stationStubs.sysj line: 55, column: 20
              System.out.println("[ST] Lid loader: placing lid.");//sysj\stationStubs.sysj line: 56, column: 4
              t_thread_4 = LID_thread_4;//sysj\stationStubs.sysj line: 57, column: 4
              S4221=1;
              if(t_thread_4 > 0){//sysj\stationStubs.sysj line: 58, column: 10
                t_thread_4 = t_thread_4 - 1;//sysj\stationStubs.sysj line: 58, column: 18
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                ends[4]=2;
                ;//sysj\stationStubs.sysj line: 58, column: 4
                System.out.println("[ST] Lid loader: complete.");//sysj\stationStubs.sysj line: 59, column: 4
                lidDone.setPresent();//sysj\stationStubs.sysj line: 60, column: 4
                currsigs.addElement(lidDone);
                S4221=2;
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
            if(t_thread_4 > 0){//sysj\stationStubs.sysj line: 58, column: 10
              t_thread_4 = t_thread_4 - 1;//sysj\stationStubs.sysj line: 58, column: 18
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\stationStubs.sysj line: 58, column: 4
              System.out.println("[ST] Lid loader: complete.");//sysj\stationStubs.sysj line: 59, column: 4
              lidDone.setPresent();//sysj\stationStubs.sysj line: 60, column: 4
              currsigs.addElement(lidDone);
              S4221=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S4221=2;
            lidDone.setPresent();//sysj\stationStubs.sysj line: 61, column: 4
            currsigs.addElement(lidDone);
            S4221=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S4221=3;
            lidDone.setPresent();//sysj\stationStubs.sysj line: 62, column: 4
            currsigs.addElement(lidDone);
            S4221=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S4221=4;
            S4221=5;
            if(!enableLid.getprestatus()){//sysj\stationStubs.sysj line: 63, column: 20
              S4221=0;
              if(enableLid.getprestatus()){//sysj\stationStubs.sysj line: 55, column: 20
                System.out.println("[ST] Lid loader: placing lid.");//sysj\stationStubs.sysj line: 56, column: 4
                t_thread_4 = LID_thread_4;//sysj\stationStubs.sysj line: 57, column: 4
                S4221=1;
                if(t_thread_4 > 0){//sysj\stationStubs.sysj line: 58, column: 10
                  t_thread_4 = t_thread_4 - 1;//sysj\stationStubs.sysj line: 58, column: 18
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\stationStubs.sysj line: 58, column: 4
                  System.out.println("[ST] Lid loader: complete.");//sysj\stationStubs.sysj line: 59, column: 4
                  lidDone.setPresent();//sysj\stationStubs.sysj line: 60, column: 4
                  currsigs.addElement(lidDone);
                  S4221=2;
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
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            if(!enableLid.getprestatus()){//sysj\stationStubs.sysj line: 63, column: 20
              S4221=0;
              if(enableLid.getprestatus()){//sysj\stationStubs.sysj line: 55, column: 20
                System.out.println("[ST] Lid loader: placing lid.");//sysj\stationStubs.sysj line: 56, column: 4
                t_thread_4 = LID_thread_4;//sysj\stationStubs.sysj line: 57, column: 4
                S4221=1;
                if(t_thread_4 > 0){//sysj\stationStubs.sysj line: 58, column: 10
                  t_thread_4 = t_thread_4 - 1;//sysj\stationStubs.sysj line: 58, column: 18
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\stationStubs.sysj line: 58, column: 4
                  System.out.println("[ST] Lid loader: complete.");//sysj\stationStubs.sysj line: 59, column: 4
                  lidDone.setPresent();//sysj\stationStubs.sysj line: 60, column: 4
                  currsigs.addElement(lidDone);
                  S4221=2;
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
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4633(int [] tdone, int [] ends){
        switch(S4219){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4019){
          case 0 : 
            if(enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 40, column: 20
              System.out.println("[ST] Filler 2: dispensing.");//sysj\stationStubs.sysj line: 41, column: 4
              t_thread_3 = FILL_thread_3;//sysj\stationStubs.sysj line: 42, column: 4
              S4019=1;
              if(t_thread_3 > 0){//sysj\stationStubs.sysj line: 43, column: 10
                t_thread_3 = t_thread_3 - 1;//sysj\stationStubs.sysj line: 43, column: 18
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                ends[3]=2;
                ;//sysj\stationStubs.sysj line: 43, column: 4
                System.out.println("[ST] Filler 2: complete.");//sysj\stationStubs.sysj line: 44, column: 4
                fillerDone2.setPresent();//sysj\stationStubs.sysj line: 45, column: 4
                currsigs.addElement(fillerDone2);
                S4019=2;
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
            if(t_thread_3 > 0){//sysj\stationStubs.sysj line: 43, column: 10
              t_thread_3 = t_thread_3 - 1;//sysj\stationStubs.sysj line: 43, column: 18
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\stationStubs.sysj line: 43, column: 4
              System.out.println("[ST] Filler 2: complete.");//sysj\stationStubs.sysj line: 44, column: 4
              fillerDone2.setPresent();//sysj\stationStubs.sysj line: 45, column: 4
              currsigs.addElement(fillerDone2);
              S4019=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S4019=2;
            fillerDone2.setPresent();//sysj\stationStubs.sysj line: 46, column: 4
            currsigs.addElement(fillerDone2);
            S4019=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            S4019=3;
            fillerDone2.setPresent();//sysj\stationStubs.sysj line: 47, column: 4
            currsigs.addElement(fillerDone2);
            S4019=4;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            S4019=4;
            S4019=5;
            if(!enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 48, column: 20
              S4019=0;
              if(enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 40, column: 20
                System.out.println("[ST] Filler 2: dispensing.");//sysj\stationStubs.sysj line: 41, column: 4
                t_thread_3 = FILL_thread_3;//sysj\stationStubs.sysj line: 42, column: 4
                S4019=1;
                if(t_thread_3 > 0){//sysj\stationStubs.sysj line: 43, column: 10
                  t_thread_3 = t_thread_3 - 1;//sysj\stationStubs.sysj line: 43, column: 18
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  ends[3]=2;
                  ;//sysj\stationStubs.sysj line: 43, column: 4
                  System.out.println("[ST] Filler 2: complete.");//sysj\stationStubs.sysj line: 44, column: 4
                  fillerDone2.setPresent();//sysj\stationStubs.sysj line: 45, column: 4
                  currsigs.addElement(fillerDone2);
                  S4019=2;
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
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(!enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 48, column: 20
              S4019=0;
              if(enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 40, column: 20
                System.out.println("[ST] Filler 2: dispensing.");//sysj\stationStubs.sysj line: 41, column: 4
                t_thread_3 = FILL_thread_3;//sysj\stationStubs.sysj line: 42, column: 4
                S4019=1;
                if(t_thread_3 > 0){//sysj\stationStubs.sysj line: 43, column: 10
                  t_thread_3 = t_thread_3 - 1;//sysj\stationStubs.sysj line: 43, column: 18
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  ends[3]=2;
                  ;//sysj\stationStubs.sysj line: 43, column: 4
                  System.out.println("[ST] Filler 2: complete.");//sysj\stationStubs.sysj line: 44, column: 4
                  fillerDone2.setPresent();//sysj\stationStubs.sysj line: 45, column: 4
                  currsigs.addElement(fillerDone2);
                  S4019=2;
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

  public void thread4632(int [] tdone, int [] ends){
        switch(S4017){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3817){
          case 0 : 
            if(enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 25, column: 20
              System.out.println("[ST] Filler 1: dispensing.");//sysj\stationStubs.sysj line: 26, column: 4
              t_thread_2 = FILL_thread_2;//sysj\stationStubs.sysj line: 27, column: 4
              S3817=1;
              if(t_thread_2 > 0){//sysj\stationStubs.sysj line: 28, column: 10
                t_thread_2 = t_thread_2 - 1;//sysj\stationStubs.sysj line: 28, column: 18
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                ends[2]=2;
                ;//sysj\stationStubs.sysj line: 28, column: 4
                System.out.println("[ST] Filler 1: complete.");//sysj\stationStubs.sysj line: 29, column: 4
                fillerDone1.setPresent();//sysj\stationStubs.sysj line: 30, column: 4
                currsigs.addElement(fillerDone1);
                S3817=2;
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
            if(t_thread_2 > 0){//sysj\stationStubs.sysj line: 28, column: 10
              t_thread_2 = t_thread_2 - 1;//sysj\stationStubs.sysj line: 28, column: 18
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\stationStubs.sysj line: 28, column: 4
              System.out.println("[ST] Filler 1: complete.");//sysj\stationStubs.sysj line: 29, column: 4
              fillerDone1.setPresent();//sysj\stationStubs.sysj line: 30, column: 4
              currsigs.addElement(fillerDone1);
              S3817=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S3817=2;
            fillerDone1.setPresent();//sysj\stationStubs.sysj line: 31, column: 4
            currsigs.addElement(fillerDone1);
            S3817=3;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 3 : 
            S3817=3;
            fillerDone1.setPresent();//sysj\stationStubs.sysj line: 32, column: 4
            currsigs.addElement(fillerDone1);
            S3817=4;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 4 : 
            S3817=4;
            S3817=5;
            if(!enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 33, column: 20
              S3817=0;
              if(enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 25, column: 20
                System.out.println("[ST] Filler 1: dispensing.");//sysj\stationStubs.sysj line: 26, column: 4
                t_thread_2 = FILL_thread_2;//sysj\stationStubs.sysj line: 27, column: 4
                S3817=1;
                if(t_thread_2 > 0){//sysj\stationStubs.sysj line: 28, column: 10
                  t_thread_2 = t_thread_2 - 1;//sysj\stationStubs.sysj line: 28, column: 18
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  ends[2]=2;
                  ;//sysj\stationStubs.sysj line: 28, column: 4
                  System.out.println("[ST] Filler 1: complete.");//sysj\stationStubs.sysj line: 29, column: 4
                  fillerDone1.setPresent();//sysj\stationStubs.sysj line: 30, column: 4
                  currsigs.addElement(fillerDone1);
                  S3817=2;
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
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 5 : 
            if(!enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 33, column: 20
              S3817=0;
              if(enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 25, column: 20
                System.out.println("[ST] Filler 1: dispensing.");//sysj\stationStubs.sysj line: 26, column: 4
                t_thread_2 = FILL_thread_2;//sysj\stationStubs.sysj line: 27, column: 4
                S3817=1;
                if(t_thread_2 > 0){//sysj\stationStubs.sysj line: 28, column: 10
                  t_thread_2 = t_thread_2 - 1;//sysj\stationStubs.sysj line: 28, column: 18
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  ends[2]=2;
                  ;//sysj\stationStubs.sysj line: 28, column: 4
                  System.out.println("[ST] Filler 1: complete.");//sysj\stationStubs.sysj line: 29, column: 4
                  fillerDone1.setPresent();//sysj\stationStubs.sysj line: 30, column: 4
                  currsigs.addElement(fillerDone1);
                  S3817=2;
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
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4630(int [] tdone, int [] ends){
        S4623=1;
    CAP_thread_5 = 12;//sysj\stationStubs.sysj line: 68, column: 3
    S4423=0;
    if(enableCapper.getprestatus()){//sysj\stationStubs.sysj line: 70, column: 20
      System.out.println("[ST] Capper: screwing cap.");//sysj\stationStubs.sysj line: 71, column: 4
      t_thread_5 = CAP_thread_5;//sysj\stationStubs.sysj line: 72, column: 4
      S4423=1;
      if(t_thread_5 > 0){//sysj\stationStubs.sysj line: 73, column: 10
        t_thread_5 = t_thread_5 - 1;//sysj\stationStubs.sysj line: 73, column: 18
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        ends[5]=2;
        ;//sysj\stationStubs.sysj line: 73, column: 4
        System.out.println("[ST] Capper: complete.");//sysj\stationStubs.sysj line: 74, column: 4
        capperDone.setPresent();//sysj\stationStubs.sysj line: 75, column: 4
        currsigs.addElement(capperDone);
        S4423=2;
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

  public void thread4629(int [] tdone, int [] ends){
        S4421=1;
    LID_thread_4 = 4;//sysj\stationStubs.sysj line: 53, column: 3
    S4221=0;
    if(enableLid.getprestatus()){//sysj\stationStubs.sysj line: 55, column: 20
      System.out.println("[ST] Lid loader: placing lid.");//sysj\stationStubs.sysj line: 56, column: 4
      t_thread_4 = LID_thread_4;//sysj\stationStubs.sysj line: 57, column: 4
      S4221=1;
      if(t_thread_4 > 0){//sysj\stationStubs.sysj line: 58, column: 10
        t_thread_4 = t_thread_4 - 1;//sysj\stationStubs.sysj line: 58, column: 18
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        ends[4]=2;
        ;//sysj\stationStubs.sysj line: 58, column: 4
        System.out.println("[ST] Lid loader: complete.");//sysj\stationStubs.sysj line: 59, column: 4
        lidDone.setPresent();//sysj\stationStubs.sysj line: 60, column: 4
        currsigs.addElement(lidDone);
        S4221=2;
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

  public void thread4628(int [] tdone, int [] ends){
        S4219=1;
    FILL_thread_3 = 8;//sysj\stationStubs.sysj line: 38, column: 3
    S4019=0;
    if(enableFiller2.getprestatus()){//sysj\stationStubs.sysj line: 40, column: 20
      System.out.println("[ST] Filler 2: dispensing.");//sysj\stationStubs.sysj line: 41, column: 4
      t_thread_3 = FILL_thread_3;//sysj\stationStubs.sysj line: 42, column: 4
      S4019=1;
      if(t_thread_3 > 0){//sysj\stationStubs.sysj line: 43, column: 10
        t_thread_3 = t_thread_3 - 1;//sysj\stationStubs.sysj line: 43, column: 18
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        ends[3]=2;
        ;//sysj\stationStubs.sysj line: 43, column: 4
        System.out.println("[ST] Filler 2: complete.");//sysj\stationStubs.sysj line: 44, column: 4
        fillerDone2.setPresent();//sysj\stationStubs.sysj line: 45, column: 4
        currsigs.addElement(fillerDone2);
        S4019=2;
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

  public void thread4627(int [] tdone, int [] ends){
        S4017=1;
    FILL_thread_2 = 6;//sysj\stationStubs.sysj line: 23, column: 3
    S3817=0;
    if(enableFiller1.getprestatus()){//sysj\stationStubs.sysj line: 25, column: 20
      System.out.println("[ST] Filler 1: dispensing.");//sysj\stationStubs.sysj line: 26, column: 4
      t_thread_2 = FILL_thread_2;//sysj\stationStubs.sysj line: 27, column: 4
      S3817=1;
      if(t_thread_2 > 0){//sysj\stationStubs.sysj line: 28, column: 10
        t_thread_2 = t_thread_2 - 1;//sysj\stationStubs.sysj line: 28, column: 18
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        ends[2]=2;
        ;//sysj\stationStubs.sysj line: 28, column: 4
        System.out.println("[ST] Filler 1: complete.");//sysj\stationStubs.sysj line: 29, column: 4
        fillerDone1.setPresent();//sysj\stationStubs.sysj line: 30, column: 4
        currsigs.addElement(fillerDone1);
        S3817=2;
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
      switch(S4625){
        case 0 : 
          S4625=0;
          break RUN;
        
        case 1 : 
          S4625=2;
          S4625=2;
          thread4627(tdone,ends);
          thread4628(tdone,ends);
          thread4629(tdone,ends);
          thread4630(tdone,ends);
          int biggest4631 = 0;
          if(ends[2]>=biggest4631){
            biggest4631=ends[2];
          }
          if(ends[3]>=biggest4631){
            biggest4631=ends[3];
          }
          if(ends[4]>=biggest4631){
            biggest4631=ends[4];
          }
          if(ends[5]>=biggest4631){
            biggest4631=ends[5];
          }
          if(biggest4631 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread4632(tdone,ends);
          thread4633(tdone,ends);
          thread4634(tdone,ends);
          thread4635(tdone,ends);
          int biggest4636 = 0;
          if(ends[2]>=biggest4636){
            biggest4636=ends[2];
          }
          if(ends[3]>=biggest4636){
            biggest4636=ends[3];
          }
          if(ends[4]>=biggest4636){
            biggest4636=ends[4];
          }
          if(ends[5]>=biggest4636){
            biggest4636=ends[5];
          }
          if(biggest4636 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4636 == 0){
            S4625=0;
            active[1]=0;
            ends[1]=0;
            S4625=0;
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
          enable.gethook();
          enableFiller1.gethook();
          enableFiller2.gethook();
          enableLid.gethook();
          enableCapper.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      enableFiller1.setpreclear();
      enableFiller2.setpreclear();
      enableLid.setpreclear();
      enableCapper.setpreclear();
      fillerDone1.setpreclear();
      fillerDone2.setpreclear();
      lidDone.setpreclear();
      capperDone.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = enableFiller1.getStatus() ? enableFiller1.setprepresent() : enableFiller1.setpreclear();
      enableFiller1.setpreval(enableFiller1.getValue());
      enableFiller1.setClear();
      dummyint = enableFiller2.getStatus() ? enableFiller2.setprepresent() : enableFiller2.setpreclear();
      enableFiller2.setpreval(enableFiller2.getValue());
      enableFiller2.setClear();
      dummyint = enableLid.getStatus() ? enableLid.setprepresent() : enableLid.setpreclear();
      enableLid.setpreval(enableLid.getValue());
      enableLid.setClear();
      dummyint = enableCapper.getStatus() ? enableCapper.setprepresent() : enableCapper.setpreclear();
      enableCapper.setpreval(enableCapper.getValue());
      enableCapper.setClear();
      fillerDone1.sethook();
      fillerDone1.setClear();
      fillerDone2.sethook();
      fillerDone2.setClear();
      lidDone.sethook();
      lidDone.setClear();
      capperDone.sethook();
      capperDone.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        enableFiller1.gethook();
        enableFiller2.gethook();
        enableLid.gethook();
        enableCapper.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
