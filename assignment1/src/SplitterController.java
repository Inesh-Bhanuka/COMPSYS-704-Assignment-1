import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SplitterController extends ClockDomain{
  public SplitterController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal bottleAtSplitter = new Signal("bottleAtSplitter", Signal.INPUT);
  public Signal divertAtNormal = new Signal("divertAtNormal", Signal.INPUT);
  public Signal divertAtReject = new Signal("divertAtReject", Signal.INPUT);
  public Signal bottleLeftSplitter = new Signal("bottleLeftSplitter", Signal.INPUT);
  public Signal diverterExtendM = new Signal("diverterExtendM", Signal.INPUT);
  public Signal diverterRetractM = new Signal("diverterRetractM", Signal.INPUT);
  public Signal admitBottle = new Signal("admitBottle", Signal.OUTPUT);
  public Signal diverterExtend = new Signal("diverterExtend", Signal.OUTPUT);
  public Signal diverterRetract = new Signal("diverterRetract", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int FORWARD_thread_3;//sysj\splitterController.sysj line: 65, column: 3
  private int DIVERTED_thread_3;//sysj\splitterController.sysj line: 66, column: 3
  private int JAMMED_thread_3;//sysj\splitterController.sysj line: 67, column: 3
  private int STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 71, column: 3
  private WorkpieceTwin w_thread_3;//sysj\splitterController.sysj line: 73, column: 3
  private int t_thread_3;//sysj\splitterController.sysj line: 74, column: 3
  private int code_thread_3;//sysj\splitterController.sysj line: 75, column: 3
  private boolean reject_thread_3;//sysj\splitterController.sysj line: 76, column: 3
  private boolean confirmed_thread_3;//sysj\splitterController.sysj line: 77, column: 3
  private boolean cleared_thread_3;//sysj\splitterController.sysj line: 78, column: 3
  private boolean home_thread_3;//sysj\splitterController.sysj line: 79, column: 3
  private int S1118699 = 1;
  private int S300575 = 1;
  private int S1118545 = 1;
  private int S436904 = 1;
  private int S300600 = 1;
  private int S300584 = 1;
  private int S300579 = 1;
  private int S322375 = 1;
  private int S322370 = 1;
  private int S1118697 = 1;
  private int S1118595 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread1118707(int [] tdone, int [] ends){
        switch(S1118697){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1118595){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 174, column: 20
              S1118595=1;
              if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 175, column: 20
                S1118595=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 177, column: 14
                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 177, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                    currsigs.addElement(diverterRetract);
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
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                    currsigs.addElement(diverterRetract);
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
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 175, column: 20
              S1118595=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 177, column: 14
                diverterExtend.setPresent();//sysj\splitterController.sysj line: 177, column: 32
                currsigs.addElement(diverterExtend);
                if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                  currsigs.addElement(diverterRetract);
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
                if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                  currsigs.addElement(diverterRetract);
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
            }
            break;
          
          case 2 : 
            S1118595=2;
            S1118595=0;
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 174, column: 20
              S1118595=1;
              if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 175, column: 20
                S1118595=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 177, column: 14
                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 177, column: 32
                  currsigs.addElement(diverterExtend);
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                    currsigs.addElement(diverterRetract);
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
                  if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
                    currsigs.addElement(diverterRetract);
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

  public void thread1118706(int [] tdone, int [] ends){
        switch(S1118545){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S436904){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 82, column: 20
              S436904=1;
              if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 84, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S436904=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S300600=0;
                S300584=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 85, column: 5
                  enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                  S300584=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S300579=0;
                  if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                    enable_in.setACK(true);//sysj\splitterController.sysj line: 85, column: 5
                    S300579=1;
                    if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                      enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 85, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
                      S300600=1;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                        reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                        w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                        System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                        confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                        S300600=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                          if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                            diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                            currsigs.addElement(diverterExtend);
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                              currsigs.addElement(diverterRetract);
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                              currsigs.addElement(diverterRetract);
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 107, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                          S300600=3;
                          if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                            cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                            if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                              if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                                diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                                currsigs.addElement(diverterExtend);
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                  currsigs.addElement(diverterRetract);
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                  currsigs.addElement(diverterRetract);
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 126, column: 6
                              code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                              if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                                code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                              }
                              System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                              S300600=4;
                              if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 147, column: 6
                                  home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                  S300600=5;
                                  if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                    currsigs.addElement(diverterRetract);
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                      home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 156, column: 5
                                    S300600=6;
                                    S322375=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                      S322375=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S322370=0;
                                      if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                        S322370=1;
                                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 166, column: 5
                                          S436904=2;
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
                                home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                S300600=5;
                                if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                    home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 156, column: 5
                                  S300600=6;
                                  S322375=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    S322375=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S322370=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                      S322370=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 166, column: 5
                                        S436904=2;
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
                          }
                          else {
                            S300600=4;
                            if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                              System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                              w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                              cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                              if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                  cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 147, column: 6
                                home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                S300600=5;
                                if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                    home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 156, column: 5
                                  S300600=6;
                                  S322375=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    S322375=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S322370=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                      S322370=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 166, column: 5
                                        S436904=2;
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
                              home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                              S300600=5;
                              if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                  home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 156, column: 5
                                S300600=6;
                                S322375=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  S322375=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S322370=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                    S322370=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 166, column: 5
                                      S436904=2;
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
                        }
                      }
                      else {
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                        currsigs.addElement(admitBottle);
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
            if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 84, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S436904=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S300600){
                case 0 : 
                  switch(S300584){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 85, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                        S300584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S300579){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                              enable_in.setACK(true);//sysj\splitterController.sysj line: 85, column: 5
                              S300579=1;
                              if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                                enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 85, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
                                S300600=1;
                                if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                                  reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                                  w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                                  System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                                  t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                                  confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                                  S300600=2;
                                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                                      currsigs.addElement(diverterExtend);
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                        currsigs.addElement(diverterRetract);
                                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                        currsigs.addElement(diverterRetract);
                                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 107, column: 5
                                    code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                                    S300600=3;
                                    if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                                        if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                                          currsigs.addElement(diverterExtend);
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                            currsigs.addElement(diverterRetract);
                                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                            currsigs.addElement(diverterRetract);
                                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 126, column: 6
                                        code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                                        if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                                          code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                                        }
                                        System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                                        S300600=4;
                                        if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                          w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                          cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                          if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 147, column: 6
                                            home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                            S300600=5;
                                            if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                              currsigs.addElement(diverterRetract);
                                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                                home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                              ends[3]=2;
                                              ;//sysj\splitterController.sysj line: 156, column: 5
                                              S300600=6;
                                              S322375=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                S322375=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S322370=0;
                                                if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                                  S322370=1;
                                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\splitterController.sysj line: 166, column: 5
                                                    S436904=2;
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
                                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                          S300600=5;
                                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                            currsigs.addElement(diverterRetract);
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 156, column: 5
                                            S300600=6;
                                            S322375=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              S322375=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S322370=0;
                                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                                S322370=1;
                                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                                  S436904=2;
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
                                    }
                                    else {
                                      S300600=4;
                                      if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                        System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                        w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                        cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                        if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 147, column: 6
                                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                          S300600=5;
                                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                            currsigs.addElement(diverterRetract);
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 156, column: 5
                                            S300600=6;
                                            S322375=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              S322375=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S322370=0;
                                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                                S322370=1;
                                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                                  S436904=2;
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
                                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                        S300600=5;
                                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                          currsigs.addElement(diverterRetract);
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 156, column: 5
                                          S300600=6;
                                          S322375=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                            S322375=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S322370=0;
                                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                              S322370=1;
                                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                ends[3]=2;
                                                ;//sysj\splitterController.sysj line: 166, column: 5
                                                S436904=2;
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
                                  }
                                }
                                else {
                                  admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                                  currsigs.addElement(admitBottle);
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
                          
                          case 1 : 
                            if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                              enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 85, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
                              S300600=1;
                              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                                reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                                w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                                System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                                confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                                S300600=2;
                                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                                  if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                                    diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                                    currsigs.addElement(diverterExtend);
                                    if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                      currsigs.addElement(diverterRetract);
                                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                      currsigs.addElement(diverterRetract);
                                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 107, column: 5
                                  code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                                  S300600=3;
                                  if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                                    cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                                    if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                                      if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                                        currsigs.addElement(diverterExtend);
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                          currsigs.addElement(diverterRetract);
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                          currsigs.addElement(diverterRetract);
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 126, column: 6
                                      code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                                      if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                                        code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                                      }
                                      System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                                      S300600=4;
                                      if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                        System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                        w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                        cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                        if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 147, column: 6
                                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                          S300600=5;
                                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                            currsigs.addElement(diverterRetract);
                                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 156, column: 5
                                            S300600=6;
                                            S322375=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              S322375=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S322370=0;
                                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                                S322370=1;
                                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                                  S436904=2;
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
                                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                        S300600=5;
                                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                          currsigs.addElement(diverterRetract);
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 156, column: 5
                                          S300600=6;
                                          S322375=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                            S322375=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S322370=0;
                                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                              S322370=1;
                                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                ends[3]=2;
                                                ;//sysj\splitterController.sysj line: 166, column: 5
                                                S436904=2;
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
                                  }
                                  else {
                                    S300600=4;
                                    if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                      System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                      w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 147, column: 6
                                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                        S300600=5;
                                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                          currsigs.addElement(diverterRetract);
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 156, column: 5
                                          S300600=6;
                                          S322375=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                            S322375=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S322370=0;
                                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                              S322370=1;
                                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                ends[3]=2;
                                                ;//sysj\splitterController.sysj line: 166, column: 5
                                                S436904=2;
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
                                      home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                      S300600=5;
                                      if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                        currsigs.addElement(diverterRetract);
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                          home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 156, column: 5
                                        S300600=6;
                                        S322375=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                          S322375=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S322370=0;
                                          if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                            S322370=1;
                                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              ends[3]=2;
                                              ;//sysj\splitterController.sysj line: 166, column: 5
                                              S436904=2;
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
                                }
                              }
                              else {
                                admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                                currsigs.addElement(admitBottle);
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
                      }
                      break;
                    
                    case 1 : 
                      S300584=1;
                      S300584=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 85, column: 5
                        enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                        S300584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S300579=0;
                        if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                          enable_in.setACK(true);//sysj\splitterController.sysj line: 85, column: 5
                          S300579=1;
                          if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                            enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 85, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
                            S300600=1;
                            if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                              reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                              w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                              System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                              t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                              confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                              S300600=2;
                              if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                                if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                                  diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                                  currsigs.addElement(diverterExtend);
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                    currsigs.addElement(diverterRetract);
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                      if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                        confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                      if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                        confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                                    currsigs.addElement(diverterRetract);
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                      if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                        confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                      if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                        confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 107, column: 5
                                code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                                S300600=3;
                                if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                                  cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                                  if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                                    if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                                      currsigs.addElement(diverterExtend);
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                        currsigs.addElement(diverterRetract);
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                      if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                        currsigs.addElement(diverterRetract);
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 126, column: 6
                                    code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                                    if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                                      code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                                    }
                                    System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                                    S300600=4;
                                    if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                      System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                      w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 147, column: 6
                                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                        S300600=5;
                                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                          currsigs.addElement(diverterRetract);
                                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 156, column: 5
                                          S300600=6;
                                          S322375=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                            S322375=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S322370=0;
                                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                              S322370=1;
                                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                                ends[3]=2;
                                                ;//sysj\splitterController.sysj line: 166, column: 5
                                                S436904=2;
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
                                      home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                      S300600=5;
                                      if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                        currsigs.addElement(diverterRetract);
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                          home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 156, column: 5
                                        S300600=6;
                                        S322375=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                          S322375=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S322370=0;
                                          if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                            S322370=1;
                                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              ends[3]=2;
                                              ;//sysj\splitterController.sysj line: 166, column: 5
                                              S436904=2;
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
                                }
                                else {
                                  S300600=4;
                                  if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                    System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                    w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                    cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                    if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                      if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                        cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 147, column: 6
                                      home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                      S300600=5;
                                      if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                        currsigs.addElement(diverterRetract);
                                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                          home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 156, column: 5
                                        S300600=6;
                                        S322375=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                          S322375=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S322370=0;
                                          if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                            S322370=1;
                                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                              ends[3]=2;
                                              ;//sysj\splitterController.sysj line: 166, column: 5
                                              S436904=2;
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
                                    home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                    S300600=5;
                                    if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                      currsigs.addElement(diverterRetract);
                                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                        home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 156, column: 5
                                      S300600=6;
                                      S322375=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                        S322375=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S322370=0;
                                        if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                          S322370=1;
                                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                            ends[3]=2;
                                            ;//sysj\splitterController.sysj line: 166, column: 5
                                            S436904=2;
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
                              }
                            }
                            else {
                              admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                              currsigs.addElement(admitBottle);
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
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                    reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                    w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                    System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                    t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                    confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                    S300600=2;
                    if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                      if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                        currsigs.addElement(diverterExtend);
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                          currsigs.addElement(diverterRetract);
                          if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                            if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                    }
                    else {
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 107, column: 5
                      code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                      S300600=3;
                      if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                        cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                        if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                          if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                            diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                            currsigs.addElement(diverterExtend);
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                              currsigs.addElement(diverterRetract);
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 126, column: 6
                          code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                          if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                            code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                          }
                          System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                          S300600=4;
                          if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                            System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                            w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                            cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                            if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                              if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 147, column: 6
                              home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                              S300600=5;
                              if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                  home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 156, column: 5
                                S300600=6;
                                S322375=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  S322375=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S322370=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                    S322370=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 166, column: 5
                                      S436904=2;
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
                            home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                            S300600=5;
                            if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 156, column: 5
                              S300600=6;
                              S322375=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                S322375=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S322370=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                  S322370=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 166, column: 5
                                    S436904=2;
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
                      }
                      else {
                        S300600=4;
                        if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                          w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                          cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                          if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 147, column: 6
                            home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                            S300600=5;
                            if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 156, column: 5
                              S300600=6;
                              S322375=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                S322375=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S322370=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                  S322370=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 166, column: 5
                                    S436904=2;
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
                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                          S300600=5;
                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 156, column: 5
                            S300600=6;
                            S322375=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              S322375=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S322370=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                S322370=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                  S436904=2;
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
                    }
                  }
                  else {
                    admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                    currsigs.addElement(admitBottle);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                    if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                      currsigs.addElement(diverterExtend);
                      if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                        currsigs.addElement(diverterRetract);
                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                        currsigs.addElement(diverterRetract);
                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                          if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    ends[3]=2;
                    ;//sysj\splitterController.sysj line: 107, column: 5
                    code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                    S300600=3;
                    if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                        if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                          diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                          currsigs.addElement(diverterExtend);
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                            currsigs.addElement(diverterRetract);
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                            currsigs.addElement(diverterRetract);
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                        ends[3]=2;
                        ;//sysj\splitterController.sysj line: 126, column: 6
                        code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                        if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                          code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                        }
                        System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                        S300600=4;
                        if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                          System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                          w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                          cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                          if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                            if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                              cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 147, column: 6
                            home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                            S300600=5;
                            if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                              currsigs.addElement(diverterRetract);
                              if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 156, column: 5
                              S300600=6;
                              S322375=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                S322375=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S322370=0;
                                if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                  S322370=1;
                                  if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 166, column: 5
                                    S436904=2;
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
                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                          S300600=5;
                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 156, column: 5
                            S300600=6;
                            S322375=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              S322375=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S322370=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                S322370=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                  S436904=2;
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
                    }
                    else {
                      S300600=4;
                      if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                        System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                        w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                        cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                        if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 147, column: 6
                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                          S300600=5;
                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 156, column: 5
                            S300600=6;
                            S322375=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              S322375=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S322370=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                S322370=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                  S436904=2;
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
                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                        S300600=5;
                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 156, column: 5
                          S300600=6;
                          S322375=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            S322375=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S322370=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                              S322370=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 166, column: 5
                                S436904=2;
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
                  }
                  break;
                
                case 3 : 
                  if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                    if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                      diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                      currsigs.addElement(diverterExtend);
                      if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                        currsigs.addElement(diverterRetract);
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                      if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                        currsigs.addElement(diverterRetract);
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                    ends[3]=2;
                    ;//sysj\splitterController.sysj line: 126, column: 6
                    code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                    if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                      code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                    }
                    System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                    S300600=4;
                    if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                      System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                      w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                        ends[3]=2;
                        ;//sysj\splitterController.sysj line: 147, column: 6
                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                        S300600=5;
                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 156, column: 5
                          S300600=6;
                          S322375=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            S322375=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S322370=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                              S322370=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 166, column: 5
                                S436904=2;
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
                      home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                      S300600=5;
                      if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                        currsigs.addElement(diverterRetract);
                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                          home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                        ends[3]=2;
                        ;//sysj\splitterController.sysj line: 156, column: 5
                        S300600=6;
                        S322375=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                          S322375=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S322370=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                            S322370=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 166, column: 5
                              S436904=2;
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
                  break;
                
                case 4 : 
                  if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                    if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                      cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                    ends[3]=2;
                    ;//sysj\splitterController.sysj line: 147, column: 6
                    home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                    S300600=5;
                    if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                      currsigs.addElement(diverterRetract);
                      if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                        home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 156, column: 5
                      S300600=6;
                      S322375=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                        S322375=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S322370=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                          S322370=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 166, column: 5
                            S436904=2;
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
                  break;
                
                case 5 : 
                  if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                    currsigs.addElement(diverterRetract);
                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                      home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                    ends[3]=2;
                    ;//sysj\splitterController.sysj line: 156, column: 5
                    S300600=6;
                    S322375=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                      S322375=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S322370=0;
                      if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                        status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                        S322370=1;
                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 166, column: 5
                          S436904=2;
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
                
                case 6 : 
                  switch(S322375){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                        S322375=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S322370){
                          case 0 : 
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                              S322370=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 166, column: 5
                                S436904=2;
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
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 166, column: 5
                              S436904=2;
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
                      S322375=1;
                      S322375=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                        S322375=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S322370=0;
                        if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                          S322370=1;
                          if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 166, column: 5
                            S436904=2;
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
            break;
          
          case 2 : 
            S436904=2;
            S436904=0;
            if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 82, column: 20
              S436904=1;
              if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 84, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S436904=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S300600=0;
                S300584=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 85, column: 5
                  enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                  S300584=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S300579=0;
                  if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                    enable_in.setACK(true);//sysj\splitterController.sysj line: 85, column: 5
                    S300579=1;
                    if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
                      enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 85, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
                      S300600=1;
                      if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                        reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                        w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                        System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                        t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                        confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                        S300600=2;
                        if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                          if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                            diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                            currsigs.addElement(diverterExtend);
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                              currsigs.addElement(diverterRetract);
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                              diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                              currsigs.addElement(diverterRetract);
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                                if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                                  confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                      confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                                    confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 107, column: 5
                          code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                          S300600=3;
                          if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                            cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                            if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                              if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                                diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                                currsigs.addElement(diverterExtend);
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                  currsigs.addElement(diverterRetract);
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                                  currsigs.addElement(diverterRetract);
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 126, column: 6
                              code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                              if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                                code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                              }
                              System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                              S300600=4;
                              if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                                System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                                w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                                cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                                if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                  if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                    cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 147, column: 6
                                  home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                  S300600=5;
                                  if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                    diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                    currsigs.addElement(diverterRetract);
                                    if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                      home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                    ends[3]=2;
                                    ;//sysj\splitterController.sysj line: 156, column: 5
                                    S300600=6;
                                    S322375=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                      S322375=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S322370=0;
                                      if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                        S322370=1;
                                        if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                          ends[3]=2;
                                          ;//sysj\splitterController.sysj line: 166, column: 5
                                          S436904=2;
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
                                home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                S300600=5;
                                if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                    home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 156, column: 5
                                  S300600=6;
                                  S322375=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    S322375=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S322370=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                      S322370=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 166, column: 5
                                        S436904=2;
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
                          }
                          else {
                            S300600=4;
                            if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                              System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                              w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                              cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                              if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                                if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                                  cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 147, column: 6
                                home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                                S300600=5;
                                if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                  diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                  currsigs.addElement(diverterRetract);
                                  if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                    home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 156, column: 5
                                  S300600=6;
                                  S322375=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                    S322375=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S322370=0;
                                    if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                      S322370=1;
                                      if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                        status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                        ends[3]=2;
                                        ;//sysj\splitterController.sysj line: 166, column: 5
                                        S436904=2;
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
                              home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                              S300600=5;
                              if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                                diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                                currsigs.addElement(diverterRetract);
                                if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                                  home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 156, column: 5
                                S300600=6;
                                S322375=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  S322375=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S322370=0;
                                  if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                    S322370=1;
                                    if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                      status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                      ends[3]=2;
                                      ;//sysj\splitterController.sysj line: 166, column: 5
                                      S436904=2;
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
                        }
                      }
                      else {
                        admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                        currsigs.addElement(admitBottle);
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

  public void thread1118705(int [] tdone, int [] ends){
        switch(S300575){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\splitterController.sysj line: 55, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 56, column: 8
            auto_1.setPresent();//sysj\splitterController.sysj line: 56, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\splitterController.sysj line: 57, column: 12
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

  public void thread1118703(int [] tdone, int [] ends){
        S1118697=1;
    S1118595=0;
    if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 174, column: 20
      S1118595=1;
      if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 175, column: 20
        S1118595=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(diverterExtendM.getprestatus()){//sysj\splitterController.sysj line: 177, column: 14
          diverterExtend.setPresent();//sysj\splitterController.sysj line: 177, column: 32
          currsigs.addElement(diverterExtend);
          if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
            diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
            currsigs.addElement(diverterRetract);
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
          if(diverterRetractM.getprestatus()){//sysj\splitterController.sysj line: 178, column: 14
            diverterRetract.setPresent();//sysj\splitterController.sysj line: 178, column: 33
            currsigs.addElement(diverterRetract);
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
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1118702(int [] tdone, int [] ends){
        S1118545=1;
    FORWARD_thread_3 = 0;//sysj\splitterController.sysj line: 65, column: 3
    DIVERTED_thread_3 = 1;//sysj\splitterController.sysj line: 66, column: 3
    JAMMED_thread_3 = 2;//sysj\splitterController.sysj line: 67, column: 3
    STROKE_TIMEOUT_thread_3 = PlantTiming.ticks(12);//sysj\splitterController.sysj line: 71, column: 3
    w_thread_3 = null;//sysj\splitterController.sysj line: 73, column: 3
    t_thread_3 = 0;//sysj\splitterController.sysj line: 74, column: 3
    code_thread_3 = 0;//sysj\splitterController.sysj line: 75, column: 3
    reject_thread_3 = false;//sysj\splitterController.sysj line: 76, column: 3
    confirmed_thread_3 = false;//sysj\splitterController.sysj line: 77, column: 3
    cleared_thread_3 = false;//sysj\splitterController.sysj line: 78, column: 3
    home_thread_3 = false;//sysj\splitterController.sysj line: 79, column: 3
    S436904=0;
    if(auto_1.getprestatus()){//sysj\splitterController.sysj line: 82, column: 20
      S436904=1;
      if(manual_1.getprestatus()){//sysj\splitterController.sysj line: 84, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S436904=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S300600=0;
        S300584=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\splitterController.sysj line: 85, column: 5
          enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
          S300584=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S300579=0;
          if(!enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
            enable_in.setACK(true);//sysj\splitterController.sysj line: 85, column: 5
            S300579=1;
            if(enable_in.isREQ()){//sysj\splitterController.sysj line: 85, column: 5
              enable_in.setACK(false);//sysj\splitterController.sysj line: 85, column: 5
              ends[3]=2;
              ;//sysj\splitterController.sysj line: 85, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\splitterController.sysj line: 86, column: 5
              S300600=1;
              if(bottleAtSplitter.getprestatus()){//sysj\splitterController.sysj line: 91, column: 21
                reject_thread_3 = w_thread_3.isRejected();//sysj\splitterController.sysj line: 96, column: 5
                w_thread_3.arrived(Machine.SPLITTER);//sysj\splitterController.sysj line: 97, column: 5
                System.out.println("[SP] " + w_thread_3 + " at the decision point - " + (reject_thread_3 ? "reject path (" + w_thread_3.defect() + ")" : "normal path") + ".");//sysj\splitterController.sysj line: 98, column: 5
                t_thread_3 = STROKE_TIMEOUT_thread_3;//sysj\splitterController.sysj line: 105, column: 5
                confirmed_thread_3 = false;//sysj\splitterController.sysj line: 106, column: 5
                S300600=2;
                if(t_thread_3 > 0 && !confirmed_thread_3){//sysj\splitterController.sysj line: 107, column: 11
                  if(reject_thread_3){//sysj\splitterController.sysj line: 108, column: 6
                    diverterExtend.setPresent();//sysj\splitterController.sysj line: 108, column: 18
                    currsigs.addElement(diverterExtend);
                    if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                      currsigs.addElement(diverterRetract);
                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    if(!reject_thread_3){//sysj\splitterController.sysj line: 109, column: 9
                      diverterRetract.setPresent();//sysj\splitterController.sysj line: 109, column: 19
                      currsigs.addElement(diverterRetract);
                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      if(reject_thread_3){//sysj\splitterController.sysj line: 110, column: 6
                        if(divertAtReject.getprestatus()){//sysj\splitterController.sysj line: 111, column: 15
                          confirmed_thread_3 = true;//sysj\splitterController.sysj line: 111, column: 32
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                              confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 113, column: 9
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 114, column: 15
                            confirmed_thread_3 = true;//sysj\splitterController.sysj line: 114, column: 32
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          t_thread_3 = t_thread_3 - 1;//sysj\splitterController.sysj line: 116, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  ends[3]=2;
                  ;//sysj\splitterController.sysj line: 107, column: 5
                  code_thread_3 = JAMMED_thread_3;//sysj\splitterController.sysj line: 120, column: 5
                  S300600=3;
                  if(confirmed_thread_3){//sysj\splitterController.sysj line: 122, column: 5
                    cleared_thread_3 = false;//sysj\splitterController.sysj line: 125, column: 6
                    if(!cleared_thread_3){//sysj\splitterController.sysj line: 126, column: 12
                      if(reject_thread_3){//sysj\splitterController.sysj line: 127, column: 7
                        diverterExtend.setPresent();//sysj\splitterController.sysj line: 127, column: 19
                        currsigs.addElement(diverterExtend);
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                          currsigs.addElement(diverterRetract);
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                        if(!reject_thread_3){//sysj\splitterController.sysj line: 128, column: 10
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 128, column: 20
                          currsigs.addElement(diverterRetract);
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 129, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 129, column: 36
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
                      ends[3]=2;
                      ;//sysj\splitterController.sysj line: 126, column: 6
                      code_thread_3 = FORWARD_thread_3;//sysj\splitterController.sysj line: 132, column: 6
                      if(reject_thread_3) {//sysj\splitterController.sysj line: 133, column: 16
                        code_thread_3 = DIVERTED_thread_3;//sysj\splitterController.sysj line: 133, column: 18
                      }
                      System.out.println("[SP] " + w_thread_3 + " released down the " + (reject_thread_3 ? "reject path to the recycling conveyor" : "normal path to the labeller") + ".");//sysj\splitterController.sysj line: 134, column: 6
                      S300600=4;
                      if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                        System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                        w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                        cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                        if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                          if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                            cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 147, column: 6
                          home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                          S300600=5;
                          if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                            diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                            currsigs.addElement(diverterRetract);
                            if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                              home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                            ends[3]=2;
                            ;//sysj\splitterController.sysj line: 156, column: 5
                            S300600=6;
                            S322375=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              S322375=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S322370=0;
                              if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                                S322370=1;
                                if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                  status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                  ends[3]=2;
                                  ;//sysj\splitterController.sysj line: 166, column: 5
                                  S436904=2;
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
                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                        S300600=5;
                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 156, column: 5
                          S300600=6;
                          S322375=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            S322375=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S322370=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                              S322370=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 166, column: 5
                                S436904=2;
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
                  }
                  else {
                    S300600=4;
                    if(!confirmed_thread_3){//sysj\splitterController.sysj line: 138, column: 8
                      System.out.println("[SP] FAULT: diverter did not reach the " + (reject_thread_3 ? "reject" : "normal") + " position for " + w_thread_3 + ".");//sysj\splitterController.sysj line: 143, column: 6
                      w_thread_3.reject(Machine.SPLITTER, "diverter jammed");//sysj\splitterController.sysj line: 145, column: 6
                      cleared_thread_3 = false;//sysj\splitterController.sysj line: 146, column: 6
                      if(!cleared_thread_3){//sysj\splitterController.sysj line: 147, column: 12
                        if(bottleLeftSplitter.getprestatus()){//sysj\splitterController.sysj line: 148, column: 15
                          cleared_thread_3 = true;//sysj\splitterController.sysj line: 148, column: 36
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
                        ends[3]=2;
                        ;//sysj\splitterController.sysj line: 147, column: 6
                        home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                        S300600=5;
                        if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                          diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                          currsigs.addElement(diverterRetract);
                          if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                            home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                          ends[3]=2;
                          ;//sysj\splitterController.sysj line: 156, column: 5
                          S300600=6;
                          S322375=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                            S322375=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S322370=0;
                            if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                              S322370=1;
                              if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                                status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                                ends[3]=2;
                                ;//sysj\splitterController.sysj line: 166, column: 5
                                S436904=2;
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
                      home_thread_3 = false;//sysj\splitterController.sysj line: 155, column: 5
                      S300600=5;
                      if(!home_thread_3){//sysj\splitterController.sysj line: 156, column: 11
                        diverterRetract.setPresent();//sysj\splitterController.sysj line: 157, column: 6
                        currsigs.addElement(diverterRetract);
                        if(divertAtNormal.getprestatus()){//sysj\splitterController.sysj line: 158, column: 14
                          home_thread_3 = true;//sysj\splitterController.sysj line: 158, column: 31
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
                        ends[3]=2;
                        ;//sysj\splitterController.sysj line: 156, column: 5
                        S300600=6;
                        S322375=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\splitterController.sysj line: 166, column: 5
                          status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                          S322375=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S322370=0;
                          if(status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\splitterController.sysj line: 166, column: 5
                            S322370=1;
                            if(!status_o.isACK()){//sysj\splitterController.sysj line: 166, column: 5
                              status_o.setREQ(false);//sysj\splitterController.sysj line: 166, column: 5
                              ends[3]=2;
                              ;//sysj\splitterController.sysj line: 166, column: 5
                              S436904=2;
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
                }
              }
              else {
                admitBottle.setPresent();//sysj\splitterController.sysj line: 92, column: 6
                currsigs.addElement(admitBottle);
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
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread1118701(int [] tdone, int [] ends){
        S300575=1;
    if(mode.getprestatus()){//sysj\splitterController.sysj line: 55, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\splitterController.sysj line: 56, column: 8
        auto_1.setPresent();//sysj\splitterController.sysj line: 56, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\splitterController.sysj line: 57, column: 12
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
      switch(S1118699){
        case 0 : 
          S1118699=0;
          break RUN;
        
        case 1 : 
          S1118699=2;
          S1118699=2;
          auto_1.setClear();//sysj\splitterController.sysj line: 51, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 51, column: 2
          thread1118701(tdone,ends);
          thread1118702(tdone,ends);
          thread1118703(tdone,ends);
          int biggest1118704 = 0;
          if(ends[2]>=biggest1118704){
            biggest1118704=ends[2];
          }
          if(ends[3]>=biggest1118704){
            biggest1118704=ends[3];
          }
          if(ends[4]>=biggest1118704){
            biggest1118704=ends[4];
          }
          if(biggest1118704 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\splitterController.sysj line: 51, column: 2
          manual_1.setClear();//sysj\splitterController.sysj line: 51, column: 2
          thread1118705(tdone,ends);
          thread1118706(tdone,ends);
          thread1118707(tdone,ends);
          int biggest1118708 = 0;
          if(ends[2]>=biggest1118708){
            biggest1118708=ends[2];
          }
          if(ends[3]>=biggest1118708){
            biggest1118708=ends[3];
          }
          if(ends[4]>=biggest1118708){
            biggest1118708=ends[4];
          }
          if(biggest1118708 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1118708 == 0){
            S1118699=0;
            active[1]=0;
            ends[1]=0;
            S1118699=0;
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
          enable_in.gethook();
          status_o.gethook();
          mode.gethook();
          bottleAtSplitter.gethook();
          divertAtNormal.gethook();
          divertAtReject.gethook();
          bottleLeftSplitter.gethook();
          diverterExtendM.gethook();
          diverterRetractM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtSplitter.setpreclear();
      divertAtNormal.setpreclear();
      divertAtReject.setpreclear();
      bottleLeftSplitter.setpreclear();
      diverterExtendM.setpreclear();
      diverterRetractM.setpreclear();
      admitBottle.setpreclear();
      diverterExtend.setpreclear();
      diverterRetract.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = bottleAtSplitter.getStatus() ? bottleAtSplitter.setprepresent() : bottleAtSplitter.setpreclear();
      bottleAtSplitter.setpreval(bottleAtSplitter.getValue());
      bottleAtSplitter.setClear();
      dummyint = divertAtNormal.getStatus() ? divertAtNormal.setprepresent() : divertAtNormal.setpreclear();
      divertAtNormal.setpreval(divertAtNormal.getValue());
      divertAtNormal.setClear();
      dummyint = divertAtReject.getStatus() ? divertAtReject.setprepresent() : divertAtReject.setpreclear();
      divertAtReject.setpreval(divertAtReject.getValue());
      divertAtReject.setClear();
      dummyint = bottleLeftSplitter.getStatus() ? bottleLeftSplitter.setprepresent() : bottleLeftSplitter.setpreclear();
      bottleLeftSplitter.setpreval(bottleLeftSplitter.getValue());
      bottleLeftSplitter.setClear();
      dummyint = diverterExtendM.getStatus() ? diverterExtendM.setprepresent() : diverterExtendM.setpreclear();
      diverterExtendM.setpreval(diverterExtendM.getValue());
      diverterExtendM.setClear();
      dummyint = diverterRetractM.getStatus() ? diverterRetractM.setprepresent() : diverterRetractM.setpreclear();
      diverterRetractM.setpreval(diverterRetractM.getValue());
      diverterRetractM.setClear();
      admitBottle.sethook();
      admitBottle.setClear();
      diverterExtend.sethook();
      diverterExtend.setClear();
      diverterRetract.sethook();
      diverterRetract.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        bottleAtSplitter.gethook();
        divertAtNormal.gethook();
        divertAtReject.gethook();
        bottleLeftSplitter.gethook();
        diverterExtendM.gethook();
        diverterRetractM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
